
package Controladores;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

import Helpers.Helpers;
import Clases.Carton;

public class JuegoLineaController implements Initializable {
    
    private Label labels[]= new Label[25];

    //Llamamos a las funciones desde helpers para obtener los datos de la partida
    Helpers helper = new Helpers();
    
    //Hago instancia de un carton
    Carton carton= new Carton();
    
    private String numeros[] = carton.getNumeros();
    private int[] piedras = helper.getPiedras();
    
    //Label con el valor actual de la piedra
    @FXML
    private Label piedra;
    

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
        
        piedra.setText(Integer.toString(number));
        
        for (int i = 0; i < numeros.length; i++) {
            if((numeros[i] != "FREE") && (numeros[i] != "X")){
                if(number == Integer.parseInt(numeros[i])){
                    numeros[i] = "X";
                    
                    labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:white;"
                            );
                    
                    
                }
            }
        }
        
        System.out.println("\nEl número de la piedra es: " + Integer.toString(number));
        System.err.println("Cartón: ");
        for (int o = 0; o < numeros.length; o++) {
            System.out.print(numeros[o] + ",");
        }
        if(helper.verificarGanadaLinea(numeros).equals("ver1")) {
            
            for(int i=0;i<5;i++){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
        }
        else if(helper.verificarGanadaLinea(numeros).equals("ver2")){
            
            for(int i=5;i<10;i++){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("ver4")){
            for(int i=15;i<20;i++){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("ver5")){
            for(int i=20;i<25;i++){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("hor1")){
            
            for(int i=0;i<21;i+=5){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("hor2")){
            
            for(int i=1;i<22;i+=5){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("hor4")){
            
            for(int i=3;i<24;i+=5){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("hor5")){
            
            for(int i=4;i<25;i+=5){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("ver3")){
            
            for(int i=11;i<16;i++){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("hor3")){
            for(int i=2;i<23;i+=5){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("dia1")){
            
            for(int i=0;i<25;i+=6){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("dia2")){
            
            for(int i=4;i<25;i+=4){
                labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            }
            System.out.println(helper.verificarGanadaLinea(numeros));
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
        else if(helper.verificarGanadaLinea(numeros).equals("esq")){
            labels[0].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            labels[4].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            labels[20].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            labels[24].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: #10ff00;"
                            + "-fx-border-width: 3px;"
                            + "-fx-text-fill:#10ff00;");
            System.out.println(helper.verificarGanadaLinea(numeros));
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGOOOOO");
            
        }
    }
    
    @FXML
    //GridPane en donde se iran añadiendo los numeros
    private GridPane container;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        helper.gridPaneUnCarton(container);
        helper.completarGridPaneUnCarton(container, carton.getNumeros(), labels);
    }
}