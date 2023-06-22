package Modelo;

import Auxiliar.Desenho;

public class Cereja extends Item {
    
    public Cereja(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.iPontos = 200;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
    
    public String toString(){
        return "Cereja";
    }
}