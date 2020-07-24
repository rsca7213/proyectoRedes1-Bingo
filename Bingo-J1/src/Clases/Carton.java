
package Clases;

import javafx.scene.control.Label;


public class Carton {
    
    //Este array contendra todos los numeros del carton a crear
    private String numeros[] = new String[25];
    
    //Indica en que posicion del array numeros[] ingresara el nuevo numero del carton
    private int indice = 0;
    
    //Funcion para verificar que no se repitan los numeros en el carton
    private boolean contiene(String numerito,int inicio,int fin, int intervalo) {
        for (int i = inicio; i < fin; i+=intervalo) {
            if (numeros[i] != null) {

                if (numerito.equals(numeros[i])) {

                    return true;
                }
            }
        }
        return false;
    }
    
    //Funcion que va creando los numeros del carton y los añade en el array numeros[]
    //en caso de que el numero no este repetido
    public void crearCarton() {
        for (int j = 0; j < 5; j++) {

            for (int i = 0; i < 6; i++) {

                if (j == 2 && i == 3) {
                    numeros[indice] = "FREE";
                    indice++;

                } else if (i == 0) {
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
                    }

                } else {
                    int number = 0;
                    if (j == 0) {

                        do {
                            number = (int) (Math.random() * 15)+1;
                            if (number == 0) {
                                number = 1;
                            }
                            if (number < 16) {
                                do {
                                    if (!(contiene(String.valueOf(number),0,4,1))) {
                                        numeros[indice] = String.valueOf(number);
                                        System.out.println("SE AÑADIO: " + number);

                                        indice++;
                                        break;
                                    } else {
                                        number = (int) (Math.random() * 15)+1;
                                        if (number == 0) {
                                            number = 1;
                                        }
                                        if (number < 16) {
                                            if (!(contiene(String.valueOf(number),0,4,1))) {
                                                numeros[indice] = String.valueOf(number);
                                                System.out.println("SE AÑADIO: " + number);

                                                indice++;
                                                break;
                                            }

                                        } else {
                                            break;
                                        }
                                    }
                                } while (contiene(String.valueOf(number),0,4,1));

                            }
                        } while (number > 15);

                    } else if (j == 1) {
                        do {
                            number = (int) (Math.random() * 30)+1;
                            if (number > 15 && number < 31) {
                                do {
                                    if (!(contiene(String.valueOf(number),5,9,1))) {
                                        numeros[indice] = String.valueOf(number);
                                        System.out.println("SE AÑADIO: " + number);
                                        indice++;
                                        break;
                                    } else {
                                        number = (int) (Math.random() * 30)+1;
                                        if (number > 15 && number < 31) {
                                            if (!(contiene(String.valueOf(number),5,9,1))) {
                                                numeros[indice] = String.valueOf(number);
                                                System.out.println("SE AÑADIO: " + number);
                                                indice++;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } while (contiene(String.valueOf(number),5,9,1));

                            }

                        } while (number < 16 || number > 30);
                    } else if (j == 2) {
                        do {
                            number = (int) (Math.random() * 45)+1;
                            if (number > 30 && number < 46) {
                                do {
                                    if (!(contiene(String.valueOf(number),10,14,1))) {
                                        numeros[indice] = String.valueOf(number);
                                        System.out.println("SE AÑADIO: " + number);
                                        indice++;
                                        break;
                                    } else {
                                        number = (int) (Math.random() * 45)+1;
                                        if (number > 30 && number < 46) {
                                            if (!(contiene(String.valueOf(number),10,14,1))) {
                                                numeros[indice] = String.valueOf(number);
                                                System.out.println("SE AÑADIO: " + number);
                                                indice++;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } while (contiene(String.valueOf(number),10,14,1));
                            }
                        } while (number < 31 || number > 45);

                    } else if (j == 3) {
                        do {
                            number = (int) (Math.random() * 60)+1;
                            if (number > 45 && number < 61) {
                                do {
                                    if (!(contiene(String.valueOf(number),15,19,1))) {
                                        numeros[indice] = String.valueOf(number);
                                        System.out.println("SE AÑADIO: " + number);
                                        indice++;
                                        break;
                                    } else {
                                        number = (int) (Math.random() * 60)+1;
                                        if (number > 45 && number < 61) {
                                            if (!(contiene(String.valueOf(number),15,19,1))) {
                                                numeros[indice] = String.valueOf(number);
                                                System.out.println("SE AÑADIO: " + number);
                                                indice++;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } while (contiene(String.valueOf(number),15,19,1));
                            }
                        } while (number < 46 || number > 60);

                    } else if (j == 4) {
                        do {
                            number = (int) (Math.random() * 75)+1;
                            if (number > 60 && number < 76) {
                                do {
                                    if (!(contiene(String.valueOf(number),20,24,1))) {
                                        numeros[indice] = String.valueOf(number);
                                        System.out.println("SE AÑADIO: " + number);
                                        indice++;
                                        break;
                                    } else {
                                        number = (int) (Math.random() * 75)+1;
                                        if (number > 60 && number < 76) {
                                            if (!(contiene(String.valueOf(number),20,24,1))) {
                                                numeros[indice] = String.valueOf(number);
                                                System.out.println("SE AÑADIO: " + number);
                                                indice++;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } while (contiene(String.valueOf(number),20,24,1));
                            }
                        } while (number < 61 || number > 75);

                    }

                    /*Label u13 = new Label(String.valueOf(number));
                    u13.setId("ue");
                    //u13.setFill(Color.AQUAMARINE);
                    grid.add(u13, j, i, 1, 1);*/
                }

            }
        }
        for (int o = 0; o < numeros.length; o++) {
            System.out.print(numeros[o] + ",");
        }
    }
    
    public String[] getNumeros() {
        return numeros;
    }
    
    public void piedraCorrecta(Label labels[], String numeros[], int number){
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
    }
    
    /*
    public Carton(){
        crearCarton();
    }
    */
    
}
