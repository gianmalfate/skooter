package Auxiliar;

import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.ImageIcon;
import Controler.Tela;

public class Desenho implements Serializable {
    //Instancia Tela
    static Tela ondeDesenhar;
    
    
    public static void setCenario(Tela cenario) {
        ondeDesenhar = cenario;
    }

    public static Tela getTelaDoJogo() {
        return ondeDesenhar;
    }
    
    public static void desenhar(ImageIcon iImage, int iColuna, int iLinha) {
        iImage.paintIcon(ondeDesenhar,getGraphicsDaTela(),iColuna * Consts.CELL_SIDE, iLinha * Consts.CELL_SIDE);
    }
    
    /*Private, entao eh usado só aqui dentro*/
    private static Graphics getGraphicsDaTela() {
        return ondeDesenhar.getGraphicsBuffer();
    }
}
