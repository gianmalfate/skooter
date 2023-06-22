package Modelo;

public class Seta extends Personagem{
    
    public Seta(String sNomeImagePNG, String type) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.arrowType = type;
        this.arrow = true;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();  
    }
}
