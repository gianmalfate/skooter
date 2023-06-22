package Modelo;

public class CuboVerdePreto extends Personagem {
    
    public CuboVerdePreto(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.destroy = true;
        this.movable = true;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
}
