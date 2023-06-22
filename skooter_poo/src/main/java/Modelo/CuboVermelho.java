package Modelo;

public class CuboVermelho extends Personagem {
    
    public CuboVermelho(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
}
