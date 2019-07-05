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
public class EstadoJogo {
    
public int[][] casas = {
        {0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0}, 
    };

    public int[][] getCasas() {
        return casas;
    }

    public void setCasas(int[][] casas) {
        this.casas = casas;
    }
    
    private int acao;
    private int melhorAcao;
    private int minimax;
    
    public void imprimeMatriz() {
//        for(int i = 0; i < 6;i++){
//            for(int j =0; j< 6;j++){
//                System.out.print(" "+casas[i][j]);
//            }
//            System.out.println("");
//        }
        View.setView(casas);
    }
    
    public boolean realizarJogada(int jogador, int posicao) {
        for (int i = 5; i >= 0; i--) {
            if (casas[i][posicao] == 0) {
                //this.acao = i;
                this.casas[i][posicao] = jogador;
                this.acao=posicao;
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
        //clone.imprimeMatriz();
        return clone;
    }
    
    public int determinarVencedor() {
        int jogador;
        int contador = 0;
        // Verifica ganhador na horizontal e vertical.
        for(int i = 5; i >=0; --i) {
            for(int j = 5; j >=0 ; --j){
                contador = 1;
                jogador = casas[i][j];
                for(int k = 1; k < 4 ; k++){
                    int h = j-k;
                    if(h>=0){
                    if(jogador != casas[i][(j-k)]) {
                        break;
                    }
                    contador++;
                    }
                }
                if(contador == 4 && jogador != 0) {
                    return jogador;
                }
                contador = 1;
                for(int k = 1; k < 4 ; k++){
                    int h = i-k;
                    if(h>=0){
                    if(jogador != casas[(i-k)][j]) {
                        break;
                    }
                    contador++;
                    }
                }
                if(contador == 4 && jogador != 0) {
                    return jogador;
                }
            }
        }
        
        for(int k = 0; k < 6; k++){
            contador = 0;
            int ultimo = 0;
            for(int i = k, j = 0; i >=0 && j<6; i--, j++){
                if(casas[i][j] == 0){
                    contador = 0;
                    ultimo = 0;
                }else if(casas[i][j] == ultimo){
                    contador++;
                    if(contador == 4) {
                        return ultimo;
                    }
                }else{
                    ultimo = casas[i][j];
                    contador=1;
                }
            }
            
            contador = 0;
            ultimo = 0;
            for(int i = k, j = 0; i < 6 && j<6; i++, j++){
                if(casas[i][j] == 0){
                    contador = 0;
                    ultimo = 0;
                }else if(casas[i][j] == ultimo){
                    contador++;
                    if(contador == 4) {
                        return ultimo;
                    }
                }else{
                    ultimo = casas[i][j];
                    contador=1;
                }
            }
            
            contador = 0;
            ultimo = 0;
            for(int j = k, i = 0; i < 6 && j<6; i++, j++){
                if(casas[i][j] == 0){
                    contador = 0;
                    ultimo = 0;
                }else if(casas[i][j] == ultimo){
                    contador++;
                    if(contador == 4) {
                        return ultimo;
                    }
                }else{
                    ultimo = casas[i][j];
                    contador=1;
                }
            }
            
            contador = 0;
            ultimo = 0;
            for(int j = k, i = 5; i >= 0 && j<6; i--, j++){
                if(casas[i][j] == 0){
                    contador = 0;
                    ultimo = 0;
                }else if(casas[i][j] == ultimo){
                    contador++;
                    if(contador == 4) {
                        return ultimo;
                    }
                }else{
                    ultimo = casas[i][j];
                    contador=1;
                }
            }
        }
        return 0;
    }

    /**
     * @return the melhorAcao
     */
    public int getMelhorAcao() {
        return melhorAcao;
    }

    /**
     * @param minimax the minimax to set
     */
    public void setMinimax(int minimax) {
        this.minimax = minimax;
    }

    /**
     * @return the minimax
     */
    public int getMinimax() {
        return minimax;
    }

    /**
     * @return the acao
     */
    public int getAcao() {
        return acao;
    }

    /**
     * @param melhorAcao the melhorAcao to set
     */
    public void setMelhorAcao(int melhorAcao) {
        this.melhorAcao = melhorAcao;
    }
    
    
    
    
    
}
