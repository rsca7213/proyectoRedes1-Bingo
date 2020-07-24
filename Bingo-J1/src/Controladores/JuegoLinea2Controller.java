
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import Clases.Carton;
import Clases.Jugador;
import Helpers.Helpers;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Platform;
import javafx.scene.control.Button;

public class JuegoLinea2Controller implements Initializable {
    
    private boolean sender = false;
    private boolean senderBingo = false;
    private int numeroR;
    private boolean turno = false;
    
    private final SerialPort readPort = SerialPort.getCommPorts()[7];
    private final SerialPort writePort = SerialPort.getCommPorts()[0];
    
    public void enviarMensaje(String mensaje) {
        System.out.println("\n Enviando mensaje...");
        try {
            this.writePort.openPort();
            try (OutputStream out = this.writePort.getOutputStream()) {
                out.flush();
                System.out.println("String: " + mensaje); 
                //System.out.print("Bytes: ");
                System.out.println(Arrays.toString(mensaje.getBytes("ASCII")));
                out.write(mensaje.getBytes());
                System.out.println("Mensaje enviado! \n");
            }
            catch (Exception e) {
                System.err.println("Mensaje fallido! \n");
            }
            finally {
                writePort.closePort();
            }
        }
        catch(Exception e) {
            System.err.println("No se pudo abrir el puerto de escritura. \n");
        }
    }
    
    //Llamamos a las funciones desde helpers para obtener los datos de la partida
    Helpers helper = new Helpers();
    
    //Hago 2 instancias de carton
    Carton carton1 = new Carton();
    Carton carton2 = new Carton();
    
    //Se crea al jugador
    private Jugador jugador = new Jugador();
    
    //Creacion de labels y verificadores de bingo
    private Label labels1[]= new Label[25];
    private Label labels2[]= new Label[25];
    private String bingo1[]= new String[13];
    private String bingo2[]= new String[13];
    
    //Creacion de los numeros de cada carton y las piedras generadas
    private String numerosCarton1[] = carton1.getNumeros();
    private String numerosCarton2[] = carton2.getNumeros();
    private int[] piedras = helper.getPiedras();
    
    //Label con el valor actual de la piedra
    @FXML
    private Label piedra;    
    
    //Boton para generar las piedras
    @FXML
    private Button generador;

    /*
        Esta función se activa al darle click a "Jugar".
        Toma una piedra que no se haya elegido antes y si en el cartón
        del jugador está ese número, coloca una "X" donde iba dicho número
    */
    @FXML
    private void generar(ActionEvent event) {
        if(this.turno == false) return;
        sender = true;
        this.turno = false;
        this.generador.setText("No es tu turno");
        int number = helper.verificarPiedra(0);
        //System.out.println("\nLAS PIEDRAS");
        for (int i = 0; i < 75 && piedras[i] != 0; i++) {
            //System.out.print(piedras[i] + ",");
        }
        char letraFicha = ' ';
        helper.generarPiedras(number, letraFicha, piedra);
        carton1.piedraCorrecta(labels1,numerosCarton1,number);
        carton2.piedraCorrecta(labels2,numerosCarton2,number);
        //System.out.println("\nEl número de la piedra es: " + Integer.toString(number));
        //System.err.println("Cartones: ");
        for (int o = 0; o < numerosCarton1.length; o++) {
            //System.out.print(numerosCarton1[o] + ",");
        }
        //System.out.println("");
        for (int o = 0; o < numerosCarton2.length; o++) {
            //System.out.print(numerosCarton2[o] + ",");
        }
        for(int i=0;i<13;i++){
            bingo1[i]="vacio";  
            bingo2[i]="vacio";  
        }
        helper.verificarGanadaLinea(numerosCarton1,labels1,bingo1,generador,piedra);
        helper.verificarGanadaLinea(numerosCarton2,labels2,bingo2,generador,piedra);
        
        if("BINGOOO!".equals(generador.getText())) {
            senderBingo = true;
            enviarMensaje("B1-B" + Integer.toString(number) + "-O75");
        }
        else {
            enviarMensaje("B1-T" + Integer.toString(number) + "-O75");
        }
    }
    
    private void recibirJugada(int num) {
        int number = helper.verificarPiedra(num);
        //System.out.println("\nLAS PIEDRAS");
        for (int i = 0; i < 75 && piedras[i] != 0; i++) {
            //System.out.print(piedras[i] + ",");
        }
        char letraFicha = ' ';
        helper.generarPiedras(number, letraFicha, piedra);
        carton1.piedraCorrecta(labels1,numerosCarton1,number);
        carton2.piedraCorrecta(labels2,numerosCarton2,number);
        //System.out.println("\nEl número de la piedra es: " + Integer.toString(number));        
        //System.err.println("Cartón: ");
        for (int o = 0; o < numerosCarton2.length; o++) {
            //System.out.print(numeros[o] + ",");
        }
        for(int i=0;i<13;i++){
            bingo1[i]="vacio"; 
            bingo2[i]="vacio"; 
        }
        helper.verificarGanadaLinea(numerosCarton1,labels1,bingo1,generador,piedra);
        helper.verificarGanadaLinea(numerosCarton2,labels2,bingo2,generador,piedra);
    }
    
    @FXML
    //GridPane en donde se iran añadiendo los numeros
    private GridPane container1;
    
    @FXML
    private GridPane container2;
    
    private void checkAction(String mensaje) {
        
        int numero;
        
        // Caso en el q se recibe un mensaje pero no fue enviado por el
        if (sender == false) {
            
            //Caso en el q se recibe un mensaje con numero y indicador de turno
            if(mensaje.charAt(3) == 'T') {
                
                // Buscamos que numero salió
                if (mensaje.charAt(5) == '-') {
                    numero = Integer.parseInt(String.valueOf(mensaje.charAt(4)));
                    
                }
                else {
                    numero = Integer.parseInt(String.valueOf(mensaje.charAt(4)) + String.valueOf(mensaje.charAt(5)));
                }
                
                this.numeroR = numero;
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        setTurno(true);
                        recibirJugada(numeroR);
                        if("BINGOOO!".equals(generador.getText())) {
                            senderBingo = true;
                            sender = true;
                            enviarMensaje("B1-B" + Integer.toString(numero) + "-O75");
                        }
                        else {
                            enviarMensaje("B1-" + Integer.toString(numero) + "-O75");
                        }
                    }   
                });
            }
            
            //Caso en el q se recibe un bingo
            else if(mensaje.charAt(3) == 'B') {
                // Buscamos que numero salió
                if (mensaje.charAt(5) == '-') {
                    numero = Integer.parseInt(String.valueOf(mensaje.charAt(4)));
                }
                else {
                    numero = Integer.parseInt(String.valueOf(mensaje.charAt(4)) + String.valueOf(mensaje.charAt(5)));
                }
                
                this.numeroR = numero;
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        recibirJugada(numeroR);
                        generador.setText("Un jugador tiene bingo.");
                        generador.setStyle("-fx-background-color: #ff6666; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
                        
                    }   
                });
                
                enviarMensaje("B1-B" + Integer.toString(numero) + "-O75");
            }
            
            //Caso en el q se recibe un mensaje con numero sin indicador de turno
            else {
                // Buscamos que numero salió
                if (mensaje.charAt(4) == '-') {
                    numero = Integer.parseInt(String.valueOf(mensaje.charAt(3)));
                }
                else {
                    numero = Integer.parseInt(String.valueOf(mensaje.charAt(3)) + String.valueOf(mensaje.charAt(4)));
                }
                
                this.numeroR = numero;
                
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        recibirJugada(numeroR);
                        if("BINGOOO!".equals(generador.getText())) {
                            sender = true;
                            senderBingo = true;
                            enviarMensaje("B1-B" + Integer.toString(numero) + "-O75");
                        }
                        else {
                            enviarMensaje("B1-" + Integer.toString(numero) + "-O75");
                        }
                    }   
                });
            }
        }
        else {
            sender = false;
            if(senderBingo == false) {
                if(mensaje.charAt(3) == 'B') {
                    // Buscamos que numero salió
                    if (mensaje.charAt(5) == '-') {
                        numero = Integer.parseInt(String.valueOf(mensaje.charAt(4)));
                    }
                    else {
                        numero = Integer.parseInt(String.valueOf(mensaje.charAt(4)) + String.valueOf(mensaje.charAt(5)));
                    }
                
                    this.numeroR = numero;
                    
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            recibirJugada(numeroR);
                            generador.setText("Un jugador tiene bingo.");
                            generador.setStyle("-fx-background-color: #ff6666; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
                        
                        }   
                    });
                
                    enviarMensaje("B1-B" + Integer.toString(numero) + "-O75");
                }
            }
        }
    }
    
    public void setTurno (boolean turno) {
        this.turno = turno;
        this.generador.setText("Generar Número");
    }
    
    public void configurarEventoReceptor() {
        try {
            System.out.println("Configurando receptor...");
            readPort.openPort();
            readPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
            readPort.addDataListener(new SerialPortDataListener() {
                @Override
                public int getListeningEvents() {
                    return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                }

                @Override
                public void serialEvent(SerialPortEvent e) {
                    String mensaje = "";
                    if (e.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) return;
                    else {
                        System.out.println("Leyendo mensaje...");
                        try {
                            InputStream in = readPort.getInputStream();
                            System.out.print("Mensaje Recibido: \n String: ");
                            do {
                                mensaje += (char)in.read();
                            } while(readPort.bytesAvailable() > 0);
                            in.close();
                            System.out.println(mensaje + "\n");
                            checkAction(mensaje);
                        }
                        catch(IOException exception) {
                            System.err.println("Error leyendo mensaje!");
                        }
                        catch(Exception exception) {
                            System.err.println("Error leyendo mensaje!");
                        }
                    }
                }
            
            });     
            System.out.println("Receptor Configurado!");
        }
        catch (Exception e) {
            System.err.println("Error al configurar el evento para el puerto receptor!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugador.cartones = new ArrayList<Carton>();
        helper.gridPaneUnCarton(container1);
        helper.completarGridPaneUnCarton(container1, jugador.crearCartones(1), labels1);
        helper.gridPaneUnCarton(container2);
        helper.completarGridPaneUnCarton(container2, jugador.crearCartones(2), labels2);
        numerosCarton1 = jugador.cartones.get(0).getNumeros();
        numerosCarton2 = jugador.cartones.get(1).getNumeros();
        this.turno = false;
        this.generador.setText("No es tu turno");
        this.readPort.openPort();
        configurarEventoReceptor();
    }

}
