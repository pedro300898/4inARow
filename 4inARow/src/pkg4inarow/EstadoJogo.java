/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4inarow;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public class EstadoJogo {
    
    
    public int[][] casas = {
        {2, 2, 2, 2, 2, 2}, 
        {2, 2, 2, 2, 2, 2}, 
        {2, 2, 2, 2, 2, 2}, 
        {2, 2, 2, 2, 2, 2}, 
        {2, 2, 2, 2, 2, 2}, 
        {2, 2, 2, 2, 2, 2}, 
    };
    
    private int minimax = 0;
    private int acao;
    private int melhorAcao;
    
    
    
    
    public boolean realizarJogada(int jogador, int posicao) {
        for (int i = 5; i >= 0; i--) {
            if (casas[i][posicao] == 2) {
                this.acao = i;
                this.casas[i][posicao] = jogador;
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<EstadoJogo> getFilhos(int jogador) {
        ArrayList<EstadoJogo> filhos = new ArrayList();
        for(int i = 0; i < 6; ++i) {
            EstadoJogo e = clonar();
            if(e.realizarJogada(jogador, i)) {
                filhos.add(e);
            }
        } 
        return filhos;
    }
    
    public EstadoJogo clonar() {
        EstadoJogo clone = new EstadoJogo();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 6; j++) {
                clone.casas[i][j] = casas[i][j];
            }
        }
        return clone;
    }
    
    public int determinarVencedor() {
        int vencedor = -1;
        
        //implementar 
        
        
        return vencedor;
    }
    
    
    
    
    
}
