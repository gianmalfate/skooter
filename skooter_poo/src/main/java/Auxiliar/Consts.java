package Auxiliar;

import java.io.File;

public class Consts {
    public static final int CELL_SIDE = 60;
    public static final int RES = 11;
   
    //Constantes de jogo
    public static final int INTERVALO = 100;   
    public static final int DIFICULDADE_JOGO = 5; 
    public static final int QTDVIDAS = 3;
    public static final int QTDFASES = 7;
    
    //Constantes de caminho
    public static final String PATH_SALVAR = System.getProperty("user.dir")+ File.separator + "salva.txt";
    public static final String PATH = File.separator+"imgs"+File.separator;
}
