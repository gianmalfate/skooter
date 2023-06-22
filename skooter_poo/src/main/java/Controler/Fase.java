package Controler;

import Modelo.*;
import Auxiliar.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Fase implements Serializable {
    
    private Skoot skoot;
    private Robo roboAzul;
    private Robo roboAmarelo;
    private Robo roboRosa;
    private Robo roboVerde;
    private ArrayList<Personagem> personagens;
    private int faseAtual;
    
    public Fase(){
        
        this.faseAtual = 1;
        personagens = new ArrayList<Personagem>(121);
    
    }
    
    public ArrayList<Personagem> getPersonagensFase(int numeroFase){
        
        switch(numeroFase) {
            // caso 0 retorna fase salva no arquivo
            case 0:
                return personagens;
            case 1:
                this.cenarioFase1();
              break;
            case 2:
                this.cenarioFase2();
              break;
            case 3:
                this.cenarioFase3();
              break;
            case 4:
                this.cenarioFase4();
              break;
            case 5:
                this.cenarioFase5();
              break;
            case 6:
                this.cenarioFaseBonus(); //ultima fase real
              break;
            case 7:
                this.faseAtual = 7;
                // finaliza jogo
        }
        return personagens;
    
    }
    
    public Skoot getSkoot(){
        return skoot;
    }
    
    public Robo getRoboAzul(){
        return roboAzul;
    }
    
    public Robo getRoboAmarelo(){
        return roboAmarelo;
    }
    
    public Robo getRoboRosa(){
        return roboRosa;
    }
    
    public Robo getRoboVerde(){
        return roboVerde;
    }
    
    private void cenarioFase1() {
        
        this.personagens.clear();
        this.faseAtual = 1;
        this.skoot = Skoot.getInstance();
        this.skoot.setPosicao(4, 4);
        this.addPersonagem(this.skoot);

        //Desenhando cubos verde preto
        CuboVerdePreto cuboVerdePreto;
        for(int i = 3; i <= 9; i+=6){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 0);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 0; i <= 5; i+=2){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 1);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 1; i <= 11; i+=4){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 2);
            this.addPersonagem(cuboVerdePreto);
        }
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(8, 3);
        this.addPersonagem(cuboVerdePreto);   
        for(int i = 0; i <= 6; i+=2){
            if(i == 4)
                i += 2;
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 5);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 5; i <= 11; i+=4){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 6);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 6; i <= 11; i+=4){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 7);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 1; i <= 11; i+=2){
            if(i == 5)
                i += 2;   
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 8);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 4; i <= 11; i+=4){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 9);
            this.addPersonagem(cuboVerdePreto);
        }
        for(int i = 1; i <= 11; i+=6){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(i, 10);
            this.addPersonagem(cuboVerdePreto);
        }
        
        //Desenhando cubos vermelho
        CuboVermelho cuboVermelho;
        for(int i = 1; i <= 9; i+=2){
            for(int j = 1; j <= 9; j+=2){
                cuboVermelho = new CuboVermelho("cuboVermelho.png");
                cuboVermelho.setPosicao(i, j);
                this.addPersonagem(cuboVermelho);
            }
        }
        
        //Desenhando itens coletaveis
        Uva uva = new Uva("uva.png");
        uva.setPosicao(0, 0);
        this.addPersonagem(uva);
        Limao limao = new Limao("limao.png");
        limao.setPosicao(0, 10);
        this.addPersonagem(limao);
        Morango morango = new Morango("morango.png");
        morango.setPosicao(10, 0);
        this.addPersonagem(morango);
        Cereja cereja = new Cereja("cereja.png");
        cereja.setPosicao(10, 10);
        this.addPersonagem(cereja);
        
        //Dessenhando robos
        this.roboAzul = new Robo("roboAzul.png");
        this.roboAzul.setPosicao(10, 1);
        this.addPersonagem(this.roboAzul);
        this.roboAmarelo = new Robo("roboAmarelo.png");
        this.roboAmarelo.setPosicao(2, 0);
        this.addPersonagem(this.roboAmarelo);
        this.roboRosa = new Robo("roboRosa.png");
        this.roboRosa.setPosicao(0, 9);
        this.addPersonagem(this.roboRosa);
        this.roboVerde = new Robo("roboVerde.png");
        this.roboVerde.setPosicao(10, 9);
        this.addPersonagem(this.roboVerde);
        
    }
    
    private void cenarioFase2() {
        
        this.personagens.clear();
        this.faseAtual = 2;
        this.skoot = Skoot.getInstance();  
        this.skoot.setPosicao(6, 4);
        this.addPersonagem(this.skoot);
        
        //Desenhando setas pra cima
        Seta setaCima;
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(1, 6);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(1, 10);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(3, 0);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(3, 4);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(3, 6);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(5, 0);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(5, 4);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(5, 10);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(7, 4);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(7, 10);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(9, 0);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(9, 2);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(9, 6);
        this.addPersonagem(setaCima);
        
        //Desenhando setas pra baixo
        Seta setaBaixo;
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(1, 0);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(1, 2);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(1, 4);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(1, 8);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(3, 2);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(3, 8);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(3, 10);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(5, 6);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(7, 0);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(7, 2);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(7, 6);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(7, 8);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(9, 4);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(9, 8);
        this.addPersonagem(setaBaixo);
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(9, 10);
        this.addPersonagem(setaBaixo);
        
        //Desenhando setas pra esquerda
        Seta setaEsquerda;
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(0, 1);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(0, 3);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(0, 5);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(0, 9);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(4, 1);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(4, 3);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(4, 5);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(4, 7);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(4, 9);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(6, 1);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(6, 3);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(6, 9);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(10, 1);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(10, 3);
        this.addPersonagem(setaEsquerda); 
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(10, 7);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(10, 9);
        this.addPersonagem(setaEsquerda);
        
        //Desenhando setas pra direita
        Seta setaDireita;
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(0, 7);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(2, 1);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(2, 3);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(2, 7);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(2, 9);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(6, 5);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(6, 7);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(8, 1);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(8, 3);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(8, 7);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(8, 9);
        this.addPersonagem(setaDireita);
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(10, 5);
        this.addPersonagem(setaDireita);
        
        //Desenhando cubos vermelho
        CuboVermelho cuboVermelho;
        for(int i = 1; i <= 9; i+=2){
            for(int j = 1; j <= 9; j+=2){
                cuboVermelho = new CuboVermelho("cuboVermelho.png");
                cuboVermelho.setPosicao(i, j);
                this.addPersonagem(cuboVermelho);
            }
        }
        
        //Desenhando itens coletaveis
        Uva uva = new Uva("uva.png");
        uva.setPosicao(2, 2);
        this.addPersonagem(uva);
        Limao limao = new Limao("limao.png");
        limao.setPosicao(2, 8);
        this.addPersonagem(limao);
        Morango morango = new Morango("morango.png");
        morango.setPosicao(8, 2);
        this.addPersonagem(morango);
        Cereja cereja = new Cereja("cereja.png");
        cereja.setPosicao(8, 8);
        this.addPersonagem(cereja);
        
        //Desenhando robos
        this.roboAzul = new Robo("roboAzul.png");
        this.roboAzul.setPosicao(8, 5);
        this.addPersonagem(this.roboAzul);
        this.roboAmarelo = new Robo("roboAmarelo.png");
        this.roboAmarelo.setPosicao(2, 5);
        this.addPersonagem(this.roboAmarelo);
        this.roboRosa = new Robo("roboRosa.png");
        this.roboRosa.setPosicao(5, 2);
        this.addPersonagem(this.roboRosa);
        this.roboVerde = new Robo("roboVerde.png");
        this.roboVerde.setPosicao(5, 8);
        this.addPersonagem(this.roboVerde);
        
    }
    
    private void cenarioFase3() {
        
        this.personagens.clear();
        this.faseAtual = 3;
        this.skoot = Skoot.getInstance(); 
        this.skoot.setPosicao(5, 5);
        this.addPersonagem(this.skoot);
        
        //Desenhando cubos vermelho preto
        CuboVermelhoPreto cuboVermelhoPreto;
        for(int i = 1; i <= 9; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(1, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 1; i <= 9; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(9, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 3; i <= 7; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(3, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 3; i <= 7; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(7, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 2; i <= 8; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(i, 1);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 2; i <= 8; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(i, 9);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 4; i <= 6; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(i, 3);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 4; i <= 6; i+=1){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(i, 7);
            this.addPersonagem(cuboVermelhoPreto);
        }
        
        //Desenhando itens coletaveis
        Uva uva = new Uva("uva.png");
        uva.setPosicao(5, 0);
        this.addPersonagem(uva);
        Limao limao = new Limao("limao.png");
        limao.setPosicao(5, 2);
        this.addPersonagem(limao);
        Morango morango = new Morango("morango.png");
        morango.setPosicao(5, 8);
        this.addPersonagem(morango);
        Cereja cereja = new Cereja("cereja.png");
        cereja.setPosicao(5, 10);
        this.addPersonagem(cereja);
        
        //Desenhando robos
        this.roboAzul = new Robo("roboAzul.png");
        this.roboAzul.setPosicao(0, 5);
        this.addPersonagem(this.roboAzul);
        this.roboAmarelo = new Robo("roboAmarelo.png");
        this.roboAmarelo.setPosicao(2, 5);
        this.addPersonagem(this.roboAmarelo);
        this.roboRosa = new Robo("roboRosa.png");
        this.roboRosa.setPosicao(8, 5);
        this.addPersonagem(this.roboRosa);
        this.roboVerde = new Robo("roboVerde.png");
        this.roboVerde.setPosicao(10, 5);
        this.addPersonagem(this.roboVerde);
        
    }
    
    private void cenarioFase4() {
        
        this.personagens.clear();
        this.faseAtual = 4;
        this.skoot = Skoot.getInstance();  
        this.skoot.setPosicao(4, 5);
        this.addPersonagem(this.skoot);
        
        //Desenhando cubos verde
        CuboVerde cuboVerde;
        boolean alternancia = true;
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                if(alternancia == true){
                    cuboVerde = new CuboVerde("cuboVerde.png");
                    cuboVerde.setPosicao(i, j);
                    this.addPersonagem(cuboVerde);
                }
                alternancia = !alternancia;
            }
        }
        
        //Desenhando cubos vermelho
        CuboVermelho cuboVermelho;
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(0, 3);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(0, 7);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(1, 0);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(1, 8);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(2, 5);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(3, 2);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(3, 10);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(5, 2);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(5, 8);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(6, 3);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(7, 0);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(8, 1);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(8, 7);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(8, 10);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(10, 1);
        this.addPersonagem(cuboVermelho);
        
        //Desenhando itens coletaveis
        Sol sol = new Sol("sol.png");
        sol.setPosicao(0, 0);
        this.addPersonagem(sol);
        Vela vela = new Vela("vela.png");
        vela.setPosicao(10, 0);
        this.addPersonagem(vela);
        Lampada lampada = new Lampada("lampada.png");
        lampada.setPosicao(0, 10);
        this.addPersonagem(lampada);
        Ferramenta ferramenta = new Ferramenta("ferramenta.png");
        ferramenta.setPosicao(10, 10);
        this.addPersonagem(ferramenta);
        
        //Desenhando robos
        this.roboAzul = new Robo("roboAzul.png");
        this.roboAzul.setPosicao(5, 10);
        this.addPersonagem(this.roboAzul);
        this.roboAmarelo = new Robo("roboAmarelo.png");
        this.roboAmarelo.setPosicao(0, 5);
        this.addPersonagem(this.roboAmarelo);
        this.roboRosa = new Robo("roboRosa.png");
        this.roboRosa.setPosicao(10, 5);
        this.addPersonagem(this.roboRosa);
        this.roboVerde = new Robo("roboVerde.png");
        this.roboVerde.setPosicao(5, 0);
        this.addPersonagem(this.roboVerde);
        
    }
    
    private void cenarioFase5() {
        
        this.personagens.clear();
        this.faseAtual = 5;
        this.skoot = Skoot.getInstance();  
        this.skoot.setPosicao(0, 5);
        this.addPersonagem(this.skoot);
        
        //Desenhando cubos vermelho
        CuboVermelho cuboVermelho;
        for(int i = 1; i <= 9; i+=2){
            for(int j = 1; j <= 9; j+=2){
                cuboVermelho = new CuboVermelho("cuboVermelho.png");
                cuboVermelho.setPosicao(i, j);
                this.addPersonagem(cuboVermelho);
            }
        }
        
        //Desenhando setas pra cima
        Seta setaCima;
        for(int i = 1; i <= 9; i+=2){
            for(int j = 0; j <= 10; j+=10){
                setaCima = new Seta("setaCima.png", "UP");
                setaCima.setPosicao(i, j);
                this.addPersonagem(setaCima);
            }
        }
        
        //Desenhando cubos verde preto
        CuboVerdePreto cuboVerdePreto;
        for(int j = 2; j <= 8; j+=2){
            cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
            cuboVerdePreto.setPosicao(9, j);
            this.addPersonagem(cuboVerdePreto);
        }
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(1, 4);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(3, 8);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(5, 2);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(7, 8);
        this.addPersonagem(cuboVerdePreto);
        
        //Desenhando cubos vermelho preto
        CuboVermelhoPreto cuboVermelhoPreto;
        for(int i = 2; i <= 6; i+=2){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(3, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 4; i <= 8; i+=2){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(5, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        for(int i = 2; i <= 6; i+=2){
            cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
            cuboVermelhoPreto.setPosicao(7, i);
            this.addPersonagem(cuboVermelhoPreto);
        }
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(1, 2);
        this.addPersonagem(cuboVermelhoPreto);   
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(1, 6);
        this.addPersonagem(cuboVermelhoPreto);
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(1, 8);
        this.addPersonagem(cuboVermelhoPreto);
        
        //Desenhando itens coletaveis
        Sol sol = new Sol("sol.png");
        sol.setPosicao(8, 2);
        this.addPersonagem(sol);
        Vela vela = new Vela("vela.png");
        vela.setPosicao(6, 4);
        this.addPersonagem(vela);
        Lampada lampada = new Lampada("lampada.png");
        lampada.setPosicao(4, 6);
        this.addPersonagem(lampada);
        Ferramenta ferramenta = new Ferramenta("ferramenta.png");
        ferramenta.setPosicao(2, 8);
        this.addPersonagem(ferramenta);
        
        //Desenhando robos
        this.roboAzul = new Robo("roboAzul.png");
        this.roboAzul.setPosicao(4, 4);
        this.addPersonagem(this.roboAzul);
        this.roboAmarelo = new Robo("roboAmarelo.png");
        this.roboAmarelo.setPosicao(8, 8);
        this.addPersonagem(this.roboAmarelo);
        this.roboRosa = new Robo("roboRosa.png");
        this.roboRosa.setPosicao(6, 6);
        this.addPersonagem(this.roboRosa);
        this.roboVerde = new Robo("roboVerde.png");
        this.roboVerde.setPosicao(2, 2);
        this.addPersonagem(this.roboVerde);
        
    }
    
    private void cenarioFaseBonus() {
        
        this.personagens.clear();
        this.faseAtual = 6;
        this.skoot = Skoot.getInstance();  
        this.skoot.setPosicao(5, 5);
        this.addPersonagem(this.skoot);
        
        //Desenhando cubos verde preto
        CuboVerdePreto cuboVerdePreto;
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(1, 1);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(1, 2);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(1, 3);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(2, 1);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(2, 3);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(3, 1);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(3, 2);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(3, 3);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(1, 7);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(1, 9);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(3, 7);
        this.addPersonagem(cuboVerdePreto);
        cuboVerdePreto = new CuboVerdePreto("cuboVerdePreto.png");
        cuboVerdePreto.setPosicao(3, 9);
        this.addPersonagem(cuboVerdePreto);
        
        //Desenhando cubos vermelho preto
        CuboVermelhoPreto cuboVermelhoPreto;
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(1, 8);
        this.addPersonagem(cuboVermelhoPreto);
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(2, 7);
        this.addPersonagem(cuboVermelhoPreto);
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(2, 9);
        this.addPersonagem(cuboVermelhoPreto);
        cuboVermelhoPreto = new CuboVermelhoPreto("cuboVermelhoPreto.png");
        cuboVermelhoPreto.setPosicao(3, 8);
        this.addPersonagem(cuboVermelhoPreto);
        
        //Desenhando cubos verde
        CuboVerde cuboVerde;
        cuboVerde = new CuboVerde("cuboVerde.png");
        cuboVerde.setPosicao(7, 1);
        this.addPersonagem(cuboVerde);
        cuboVerde = new CuboVerde("cuboVerde.png");
        cuboVerde.setPosicao(7, 3);
        this.addPersonagem(cuboVerde);
        cuboVerde = new CuboVerde("cuboVerde.png");
        cuboVerde.setPosicao(9, 1);
        this.addPersonagem(cuboVerde);
        cuboVerde = new CuboVerde("cuboVerde.png");
        cuboVerde.setPosicao(9, 3);
        this.addPersonagem(cuboVerde);
        
        //Desenhando setas pra cima
        Seta setaCima;
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(7, 2);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(7, 8);
        this.addPersonagem(setaCima);
        setaCima = new Seta("setaCima.png", "UP");
        setaCima.setPosicao(9, 8);
        this.addPersonagem(setaCima);
        
        //Desenhando setas pra baixo
        Seta setaBaixo;
        setaBaixo = new Seta("setaBaixo.png", "DOWN");
        setaBaixo.setPosicao(9, 2);
        this.addPersonagem(setaBaixo);
        
        //Desenhando setas pra esquerda
        Seta setaEsquerda;
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(8, 3);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(8, 7);
        this.addPersonagem(setaEsquerda);
        setaEsquerda = new Seta("setaEsquerda.png", "LEFT");
        setaEsquerda.setPosicao(8, 9);
        this.addPersonagem(setaEsquerda);
        
        //Desenhando setas pra direita
        Seta setaDireita;
        setaDireita = new Seta("setaDireita.png", "RIGHT");
        setaDireita.setPosicao(8, 1);
        this.addPersonagem(setaDireita);
        
        //Desenhando cubos vermelho
        CuboVermelho cuboVermelho;
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(7, 7);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(7, 9);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(9, 7);
        this.addPersonagem(cuboVermelho);
        cuboVermelho = new CuboVermelho("cuboVermelho.png");
        cuboVermelho.setPosicao(9, 9);
        this.addPersonagem(cuboVermelho);
        
        //Desenhando itens coletaveis
        Sol sol = new Sol("sol.png");
        sol.setPosicao(8, 8);
        this.addPersonagem(sol);
        Vela vela = new Vela("vela.png");
        vela.setPosicao(8, 2);
        this.addPersonagem(vela);
        Lampada lampada = new Lampada("lampada.png");
        lampada.setPosicao(2, 8);
        this.addPersonagem(lampada);
        Ferramenta ferramenta = new Ferramenta("ferramenta.png");
        ferramenta.setPosicao(2, 2);
        this.addPersonagem(ferramenta);
        
        //Desenhando robos
        this.roboAzul = new Robo("roboAzul.png");
        this.roboAzul.setPosicao(2, 5);
        this.addPersonagem(this.roboAzul);
        this.roboAmarelo = new Robo("roboAmarelo.png");
        this.roboAmarelo.setPosicao(5, 8);
        this.addPersonagem(this.roboAmarelo);
        this.roboRosa = new Robo("roboRosa.png");
        this.roboRosa.setPosicao(5, 2);
        this.addPersonagem(this.roboRosa);
        this.roboVerde = new Robo("roboVerde.png");
        this.roboVerde.setPosicao(8, 5);
        this.addPersonagem(this.roboVerde);
        
    }
    
    private void addPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }
    
    public int getFaseAtual(){
        return this.faseAtual;
    }
}
