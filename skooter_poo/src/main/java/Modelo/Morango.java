package Modelo;

import Auxiliar.Desenho;

public class Morango extends Item {
    
    public Morango(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.iPontos = 100;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
    
    public String toString(){
        return "Morango";
    }
}
