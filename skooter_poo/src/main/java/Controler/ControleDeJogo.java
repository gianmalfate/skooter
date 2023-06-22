package Controler;

import Auxiliar.Consts;
import Modelo.Personagem;
import Modelo.Skoot;
import Auxiliar.Posicao;
import java.io.Serializable;
import java.util.ArrayList;

public class ControleDeJogo implements Serializable {
    private int pontuacao_cont;
    private int vida_cont;
    private boolean perdeu_vida;

    ControleDeJogo(){
        this.vida_cont = Consts.QTDVIDAS;
        this.pontuacao_cont = 0;
        this.perdeu_vida = false;
    }
    
    public void desenhaTudo(ArrayList<Personagem> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Personagem> umaFase){
        Skoot skoot = (Skoot)umaFase.get(0); 
        Personagem pIesimoPersonagem;
       
        //Recebe todo mundo menos o indice 0 (skoot)
        for(int i = 1; i < umaFase.size(); i++){
            //Valida se está na mesma posição
            pIesimoPersonagem = umaFase.get(i); 
            if(skoot.getPosicao().igual(pIesimoPersonagem.getPosicao()))
                if(pIesimoPersonagem.isbTransponivel()){
                    //Valida se é coletavel
                    if(pIesimoPersonagem.ehColetavel()){
                        this.pontuacao_cont += pIesimoPersonagem.getPontos();
                        System.out.println("\nParabéns, você coletou: " + pIesimoPersonagem.toString());
                        System.out.println("Pontuação atual: " + this.pontuacao_cont + "\n");
                    }
                    umaFase.remove(pIesimoPersonagem);
                }
        }
    }
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Personagem p){
        Personagem pIesimoPersonagem;
        Skoot skoot = (Skoot)umaFase.get(0);
        Vida vida = new Vida();
        
        
        //Quando o monstro avança sobre o personagem
        if(p.getMortal()){
            if(p.getPosicao().igual(skoot.getPosicao())){
                menosVida();
                this.perdeu_vida = !this.perdeu_vida;
                skoot.setVidas(vida_cont); 
                skoot.addObserver(vida);
                skoot.notifyObservers(skoot);
                
                return false;
            }
        }
        
        //Valida a posição de todos
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(pIesimoPersonagem == p){
                continue;
            }
            if(!pIesimoPersonagem.isbTransponivel())
                if(pIesimoPersonagem.getPosicao().igual(p.getPosicao())){
                    //Quando o personagem avança sobre o monstro
                    if((p == skoot && pIesimoPersonagem.getMortal())){
                        menosVida();
                        this.perdeu_vida = !this.perdeu_vida;
                        skoot.setVidas(vida_cont); 
                        skoot.addObserver(vida);
                        skoot.notifyObservers(skoot);
                    }
                    return false;
                }
        }
        return true;
    }

    public void menosVida() {
        this.vida_cont--;
    }
    
    public int getVida(){
        return this.vida_cont;
    }
    
    public boolean estaMorto(){
        if(getVida() < 1) return true;
        else return false;
    }

    public void resetaVida() {
        this.vida_cont = Consts.QTDVIDAS;
        this.perdeu_vida = false;
    }
    
    public boolean perdeuVida(){
        if(this.perdeu_vida == true){
            this.perdeu_vida = false;
            return true;
        }
        return false;
    }
    
    public int getPontuacao(){
        return this.pontuacao_cont;
    }
    
    public void zeraPontos(){
        this.pontuacao_cont = 0;
    }
    
    
    public boolean fimDaFase(ArrayList<Personagem> e){
        boolean terminou = true;
        for(int i = 1; i < e.size(); i++){
            if(e.get(i).ehColetavel() == true){
                terminou = false;
                break;
            }
        }
        return terminou;
    }
}