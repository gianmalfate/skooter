package Modelo;

import Auxiliar.Desenho;

public class Limao extends Item {
    
    public Limao(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.iPontos = 150;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
    
    public String toString(){
        return "Limao";
    }
}
