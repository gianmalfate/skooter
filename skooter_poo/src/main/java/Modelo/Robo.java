package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import java.util.ArrayList;
import java.util.Random;

public class Robo extends Personagem {
    private Random r;
    private int intervalo = 0;
    
    public Robo(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
        this.bTransponivel = false;
        r = new Random();
    }
    
    public void autoDesenho(){
        this.intervalo++;
        //Determina o atraso no movimento dos monstros
        //Caracterizando a "dificuldade" do jogo
        if(this.intervalo == Consts.DIFICULDADE_JOGO){
            this.intervalo = 0;
            int direcao = r.nextInt(4);

            switch(direcao){
                case 0:
                    this.moveRight();
                    break;
                case 1:
                    this.moveDown();
                    break;
                case 2:
                    this.moveLeft();
                    break;
                case 3:
                    this.moveUp();
                    break;
            }

            if(!Desenho.getTelaDoJogo().ehPosicaoValida(this)){
                this.voltaAUltimaPosicao();
            }
        }
        
        super.autoDesenho();
        
    }
    
    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }
}
