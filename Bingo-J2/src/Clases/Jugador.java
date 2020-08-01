
package Clases;

import java.util.ArrayList;

public class Jugador {
    
    public ArrayList<Carton> cartones;
    
    public String[] crearCartones(int cart) {
        
        if(cart == 1){
           Carton carton1 = new Carton();
           this.cartones.add(carton1);
           
           this.cartones.get(0).crearCarton();
           return this.cartones.get(0).getNumeros();
        }
        if(cart == 2){ 
           Carton carton2 = new Carton();
           this.cartones.add(carton2);
           
           this.cartones.get(1).crearCarton();
           return this.cartones.get(1).getNumeros();
        }
        else return null;
    }    
    
}
