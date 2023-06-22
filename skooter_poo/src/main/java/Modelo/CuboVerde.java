package Modelo;

public class CuboVerde extends Personagem {
    
    public CuboVerde(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.destroy = true;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
}
