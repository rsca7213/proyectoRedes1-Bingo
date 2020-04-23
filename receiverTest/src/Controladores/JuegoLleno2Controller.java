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
import java.util.ArrayList;
import javafx.scene.control.Button;

public class JuegoLleno2Controller implements Initializable {
    
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
    //Funcion que determina las propiedades del GridPane
    private void gridPanePropiedades(){
        container.setHgap(5);
        container.setVgap(20);
        //container.setPadding(new Insets(35, 35, 35, 35));
    }
    
    //Funcion que agrega los valores al GridPane
    
    private void completarGridPane(){
        int cont = 0;
        
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 6; i++) {
                if (i == 0) {
                    String letra = "";
                    for (int z = 0; z < 5; z++) {
                        if (z == 0) {
                            letra = "B";
                        } else if (z == 1) {
                            letra = "I";
                        } else if (z == 2) {
                            letra = "N";
                        } else if (z == 3) {
                            letra = "G";
                        } else if (z == 4) {
                            letra = "O";
                        }
                        Label u14 = new Label(letra);
                        u14.setId("Letra");
                        container.add(u14, z, i, 1, 1);
                    }
                } else {
                    Label theLabel = new Label(numeros[cont]);
                    if(cont==12){
                    theLabel.setId("FREE");
                    }else{
                       theLabel.setId("col"+j);
                    }
                    container.add(theLabel, j, i, 1, 1);
                    
                    cont++;
                }
            }
        }
        System.out.println("El contador es: " + cont);
    }
    */


    /*
        Esta función se activa al darle click a "Jugar".
        Toma una piedra que no se haya elegido antes y si en el cartón
        del jugador está ese número, coloca una "X" donde iba dicho número
    */
    
    @FXML
    private void generar(ActionEvent event) {
        int number = helper.verificarPiedra();
        System.out.println("\nLAS PIEDRAS");
        for (int i = 0; i < 75 && piedras[i] != 0; i++) {
            System.out.print(piedras[i] + ",");
        }
        
        char letraFicha = ' ';
        if(number > 1 && number <= 15) {
            piedra.setStyle("-fx-background-color: #0049FF; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
            letraFicha = 'B';
        }
        else if(number > 15 && number <= 30) {
            piedra.setStyle("-fx-background-color: #F730D3; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
            letraFicha = 'I';
        }
        else if(number > 31 && number <= 45) {
            piedra.setStyle("-fx-background-color: #AA00FF; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
            letraFicha = 'N';
        }
        else if(number > 45 && number <= 60) {
            piedra.setStyle("-fx-background-color: #E98607; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
            letraFicha = 'G';
        }
        else {
            piedra.setStyle("-fx-background-color: #0049FF; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px;");
            letraFicha = 'O';
        }
        piedra.setText(letraFicha + " " + Integer.toString(number));
        
        for (int i = 0; i < numerosCarton1.length; i++) {
            if((numerosCarton1[i] != "FREE") && (numerosCarton1[i] != "X")){
                if(number == Integer.parseInt(numerosCarton1[i])){
                    numerosCarton1[i] = "X";
                    labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill:white;"
                            );
                }
            }
            if((numerosCarton2[i] != "FREE") && (numerosCarton2[i] != "X")){
                if(number == Integer.parseInt(numerosCarton2[i])){
                    numerosCarton2[i] = "X";
                    labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill:white;"
                            );
                }
            }
        }
        
        System.out.println("\nEl número de la piedra es: " + Integer.toString(number));
        System.err.println("Cartones: ");
        for (int o = 0; o < numerosCarton1.length; o++) {
            System.out.print(numerosCarton1[o] + ",");
        }
        System.out.println("");
        for (int o = 0; o < numerosCarton2.length; o++) {
            System.out.print(numerosCarton2[o] + ",");
        }
        
        for(int i=0;i<13;i++){
            bingo1[i]="vacio";  
            bingo2[i]="vacio";  
        }
        
        if(helper.verificarGanadaLleno(numerosCarton1) == true) {
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            for(int i=0; i<25;i++){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
        }
        
        if(helper.verificarGanadaLleno(numerosCarton2) == true) {
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            for(int i=0; i<25;i++){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
        }
    }
    
    
    /*
    @FXML
    private void generar(ActionEvent event) {
        int number = helper.verificarPiedra();
        System.out.println("\nLAS PIEDRAS");
        for (int i = 0; i < 75 && piedras[i] != 0; i++) {
            System.out.print(piedras[i] + ",");
        }
        
        piedra.setText(Integer.toString(number));
        
        for (int i = 0; i < numerosCarton1.length; i++) {
            if((numerosCarton1[i] != "FREE") && (numerosCarton1[i] != "X")){
                if(number == Integer.parseInt(numerosCarton1[i])){
                    numerosCarton1[i] = "X";
                }
            }
            if((numerosCarton2[i] != "FREE") && (numerosCarton2[i] != "X")){
                if(number == Integer.parseInt(numerosCarton2[i])){
                    numerosCarton2[i] = "X";
                }
            }
        }
        
        System.out.println("\nEl número de la piedra es: " + Integer.toString(number));
        System.err.println("Cartones: ");
        for (int o = 0; o < numerosCarton1.length; o++) {
            System.out.print(numerosCarton1[o] + ",");
        }
        for (int o = 0; o < numerosCarton2.length; o++) {
            System.out.print(numerosCarton2[o] + ",");
        }
        if((helper.verificarGanadaLleno(numerosCarton1) == true) || (helper.verificarGanadaLleno(numerosCarton2) == true)) {
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
        }
    }
    */    

    @FXML
    //GridPane en donde se iran añadiendo los numeros
    private GridPane container1;
    
    @FXML
    private GridPane container2;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugador.cartones = new ArrayList<Carton>();
        helper.gridPaneUnCarton(container1);
        helper.completarGridPaneUnCarton(container1, jugador.crearCartones(1), labels1);
        helper.gridPaneUnCarton(container2);
        helper.completarGridPaneUnCarton(container2, jugador.crearCartones(2), labels2);
        numerosCarton1 = jugador.cartones.get(0).getNumeros();
        numerosCarton2 = jugador.cartones.get(1).getNumeros();
    }
    
}