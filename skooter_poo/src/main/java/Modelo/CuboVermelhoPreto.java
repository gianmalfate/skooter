/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author gianm
 */
public class CuboVermelhoPreto extends Personagem {
    
    public CuboVermelhoPreto(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.movable = true;
    }
    
    public void autoDesenho(){ 
        super.autoDesenho();
    }
    
}
