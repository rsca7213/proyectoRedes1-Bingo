package Helpers;

import javafx.scene.control.Button;
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

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 0)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 1)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 2)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 3)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 4)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int ver2(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 5)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 6)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 7)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 8)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 9)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int ver3(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 10)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 11)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 13)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 14)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int ver4(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 15)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 16)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 17)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 18)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 19)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int ver5(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 20)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 21)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 22)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 23)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 24)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    //Verificar aciertos en linea horizontal
    private int hor1(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 0)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 5)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 10)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 15)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 20)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int hor2(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 1)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 6)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 11)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 16)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 21)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int hor3(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 2)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 7)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 17)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 22)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int hor4(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 3)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 8)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 13)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 18)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 23)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int hor5(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 4)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 9)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 14)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 19)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 24)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    //Verificar aciertos en diagonal y en esquinas
    private int dia1(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 0)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 6)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 18)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 24)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int dia2(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 4)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 8)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 16)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 20)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    private int esq(String[] numeros) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if ((numeros[i] == "X") && (i == 0)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 4)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 20)) {
                contAciertos++;
            } else if ((numeros[i] == "X") && (i == 24)) {
                contAciertos++;
            }
        }
        return contAciertos;
    }

    public void verificarGanadaLinea(String[] numeros, Label labels[], String bingo[], Button generador, Label piedra) {

        if (ver1(numeros) == 5) {
            win(labels,generador,piedra,1,0,5,1);
        }
        if (ver2(numeros) == 5) {
            win(labels,generador,piedra,1,5,10,1);
        }
        if (ver4(numeros) == 5) {
            win(labels,generador,piedra,1,15,20,1);
        }
        if (ver5(numeros) == 5) {
            win(labels,generador,piedra,1,20,25,1);
        }
        if (hor1(numeros) == 5) {
            win(labels,generador,piedra,1,0,21,5);
        }
        if (hor2(numeros) == 5) {
            win(labels,generador,piedra,1,1,22,5);
        }
        if (hor4(numeros) == 5) {
            win(labels,generador,piedra,1,3,24,5);
        }
        if (hor5(numeros) == 5) {
            win(labels,generador,piedra,1,4,25,5);
        }
        if (ver3(numeros) == 4) {
            win(labels,generador,piedra,1,10,15,1);
        }
        if (hor3(numeros) == 4) {
            win(labels,generador,piedra,1,2,23,5);
        }
        if (dia1(numeros) == 4) {
            win(labels,generador,piedra,1,0,25,6);
        }
        if (dia2(numeros) == 4) {
            win(labels,generador,piedra,1,4,21,4);
        }
        if (esq(numeros) == 4) {
            win(labels,generador,piedra,2,0,0,0);
        }

    }
    
    public void verificarGanadaLleno(String[] numeros, Label labels[], Button generador, Label piedra) {
        int contAciertos = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == "X") {
                switch (i) {
                    case 0:
                        contAciertos++;
                        break;
                    case 1:
                        contAciertos++;
                        break;
                    case 2:
                        contAciertos++;
                        break;
                    case 3:
                        contAciertos++;
                        break;
                    case 4:
                        contAciertos++;
                        break;
                    case 5:
                        contAciertos++;
                        break;
                    case 6:
                        contAciertos++;
                        break;
                    case 7:
                        contAciertos++;
                        break;
                    case 8:
                        contAciertos++;
                        break;
                    case 9:
                        contAciertos++;
                        break;
                    case 10:
                        contAciertos++;
                        break;
                    case 11:
                        contAciertos++;
                        break;
                    case 13:
                        contAciertos++;
                        break;
                    case 14:
                        contAciertos++;
                        break;
                    case 15:
                        contAciertos++;
                        break;
                    case 16:
                        contAciertos++;
                        break;
                    case 17:
                        contAciertos++;
                        break;
                    case 18:
                        contAciertos++;
                        break;
                    case 19:
                        contAciertos++;
                        break;
                    case 20:
                        contAciertos++;
                        break;
                    case 21:
                        contAciertos++;
                        break;
                    case 22:
                        contAciertos++;
                        break;
                    case 23:
                        contAciertos++;
                        break;
                    case 24:
                        contAciertos++;
                        break;
                }
            }
        }
        if (contAciertos == 24) {
            win(labels,generador,piedra,3,0,0,0);
        }
    }
    
    private void win(Label labels[], Button generador, Label piedra, int flag, int a, int b, int c){
        switch (flag) {
            case 1:
                for(int i=a;i<b;i+=c){
                    labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                }
                break;
            case 2:
                labels[0].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                labels[4].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                labels[20].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                labels[24].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                labels[12].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                break;
            default:
                for(int i=0; i<25;i++){
                    labels[i].setStyle("-fx-opacity:1;"
                            +"-fx-border-color: white;"
                            + "-fx-border-width: 4px;"
                            + "-fx-text-fill: white;"
                            + "-fx-font-size: 16px;" + "-fx-background-color: #6FDC6F;");
                }
                break;
        }
        System.out.println("\n¡FELICIDADES! Ha ganado el juego");
        generador.setDisable(true);
        generador.setText("BINGOOO!");
        piedra.setVisible(false);
        piedra.setText("BINGO");
        piedra.setStyle("-fx-background-color: #6FDC6F; -fx-border-radius: 10px; -fx-border-width: 3px; -fx-border-color: white; -fx-background-radius: 11px; -fx-min-width: 70px; -fx-font-weigth: bold;");
    }
    
    public void generarPiedras(int number, char letraFicha, Label piedra){
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
    }

    //Verifico un número que no se haya jugado antes y lo agrego al array de las piedras
    public int verificarPiedra() {
        int number = (int) (Math.random() * 75) + 1;
        boolean repetir = false;

        for (int i = 0; i < 75 && piedras[i] != 0; i++) {
            if (piedras[i] == number) {
                repetir = true;
                break;
            }
        }
        if (repetir) {
            return verificarPiedra();
        } else {
            for (int i = 0; i < 75; i++) {
                if (piedras[i] == 0) {
                    piedras[i] = number;
                    break;
                }
            }
            return number;
        }
    }

    /*Asigna las propiedades del GridPane cuando se juega con un solo carton*/
    public void gridPaneUnCarton(GridPane container) {
        container.setHgap(5);
        container.setVgap(20);
    }

    //Funcion que agrega los valores al GridPane de un carton
    public void completarGridPaneUnCarton(GridPane container, String[] numeros, Label[] labels) {
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
                    if (cont == 12) {
                        theLabel.setId("FREE");
                    } else {
                        theLabel.setId("col" + j);
                    }
                    container.add(theLabel, j, i, 1, 1);
                    labels[cont] = theLabel;

                    cont++;
                }
            }

        }
        System.out.println("El contador es: " + cont);
    }

}
