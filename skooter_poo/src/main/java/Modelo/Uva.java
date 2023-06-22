package Modelo;

import Auxiliar.Desenho;

public class Uva extends Item {
    
    public Uva(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.iPontos = 250;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
    
    public String toString(){
        return "Uva";
    }
}