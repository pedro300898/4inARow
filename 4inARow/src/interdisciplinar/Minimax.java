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
    
    public int melhorJogada(int nivel) {
        return minimax(estado, nivel);
    }
    
    private int minimax(EstadoJogo estado, int nivel) {
        EstadoJogo melhorJogada = max(estado, nivel);
        return melhorJogada.getMelhorAcao();
    }
    
    private EstadoJogo max(EstadoJogo estado, int nivel) {
        nivel++;
        System.out.println("valor nivel max "+nivel);

        int possivelVencedor = estado.determinarVencedor();
        if(possivelVencedor != -2) {
            estado.setMinimax(possivelVencedor);
            return estado;
        }
        
        ArrayList<EstadoJogo> novosEstados = estado.
                getFilhos(-1);
        
        int max = Integer.MIN_VALUE;
        
        EstadoJogo melhor = null;
        
        for(EstadoJogo filho:novosEstados) {
            EstadoJogo possivelMelhor = min(filho, nivel);
            if(possivelMelhor.getMinimax()> max) {
                melhor = possivelMelhor;
                max = possivelMelhor.getMinimax();
            }
        }
        estado.setMelhorAcao(melhor.getAcao());
        estado.setMinimax(max);
        return estado;        
    }
    
    private EstadoJogo min(EstadoJogo estado, int nivel) {
        nivel++;
        System.out.println("valor nivel min "+nivel);
        int possivelVencedor = estado.determinarVencedor();
        if(possivelVencedor != -2) {
            estado.setMinimax(possivelVencedor);
            return estado;
        }
        
        ArrayList<EstadoJogo> novosEstados = estado.
                getFilhos(1);
        
        int min = Integer.MAX_VALUE;
        
        EstadoJogo melhor = null;
        for(EstadoJogo filho:novosEstados) {
            EstadoJogo possivelMelhor = max(filho, nivel);
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
