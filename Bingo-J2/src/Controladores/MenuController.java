
package Controladores;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    
    private final SerialPort readPort = SerialPort.getCommPorts()[1];
    private final SerialPort writePort = SerialPort.getCommPorts()[2];
    
    private boolean sender = false;

    @FXML
    private Button exitbtn;
    
    @FXML
    private Pane lineaPane;
    
    @FXML
    private Pane llenoPane;
    
    @FXML
    private RadioButton cart1;
    
    @FXML
    private RadioButton cart2;
    
    final ToggleGroup cartones = new ToggleGroup();
    
    private void juegoLinea() {
        try {
            this.readPort.closePort();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Vistas/juegoLinea.fxml"));  
            Parent page = loader.load();       
            JuegoLineaController controlador = loader.getController();
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego de Linea");
            stage.setX(400);
            stage.setY(50);       
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
            stage.setOnCloseRequest(e->{
                Platform.exit();
                System.exit(0);    
            });

            if (sender == true) {
                controlador.setTurno(true);
            }
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }
    
    private void juegoLinea2() {
        try {
            this.readPort.closePort();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Vistas/juegoLinea2.fxml"));  
            Parent page = loader.load();       
            JuegoLinea2Controller controlador = loader.getController();     
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego de Linea (2 cartones)");
            stage.setX(700);
            stage.setY(25);
            stage.setOnCloseRequest(e->{
                Platform.exit();
                System.exit(0);    
            });
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
            if (sender == true) {
                controlador.setTurno(true);
            }
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    private void juegoLleno() {
        try {
            this.readPort.closePort();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Vistas/juegoLleno.fxml"));  
            Parent page = loader.load();       
            JuegoLlenoController controlador = loader.getController();    
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego Cartón Lleno");
            stage.setX(400);
            stage.setY(50);
            stage.setOnCloseRequest(e->{
                Platform.exit();
                System.exit(0);    
            });
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
            if (sender == true) {
                controlador.setTurno(true);
            }
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }

    }
    
    private void juegoLleno2() {
        try {
            this.readPort.closePort();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Vistas/juegoLleno2.fxml"));  
            Parent page = loader.load();       
            JuegoLleno2Controller controlador = loader.getController();    
            Stage stage = (Stage) lineaPane.getScene().getWindow();
            Scene scene = new Scene(page);
            scene.getStylesheets().add(MenuController.class.getResource("../Estilos/JuegoLinea.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setTitle("Bingo: Juego Cartón Lleno (2 cartones)");
            stage.setX(700);
            stage.setY(25);
            stage.setOnCloseRequest(e->{
                Platform.exit();
                System.exit(0);    
            });
            stage.show();
            stage.setMinWidth(350);
            stage.setMinHeight(500);
            if (sender == true) {
                controlador.setTurno(true);
            }
            
        }
        catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    public void enviarMensaje(String mensaje) {
        System.out.println("\n Enviando mensaje...");
        try {
            this.writePort.openPort();
            try (OutputStream out = this.writePort.getOutputStream()) {
                out.flush();
                System.out.println("String: " + mensaje); 
                System.out.print("Bytes: ");
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
    
    public void checkAction(String mensaje) {
        if(sender == false) {
            enviarMensaje(mensaje);
            if("B1LI1O75".equals(mensaje))
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLinea();
                    }   
                });
            if("B1LI2O75".equals(mensaje))
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLinea2();
                    }   
                });
            if("B1LL1O75".equals(mensaje))
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLleno();
                    }   
                });
            if("B1LL2O75".equals(mensaje))
            Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLleno2();
                    }   
                });
        }
        else {
            if("B1LI1O75".equals(mensaje))
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLinea();
                    }   
                });
            if("B1LI2O75".equals(mensaje))
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLinea2();
                    }   
                });
            if("B1LL1O75".equals(mensaje))
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLleno();
                    }   
                });
            if("B1LL2O75".equals(mensaje))
            Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        juegoLleno2();
                    }   
                });
        }
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
    
    private void setHovers () {
        lineaPane.setOnMouseEntered((event) -> {
            lineaPane.setStyle("-fx-background-color: #c0c0c0;");
        });
        lineaPane.setOnMouseExited((event) -> {
            lineaPane.setStyle("-fx-background-color: transparent;");
        });
        llenoPane.setOnMouseEntered((event) -> {
            llenoPane.setStyle("-fx-background-color: #c0c0c0;");
        });
        llenoPane.setOnMouseExited((event) -> {
            llenoPane.setStyle("-fx-background-color: transparent;");
        });
        exitbtn.setOnMouseEntered((event) -> {
            exitbtn.setStyle("-fx-background-color: #1a75ff;");
        });
        exitbtn.setOnMouseExited((event) -> {
            exitbtn.setStyle("-fx-background-color: #4d94ff;");
        });
    }
    
    private void setClickEvents() {
        System.out.println("Controlador inicializado.");
        lineaPane.setOnMouseClicked((event) -> {
            if(cart1.isSelected()) {
                System.out.println("Opcion de juego de linea con 1 carton clickeado.");
                sender = true;
                enviarMensaje("B1LI1O75");
            }
            else {
                System.out.println("Opcion de juego de linea con 2 cartones clickeado.");
                sender = true;
                enviarMensaje("B1LI2O75");
            }
        });
        llenoPane.setOnMouseClicked((event) -> {
            if(cart1.isSelected()) {
                System.out.println("Opcion de juego de carton lleno con 1 carton clickeado.");
                sender = true;
                enviarMensaje("B1LL1O75");
            }
            else {
                System.out.println("Opcion de juego de carton lleno con 2 cartones clickeado.");
                sender = true;
                enviarMensaje("B1LL2O75");
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cart1.setToggleGroup(cartones);
        cart2.setToggleGroup(cartones);
        cart1.setSelected(true);
        System.out.println("Receptor: " + readPort);
        System.out.println("Escritor: " + writePort);
        configurarEventoReceptor();
        setClickEvents();
        setHovers();    
    }
    
    @FXML
    private void exitApp(ActionEvent event) {
        System.exit(0);
    }
    

}
