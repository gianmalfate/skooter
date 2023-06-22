package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;

public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener, Serializable {

    private Skoot skoot;
    private Robo roboAzul;
    private Robo roboAmarelo;
    private Robo roboRosa;
    private Robo roboVerde;
    private ArrayList<Personagem> personagens;
    private ControleDeJogo cj;
    private Graphics g2;
    private Fase fase;
    /**
     * Creates new form
     */
    public Tela() throws IOException, ClassNotFoundException {
        Desenho.setCenario(this);
        initComponents();
 
        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*Este array vai guardar os elementos graficos*/
        this.personagens = new ArrayList<Personagem>(121);
        
        
        //Caminho que tem o arquivo (deixar criado no projeto)
        File arquivo = new File(Consts.PATH_SALVAR);
        if (arquivo.exists()) {
            FileInputStream fis = new FileInputStream(arquivo);
            GZIPInputStream descompactador = new GZIPInputStream(fis);
            ObjectInputStream deserializador = new ObjectInputStream(descompactador);
        
            this.fase = (Fase) deserializador.readObject();
            this.cj = (ControleDeJogo) deserializador.readObject();
            this.personagens = this.fase.getPersonagensFase(0);
            
            deserializador.close();
            descompactador.close();
            fis.close();
        }
        else{
            this.fase = new Fase();
            this.cj = new ControleDeJogo();
            this.personagens = this.fase.getPersonagensFase(1);
        }
        this.skoot = this.fase.getSkoot(); 
        this.roboAzul = this.fase.getRoboAzul();
        this.roboAmarelo = this.fase.getRoboAmarelo(); 
        this.roboRosa = this.fase.getRoboRosa();
        this.roboVerde = this.fase.getRoboVerde();
    }
    
    public boolean ehPosicaoValida(Robo robo) {
        return cj.ehPosicaoValida(this.personagens, robo);
    }

    public void addPersonagem(Personagem personagem) {
        personagens.add(personagem);
    }

    public void removePersonagem(Personagem personagem) {
        personagens.remove(personagem);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        /*************Desenha cenário de fundo**************/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + "fundo.png");
                    g2.drawImage(newImage,j*Consts.CELL_SIDE, i*Consts.CELL_SIDE, Consts.CELL_SIDE, Consts.CELL_SIDE, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.personagens.isEmpty()) {
            this.cj.desenhaTudo(personagens);
            this.cj.processaTudo(personagens);
            //Verfica se a fase já terminou
            if(this.cj.fimDaFase(personagens)){
                //Avança de fase
                this.resetaFase(this.fase.getFaseAtual()+1);
                //Caso a próxima fase seja apos a ultima (case 7 Fase.java - fase para finalizar jogo - nao fase real)
                if(this.fase.getFaseAtual() == Consts.QTDFASES){
                    System.out.println("\nVocê venceu!");
                    System.out.println("Pontuação do jogo: " + this.cj.getPontuacao());
                    this.resetaFase(1);
                }
            //Verifica se o jogador perdeu todas as suas vidas
            }else if(this.cj.estaMorto()){
                this.cj.resetaVida();
                this.cj.zeraPontos();
                this.resetaFase(1);
                System.out.println("\nComecando de novo\n");
            //Verifica se o jogador perdeu uma vida na rodada atual
            }else if(this.cj.perdeuVida()){
                this.cj.zeraPontos();
                this.resetaFase(this.fase.getFaseAtual());
            }
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.INTERVALO);
        
    }
    
    //Movimento do skoot pode ser feito pelas setas ou pelo WASD
    //Tecla E finaliza o jogo
    //Tecla R reinicia o jogo
    //Teclas 1-6 avançama para a respectiva fase
    //Espaço come o bloco adjacente
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        /*Movimento do skoot via teclado*/
        if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_W) {
            moveCubo(e, "UP");   
            this.moveSeta("UP");
            skoot.moveUp();
            skoot.setDirecao("UP");
        } else if (tecla == KeyEvent.VK_DOWN || tecla == KeyEvent.VK_S) {
            moveCubo(e, "DOWN");
            this.moveSeta("DOWN");
            skoot.moveDown();
            skoot.setDirecao("DOWN");
        } else if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_A) {
            moveCubo(e, "LEFT");
            this.moveSeta("LEFT");
            skoot.moveLeft();
            skoot.setDirecao("LEFT");
        } else if (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_D) {
            moveCubo(e, "RIGHT");
            this.moveSeta("RIGHT");
            skoot.moveRight();
            skoot.setDirecao("RIGHT");
        } else if (tecla == KeyEvent.VK_R) { //Tecla R reinicia o jogo
            this.cj.zeraPontos();
            this.personagens = this.fase.getPersonagensFase(1);
            this.skoot = this.fase.getSkoot();
        } else if(tecla == KeyEvent.VK_E) { //Tecla E
            Scanner leitor = new Scanner(System.in);
            
            System.out.println("Deseja salvar o jogo?");
            if(leitor.next().equalsIgnoreCase("Sim")){
                try {
                    File arquivo = new File(Consts.PATH_SALVAR);
                    arquivo.createNewFile();
                    FileOutputStream fos = new FileOutputStream(arquivo);
                    GZIPOutputStream compactador = new GZIPOutputStream(fos);
                    ObjectOutputStream serializador = new ObjectOutputStream(compactador);

                    serializador.writeObject(this.fase);
                    serializador.writeObject(this.cj);
                    serializador.flush();
                    serializador.close();
                    compactador.close();
                    fos.close();
                    
                    System.out.println("Jogo salvo!");
                } catch (Exception exc) {
                    System.out.println(exc.toString());
                }
            }
            
            System.out.println("\nFim!");
            System.out.println("\nSua pontuação final: " + this.cj.getPontuacao());
            System.exit(0);
        } else if(tecla >= KeyEvent.VK_1 && tecla <= Consts.QTDFASES + 48) {
            this.personagens = this.fase.getPersonagensFase(tecla - 48);
            this.skoot = this.fase.getSkoot();
        } else if(tecla == KeyEvent.VK_SPACE) { 
            for(int i = 0; i < this.personagens.size(); i++){
                if(this.personagens.get(i).getDestroy()){
                    switch(this.skoot.getDirecao()){
                        case "UP" -> {
                            if((skoot.getPosicao().getLinha()-1 == this.personagens.get(i).getPosicao().getLinha()) &&
                                    (skoot.getPosicao().getColuna()  == this.personagens.get(i).getPosicao().getColuna()))
                                Desenho.getTelaDoJogo().removePersonagem(this.personagens.get(i));
                        }
                        case "RIGHT" -> {
                            if((skoot.getPosicao().getLinha() == this.personagens.get(i).getPosicao().getLinha()) &&
                                    (skoot.getPosicao().getColuna()+1  == this.personagens.get(i).getPosicao().getColuna()))
                                Desenho.getTelaDoJogo().removePersonagem(this.personagens.get(i));
                        }
                        case "DOWN" -> {
                            if((this.skoot.getPosicao().getLinha()+1 == this.personagens.get(i).getPosicao().getLinha()) &&
                                    (this.skoot.getPosicao().getColuna()  == this.personagens.get(i).getPosicao().getColuna()))
                                Desenho.getTelaDoJogo().removePersonagem(this.personagens.get(i));
                        }
                        case "LEFT" -> {
                            if((skoot.getPosicao().getLinha() == this.personagens.get(i).getPosicao().getLinha()) &&
                                    (skoot.getPosicao().getColuna()-1  == this.personagens.get(i).getPosicao().getColuna()))
                                Desenho.getTelaDoJogo().removePersonagem(this.personagens.get(i));
                        }

                    }
                                    }
            }
        }
        
        /*Se o skoot for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cj.ehPosicaoValida(this.personagens,skoot)) {
            skoot.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (skoot.getPosicao().getColuna()) + ", " + (skoot.getPosicao().getLinha()));
    }
    
    public void mousePressed(MouseEvent e) {
        /* Clique do mouse desligado*/
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.skoot.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);
         
        repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2023-1 - Skooter");
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
    public void moveCubo(KeyEvent e, String tecla){
        for(int i = 0; i < this.personagens.size(); i++){
            if(this.personagens.get(i).isMovable()){
                if((this.skoot.getPosicao().getLinha()+1 == this.personagens.get(i).getPosicao().getLinha())  &&
                   (this.skoot.getPosicao().getColuna()  == this.personagens.get(i).getPosicao().getColuna()) && 
                   ("DOWN".equals(tecla))){         
                        if(this.verificaSePodeMover("DOWN")){
                            this.personagens.get(i).moveDown();
                            break;
                        }
                    }else{
                        if((this.skoot.getPosicao().getLinha()-1 == this.personagens.get(i).getPosicao().getLinha())  &&
                           (skoot.getPosicao().getColuna()       == this.personagens.get(i).getPosicao().getColuna()) && 
                           ("UP".equals(tecla))){
                                if(this.verificaSePodeMover("UP")){
                                    this.personagens.get(i).moveUp();
                                    break;
                                }
                        }else{
                            if((skoot.getPosicao().getLinha()     == this.personagens.get(i).getPosicao().getLinha())  &&
                               (skoot.getPosicao().getColuna()+1  == this.personagens.get(i).getPosicao().getColuna()) && 
                               ("RIGHT".equals(tecla))){
                                    if(this.verificaSePodeMover("RIGHT")){
                                        this.personagens.get(i).moveRight();
                                        break;
                                    }
                            }else{
                                if((skoot.getPosicao().getLinha()     == this.personagens.get(i).getPosicao().getLinha())  &&
                                   (skoot.getPosicao().getColuna()-1  == this.personagens.get(i).getPosicao().getColuna()) && 
                                   ("LEFT".equals(tecla))){
                                        if(this.verificaSePodeMover("LEFT")){
                                            this.personagens.get(i).moveLeft();
                                            break;
                                        }
                                }
                            }
                        }
                    }
            }
        }
    }
    
    private void resetaFase(int fase){
        this.personagens = this.fase.getPersonagensFase(fase);
        this.skoot = this.fase.getSkoot();
    }
    
    private boolean verificaSePodeMover(String direcao){
        int i = 0;
        for(i = 0; i < this.personagens.size(); i++){
            if("DOWN".equals(direcao)){
                if(this.personagens.get(i).getPosicao().getLinha() == this.skoot.getPosicao().getLinha()+2 &&
                   this.personagens.get(i).getPosicao().getColuna() == this.skoot.getPosicao().getColuna())
                        break;
            }else if("UP".equals(direcao)){
                if(this.personagens.get(i).getPosicao().getLinha() == this.skoot.getPosicao().getLinha()-2 &&
                   this.personagens.get(i).getPosicao().getColuna() == this.skoot.getPosicao().getColuna())
                        break;
            }else if("LEFT".equals(direcao)){
                if(this.personagens.get(i).getPosicao().getLinha() == this.skoot.getPosicao().getLinha() &&
                   this.personagens.get(i).getPosicao().getColuna() == this.skoot.getPosicao().getColuna()-2)
                        break;
            }else{
                if(this.personagens.get(i).getPosicao().getLinha() == this.skoot.getPosicao().getLinha() &&
                   this.personagens.get(i).getPosicao().getColuna() == this.skoot.getPosicao().getColuna()+2)
                        break;
            }           
        }
        
        if(i == this.personagens.size())
            return true;
        else
            return false;
    }
    
    private void moveSeta(String tecla){
        for(int i = 0; i < this.personagens.size(); i++){
            if(this.personagens.get(i).isArrow()){
                if(((this.skoot.getPosicao().getLinha() == this.personagens.get(i).getPosicao().getLinha())  &&
                   (this.skoot.getPosicao().getColuna()-1  == this.personagens.get(i).getPosicao().getColuna()) && 
                   ("LEFT".equals(this.personagens.get(i).getArrowType()))) 
                        && ("LEFT".equals(tecla))){
                        this.skoot.setPosicao(this.skoot.getPosicao().getLinha(), this.skoot.getPosicao().getColuna()-1);
                        break;
                }else if(((this.skoot.getPosicao().getLinha() == this.personagens.get(i).getPosicao().getLinha())  &&
                         (this.skoot.getPosicao().getColuna()+1  == this.personagens.get(i).getPosicao().getColuna()) &&
                          ("RIGHT".equals(this.personagens.get(i).getArrowType()))) 
                          && ("RIGHT".equals(tecla))){
                            this.skoot.setPosicao(this.skoot.getPosicao().getLinha(), this.skoot.getPosicao().getColuna()+1);
                            break;
                }else if(((this.skoot.getPosicao().getLinha()-1 == this.personagens.get(i).getPosicao().getLinha())  &&
                         (this.skoot.getPosicao().getColuna()  == this.personagens.get(i).getPosicao().getColuna()) && 
                          ("UP".equals(this.personagens.get(i).getArrowType())))
                          && ("UP".equals(tecla))){
                            this.skoot.setPosicao(this.skoot.getPosicao().getLinha()-1, this.skoot.getPosicao().getColuna());
                            break;
                }else if(((this.skoot.getPosicao().getLinha()+1 == this.personagens.get(i).getPosicao().getLinha())  &&
                         (this.skoot.getPosicao().getColuna()  == this.personagens.get(i).getPosicao().getColuna()) && 
                          ("DOWN".equals(this.personagens.get(i).getArrowType())))
                          && ("DOWN".equals(tecla))){
                            this.skoot.setPosicao(this.skoot.getPosicao().getLinha()+1, this.skoot.getPosicao().getColuna());
                            break;
                }
            }
        }
    }

}
