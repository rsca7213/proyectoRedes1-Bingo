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

public class JuegoLlenoController implements Initializable {
    
    private Label labels[]= new Label[25];
    
    //Llamamos a las funciones desde helpers para obtener los datos de la partida
    Helpers helper = new Helpers();
    
    //Hago instancia de un carton
    Carton carton= new Carton();
    
        //Se crea al jugador
    private Jugador jugador = new Jugador();
    
    private String numeros[] = carton.getNumeros();
    private int[] piedras = helper.getPiedras();
    
    //Label con el valor actual de la piedra
    @FXML
    private Label piedra; 
    
    //Boton que genera las piedras
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
        
        for (int i = 0; i < numeros.length; i++) {
            if((numeros[i] != "FREE") && (numeros[i] != "X")){
                if(number == Integer.parseInt(numeros[i])){
                    numeros[i] = "X";
                    
                    labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
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
        
        if(helper.verificarGanadaLleno(numeros) == true) {
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
            for(int i=0; i<25;i++){
                labels[i].setStyle("-fx-opacity:1;"
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
    
    @FXML
    //GridPane en donde se iran añadiendo los numeros
    private GridPane container;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugador.cartones = new ArrayList<Carton>();
        helper.gridPaneUnCarton(container);
        helper.completarGridPaneUnCarton(container, jugador.crearCartones(1),labels);
        numeros = jugador.cartones.get(0).getNumeros();
    }   
}