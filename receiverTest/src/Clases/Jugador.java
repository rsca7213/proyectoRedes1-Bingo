
package Clases;

import java.util.ArrayList;

public class Jugador {
    
    ArrayList<Carton> cartones;
    
    public void crearCartones(int cant) {
        this.cartones = new ArrayList();
        
        //Falta crear los cartones
        if(cant == 1) {
           Carton carton1 = new Carton();
           this.cartones.add(carton1);
           
           for(Carton a: cartones){
               a.crearCarton();
           }
           
        }
        if(cant == 2) {
           Carton carton1 = new Carton();
           Carton carton2 = new Carton();
           this.cartones.add(carton1);
           this.cartones.add(carton2); 
        }
    }
}
