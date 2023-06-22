package Controler;

import Modelo.Skoot;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class Vida implements Observer {
    private int vida_cont;
    
    @Override
    public void update(Observable o, Object arg) { 
        Skoot temp = (Skoot)o;
        this.vida_cont = temp.getVidas();
        
        if(this.vida_cont > 0){
            System.out.println("\n: Você acaba de perder uma vida!!!! Cuidado!!!");
            System.out.println("Vidas sobrando: " + this.vida_cont + "\n");
        }else{
            System.out.println("\nPoxa, suas vidas acabaram!");
        }
    }
    
}
