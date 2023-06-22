/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author gianm
 */
public class Vela extends Item {
    
    public Vela(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.iPontos = 100;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
    
    public String toString(){
        return "Vela";
    }
    
}
