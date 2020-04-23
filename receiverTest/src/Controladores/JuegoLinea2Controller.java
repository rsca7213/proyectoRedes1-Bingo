
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

public class JuegoLinea2Controller implements Initializable {
    
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
        
        helper.verificarGanadaLinea(numerosCarton1,bingo1);
        helper.verificarGanadaLinea(numerosCarton2,bingo2);
        
        // <editor-fold defaultstate="collapsed" desc="verificaciones bingo carton 1">
        if(bingo1[0].equals("ver1")) {
            
            for(int i=0;i<5;i++){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
        }
        if(bingo1[1].equals("ver2")){
            
            for(int i=5;i<10;i++){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[2].equals("ver4")){
            for(int i=15;i<20;i++){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!"); 
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[3].equals("ver5")){
            for(int i=20;i<25;i++){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[4].equals("hor1")){
            
            for(int i=0;i<21;i+=5){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[5].equals("hor2")){
            
            for(int i=1;i<22;i+=5){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);  
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[6].equals("hor4")){
            
            for(int i=3;i<24;i+=5){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);   
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[7].equals("hor5")){
            
            for(int i=4;i<25;i+=5){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);    
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[8].equals("ver3")){
            
            for(int i=10;i<15;i++){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);    
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[9].equals("hor3")){
            for(int i=2;i<23;i+=5){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!");    
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[10].equals("dia1")){
            
            for(int i=0;i<25;i+=6){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);  
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[11].equals("dia2")){
            
            for(int i=4;i<21;i+=4){
                labels1[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo1[12].equals("esq")){
            labels1[0].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels1[4].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels1[20].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels1[24].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels1[12].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
        }
        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="verificacion bingo carton 2">
        if(bingo2[0].equals("ver1")) {
            
            for(int i=0;i<5;i++){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
        }
        if(bingo2[1].equals("ver2")){
            
            for(int i=5;i<10;i++){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[2].equals("ver4")){
            for(int i=15;i<20;i++){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!"); 
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[3].equals("ver5")){
            for(int i=20;i<25;i++){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[4].equals("hor1")){
            
            for(int i=0;i<21;i+=5){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[5].equals("hor2")){
            
            for(int i=1;i<22;i+=5){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);  
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[6].equals("hor4")){
            
            for(int i=3;i<24;i+=5){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);   
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[7].equals("hor5")){
            
            for(int i=4;i<25;i+=5){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);    
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[8].equals("ver3")){
            
            for(int i=10;i<15;i++){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);    
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[9].equals("hor3")){
            for(int i=2;i<23;i+=5){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            piedra.setVisible(false);
            generador.setDisable(true);
            generador.setText("BINGOOO!");    
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[10].equals("dia1")){
            
            for(int i=0;i<25;i+=6){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);  
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[11].equals("dia2")){
            
            for(int i=4;i<21;i+=4){
                labels2[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            }
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
            
        }
        if(bingo2[12].equals("esq")){
            labels2[0].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels2[4].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels2[20].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels2[24].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            labels2[12].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                        + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
            generador.setDisable(true);
            generador.setText("BINGOOO!");
            piedra.setVisible(false);
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            piedra.setText("BINGO");
            piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;"); 
        }
        // </editor-fold>
        
    }
    
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
