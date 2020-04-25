
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
        helper.generarPiedras(number, letraFicha, piedra);
        carton1.piedraCorrecta(labels1,numerosCarton1,number);
        carton2.piedraCorrecta(labels2,numerosCarton2,number);
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
        helper.verificarGanadaLinea(numerosCarton1,labels1,bingo1,generador,piedra);
        helper.verificarGanadaLinea(numerosCarton2,labels2,bingo2,generador,piedra);
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
