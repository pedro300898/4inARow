/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interdisciplinar;

import java.util.ArrayList;

/**
 *
 * @author João Pedro
 */
public class Minimax {
    
    private EstadoJogo estado;

    public Minimax(EstadoJogo estado) {
        this.estado = estado;
    }
    
    public int melhorJogada() {
        EstadoJogo melhorJogada = max(estado,0);
        return melhorJogada.getMelhorAcao();
    }
    
    private EstadoJogo max(EstadoJogo estado, int nivel) {
        if(nivel == 8){
            estado.setMinimax(0);
            return estado;
        }

        int possivelVencedor = estado.determinarVencedor();
        if(possivelVencedor != 0) {//se alguem ganhou
            estado.setMinimax(possivelVencedor);
            return estado;
        }
        
        ArrayList<EstadoJogo> novosEstados = estado.getFilhos(1);
        
        int max = Integer.MIN_VALUE;
        
        ArrayList<EstadoJogo> melhores = new ArrayList();
        
        for(EstadoJogo filho:novosEstados) {
    //        System.out.println(filho.getAcao());
            EstadoJogo possivelMelhor = min(filho, nivel+1);
            if(possivelMelhor.getMinimax()> max) {
                melhores = new ArrayList();
                melhores.add(possivelMelhor);
                max = possivelMelhor.getMinimax();
            }else if(possivelMelhor.getMinimax()==max){
                melhores.add(possivelMelhor);
            }
        }
        estado.setMelhorAcao(melhores.get((int)(Math.random()*melhores.size())).getAcao());
        estado.setMinimax(max);
        return estado;
    }
    
    private EstadoJogo min(EstadoJogo estado, int nivel) {
        if(nivel == 8){
            estado.setMinimax(0);
            return estado;
        }
        //System.out.println("valor nivel min "+nivel);
        int possivelVencedor = estado.determinarVencedor();
        if(possivelVencedor != 0) {
            estado.setMinimax(possivelVencedor);
            return estado;
        }
        
        ArrayList<EstadoJogo> novosEstados = estado.getFilhos(-1);
        
        int min = Integer.MAX_VALUE;
        
        EstadoJogo melhor = null;
        for(EstadoJogo filho:novosEstados) {
            EstadoJogo possivelMelhor = max(filho, nivel+1);
            if(possivelMelhor.getMinimax() < min) {
                melhor = possivelMelhor;
                min = possivelMelhor.getMinimax();
            }
        }
        estado.setMelhorAcao(melhor.getAcao());
        estado.setMinimax(min);
        return estado;
    }
        
}