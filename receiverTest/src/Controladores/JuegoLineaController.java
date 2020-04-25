
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
import Clases.Jugador;
import java.util.ArrayList;
import javafx.scene.control.Button;

public class JuegoLineaController implements Initializable {
    
    private Label labels[]= new Label[25];
    private String bingo[]= new String[13];
    
    //Se crea al jugador
    private Jugador jugador = new Jugador();

    //Llamamos a las funciones desde helpers para obtener los datos de la partida
    Helpers helper = new Helpers();
    
    //Hago instancia de un carton
    Carton carton = new Carton();
    
    private String numeros[] = null;
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
        helper.generarPiedras(number, letraFicha, piedra);
        carton.piedraCorrecta(labels,numeros,number);
        System.out.println("\nEl número de la piedra es: " + Integer.toString(number));
        System.err.println("Cartón: ");
        for (int o = 0; o < numeros.length; o++) {
            System.out.print(numeros[o] + ",");
        }
        for(int i=0;i<13;i++){
            bingo[i]="vacio"; 
        }
        helper.verificarGanadaLinea(numeros,labels,bingo,generador,piedra);
    }
    
    @FXML
    //GridPane en donde se iran añadiendo los numeros
    private GridPane container;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jugador.cartones = new ArrayList<Carton>();
        helper.gridPaneUnCarton(container);
        helper.completarGridPaneUnCarton(container, jugador.crearCartones(1), labels);
        numeros = jugador.cartones.get(0).getNumeros();
    }
}