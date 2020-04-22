
package Clases;

import java.util.ArrayList;

public class Jugador {
    
    ArrayList<Carton> cartones;
    
    public String[] crearCartones() {
        this.cartones = new ArrayList();
        
           Carton carton1 = new Carton();
           this.cartones.add(carton1);
           
           this.cartones.get(0).crearCarton();
           return this.cartones.get(0).getNumeros();
           
    }    
}
