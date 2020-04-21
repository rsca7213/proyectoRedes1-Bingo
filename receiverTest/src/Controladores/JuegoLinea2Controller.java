
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import Clases.Carton;
import Helpers.Helpers;

public class JuegoLinea2Controller implements Initializable {
    
    //Llamamos a las funciones desde helpers para obtener los datos de la partida
    Helpers helper = new Helpers();
    
    //Hago instancia de un carton
    Carton carton1 = new Carton();
    Carton carton2 = new Carton();
    
    private String numerosCarton1[] = carton1.getNumeros();
    private String numerosCarton2[] = carton2.getNumeros();
    private int[] piedras = helper.getPiedras();
    
    //Label con el valor actual de la piedra
    @FXML
    private Label piedra;    
    
    //Funcion que determina las propiedades del GridPane
    private void gridPanePropiedades(){
        container.setHgap(5);
        container.setVgap(20);
        //container.setPadding(new Insets(35, 35, 35, 35));
    }
    
    //Funcion que agrega los valores al GridPane
    /*
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
        }/*
        if((helper.verificarGanadaLinea(numerosCarton1) == true) || (helper.verificarGanadaLinea(numerosCarton2) == true)) {
            System.out.println("\n¡FELICIDADES! Ha ganado el juego");
        }*/
    }
    
    @FXML
    //GridPane en donde se iran añadiendo los numeros
    private GridPane container;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gridPanePropiedades();
        //completarGridPane();
    }

}
