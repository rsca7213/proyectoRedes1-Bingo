
package Helpers;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Helpers {
    
    //Esta variable contendrá el valor de la piedra
    private int numPiedra = 0;
    
    //Array con las piedras ya jugadas
    private int[] piedras = new int[75];
    
    public int[] getPiedras() {
        return piedras;
    }
    
    //Verificar aciertos en linea vertical
    
    private int ver1(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 0)) contAciertos++;
            else if((numeros[i] == "X") && (i == 1)) contAciertos++;
            else if((numeros[i] == "X") && (i == 2)) contAciertos++;
            else if((numeros[i] == "X") && (i == 3)) contAciertos++;
            else if((numeros[i] == "X") && (i == 4)) contAciertos++;
        }
        return contAciertos;
    }

    private int ver2(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 5)) contAciertos++;
            else if((numeros[i] == "X") && (i == 6)) contAciertos++;
            else if((numeros[i] == "X") && (i == 7)) contAciertos++;
            else if((numeros[i] == "X") && (i == 8)) contAciertos++;
            else if((numeros[i] == "X") && (i == 9)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int ver3(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 10)) contAciertos++;
            else if((numeros[i] == "X") && (i == 11)) contAciertos++;
            else if((numeros[i] == "X") && (i == 13)) contAciertos++;
            else if((numeros[i] == "X") && (i == 14)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int ver4(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 15)) contAciertos++;
            else if((numeros[i] == "X") && (i == 16)) contAciertos++;
            else if((numeros[i] == "X") && (i == 17)) contAciertos++;
            else if((numeros[i] == "X") && (i == 18)) contAciertos++;
            else if((numeros[i] == "X") && (i == 19)) contAciertos++;
        }
        return contAciertos;
    }
       
    private int ver5(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 20)) contAciertos++;
            else if((numeros[i] == "X") && (i == 21)) contAciertos++;
            else if((numeros[i] == "X") && (i == 22)) contAciertos++;
            else if((numeros[i] == "X") && (i == 23)) contAciertos++;
            else if((numeros[i] == "X") && (i == 24)) contAciertos++;
        }
        return contAciertos;
    }
    
    //Verificar aciertos en linea horizontal
    
    private int hor1(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 0)) contAciertos++;
            else if((numeros[i] == "X") && (i == 5)) contAciertos++;
            else if((numeros[i] == "X") && (i == 10)) contAciertos++;
            else if((numeros[i] == "X") && (i == 15)) contAciertos++;
            else if((numeros[i] == "X") && (i == 20)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int hor2(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 1)) contAciertos++;
            else if((numeros[i] == "X") && (i == 6)) contAciertos++;
            else if((numeros[i] == "X") && (i == 11)) contAciertos++;
            else if((numeros[i] == "X") && (i == 16)) contAciertos++;
            else if((numeros[i] == "X") && (i == 21)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int hor3(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 2)) contAciertos++;
            else if((numeros[i] == "X") && (i == 7)) contAciertos++;
            else if((numeros[i] == "X") && (i == 17)) contAciertos++;
            else if((numeros[i] == "X") && (i == 22)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int hor4(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 3)) contAciertos++;
            else if((numeros[i] == "X") && (i == 8)) contAciertos++;
            else if((numeros[i] == "X") && (i == 13)) contAciertos++;
            else if((numeros[i] == "X") && (i == 18)) contAciertos++;
            else if((numeros[i] == "X") && (i == 23)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int hor5(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 4)) contAciertos++;
            else if((numeros[i] == "X") && (i == 9)) contAciertos++;
            else if((numeros[i] == "X") && (i == 14)) contAciertos++;
            else if((numeros[i] == "X") && (i == 19)) contAciertos++;
            else if((numeros[i] == "X") && (i == 24)) contAciertos++;
        }
        return contAciertos;
    }
    
    //Verificar aciertos en diagonal y en esquinas
    
    private int dia1(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 0)) contAciertos++;
            else if((numeros[i] == "X") && (i == 6)) contAciertos++;
            else if((numeros[i] == "X") && (i == 18)) contAciertos++;
            else if((numeros[i] == "X") && (i == 24)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int dia2(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 4)) contAciertos++;
            else if((numeros[i] == "X") && (i == 8)) contAciertos++;
            else if((numeros[i] == "X") && (i == 16)) contAciertos++;
            else if((numeros[i] == "X") && (i == 20)) contAciertos++;
        }
        return contAciertos;
    }
    
    private int esq(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if((numeros[i] == "X") && (i == 0)) contAciertos++;
            else if((numeros[i] == "X") && (i == 4)) contAciertos++;
            else if((numeros[i] == "X") && (i == 20)) contAciertos++;
            else if((numeros[i] == "X") && (i == 24)) contAciertos++;
        }
        return contAciertos;
    }
    
    public void verificarGanadaLinea(String[] numeros, String[] bingo) {
        
        /*if((ver1(numeros) == 5) || (ver2(numeros) == 5) || (ver4(numeros) == 5) || (ver5(numeros) == 5) || (hor1(numeros) == 5) || (hor2(numeros) == 5) || (hor4(numeros) == 5) || (hor5(numeros) == 5) || (ver3(numeros) == 4) || (hor3(numeros) == 4) || (dia1(numeros) == 4) || (dia2(numeros) == 4) || (esq(numeros) == 4)) {
            return true;
        }*/
        if(ver1(numeros) == 5){
            //return "ver1";
            bingo[0]="ver1";
        }
        if(ver2(numeros) == 5){
            //return "ver2";
            bingo[1]="ver2";
        }
        if(ver4(numeros) == 5){
            //return "ver4";
            bingo[2]="ver4";
        }
        if(ver5(numeros) == 5){
            //return "ver5";
            bingo[3]="ver5";
        }
        if(hor1(numeros) == 5){
            //return "hor1";
            bingo[4]="hor1";
        }
        if(hor2(numeros) == 5){
            //return "hor2";
            bingo[5]="hor2";
        }
        if(hor4(numeros) == 5){
            //return "hor4";
            bingo[6]="hor4";
        }
        if(hor5(numeros) == 5){
            //return "hor5";
            bingo[7]="hor5";
        }
        if(ver3(numeros) == 4){
            //return "ver3";
            bingo[8]="ver3";
        }
        if(hor3(numeros) == 4){
            //return "hor3";
            bingo[9]="hor3";
        }
        if(dia1(numeros) == 4){
            //return "dia1";
            bingo[10]="dia1";
        }
        if(dia2(numeros) == 4){
            //return "dia2";
            bingo[11]="dia2";
        }
        if(esq(numeros) == 4){
            //return "esq";
            bingo[12]="esq";
        }
        //return "nada";
        
    }    
    
    public boolean verificarGanadaLleno(String[] numeros) {
        int contAciertos = 0;
        
        for(int i = 0; i < numeros.length; i++) {
            if(numeros[i] == "X") {
                switch(i) {
                    case 0: contAciertos++;
                    case 1: contAciertos++;
                    case 2: contAciertos++;
                    case 3: contAciertos++;
                    case 4: contAciertos++;
                    case 5: contAciertos++;
                    case 6: contAciertos++;
                    case 7: contAciertos++;
                    case 8: contAciertos++;
                    case 9: contAciertos++;
                    case 10: contAciertos++;
                    case 11: contAciertos++;
                    case 13: contAciertos++;
                    case 14: contAciertos++;
                    case 15: contAciertos++;
                    case 16: contAciertos++;
                    case 17: contAciertos++;
                    case 18: contAciertos++;
                    case 19: contAciertos++;
                    case 20: contAciertos++;
                    case 21: contAciertos++;
                    case 22: contAciertos++;
                    case 23: contAciertos++;
                    case 24: contAciertos++;
                }
            }   
        }
        if(contAciertos == 24) return true;
        else return false;
    }
    
    //Verifico un número que no se haya jugado antes y lo agrego al array de las piedras
    public int verificarPiedra() {
        int number = (int) (Math.random() * 75)+1;
        boolean repetir = false;
        
        for(int i = 0; i < 75 && piedras[i] != 0; i++){
            if(piedras[i] == number){
               repetir = true;
               break;
            }
        }
        if(repetir){
            return verificarPiedra();
        }
        else{
           for(int i = 0; i < 75; i++){
               if(piedras[i] == 0){
                   piedras[i] = number;
                   break;
               }
           }
            return number;
        }
    }
    
    /*Asigna las propiedades del GridPane cuando se juega con un solo carton*/
    public void gridPaneUnCarton(GridPane container){
        container.setHgap(5);
        container.setVgap(20);
    }
    
    //Funcion que agrega los valores al GridPane de un carton
    public void completarGridPaneUnCarton(GridPane container, String[] numeros, Label[] labels){
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
                    labels[cont]=theLabel;
                    
                    
                    cont++;
                }
            }

        }
        System.out.println("El contador es: " + cont);
    }
    
}

    