package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Skoot extends Personagem implements Serializable {
    //UP|RIGHT|DOWN|LEFT
    private String direcao;
    private static Skoot skoot;
    private int vidas;
    
    private Skoot(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.direcao = "UP";
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }

    public String getDirecao() {
        return this.direcao;
    }
    
    //Determina pra qual direção o herói está "olhando"
    public void setDirecao(String direcao){
        this.direcao = direcao;
    }
    
    public int getVidas() {
        return this.vidas;
    }
    
    public void setVidas(int vidas){
        this.vidas = vidas;
        this.setChanged();
    }
    
    public static Skoot getInstance(){
        skoot = new Skoot("skoot.png");
        return skoot;
    }
}
