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
    private int empate = 36;
    
    public void imprimeMatriz() {
        View.setView(casas);
    }
    
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
        int jogador;
        int contador = 0;
        // Verifica ganhador na horizontal e vertical.
        for(int i = 5; i >=0; --i) {
            for(int j = 5; j >=0 ; --j){
                contador = 1;
                System.out.println("Fixo i:"+i+" j:"+j);
                jogador = casas[i][j];
                for(int k = 1; k < 3 ; k++){
                    int h = j-k;
                    if(h>=0){
                        System.out.println("visitou horizontal i:"+i+" J:"+h);
                    if(jogador != casas[i][(j-k)]) {
                        System.out.println("Break 1");
                        break;
                    }
                    contador++;
                    }
                }
                System.out.println("cont:"+contador);
                if(contador == 3 && jogador != 2) {
                    System.out.println("GG ez H");
                    return jogador;
                }
                contador = 1;
                System.out.println("Fixo i:"+i+" j:"+j);
                for(int k = 1; k < 3 ; k++){
                    int h = i-k;
                    if(h>=0){
                        System.out.println("visitou vertical i:"+h+" J:"+j);
                    if(jogador != casas[(i-k)][j]) {
                        System.out.println("Break 2");
                        break;
                    }
                    contador++;
                    }
                }
                System.out.println("cont:"+contador);
                if(contador == 3 && jogador != 2) {
                    System.out.println("GG ez V");
                    return jogador;
                }
            }
        }

        //diagonal principal
        if (casas[3][0] == casas[4][1] && casas[4][1] == casas[5][2]
                && casas[5][2]  != 2) {
            return casas[3][0];
        }
        if (casas[2][0] == casas[3][1] && casas[3][1] == casas[4][2]
                && casas[4][2]  != 2) {
            return casas[2][0];
        }
        if (casas[1][0] == casas[2][1] && casas[2][1] == casas[3][2]
                && casas[3][2] != 2) {
            return casas[1][0];
        }
        if (casas[2][1] == casas[3][2] && casas[3][2] == casas[4][3]
                && casas[4][3] != 2) {
            return casas[2][1];
        }
        if (casas[3][2] == casas[4][3] && casas[4][3] == casas[5][4]
                && casas[5][4] != 2) {
            return casas[3][2];
        }
        if (casas[3][1] == casas[4][2] && casas[4][2] == casas[5][3]
                && casas[5][3] != 2) {
            return casas[3][1];
        }
        if (casas[0][0] == casas[1][1] && casas[1][1] == casas[2][2]
                && casas[2][2] != 2) {
            return casas[0][0];
        }
        if (casas[1][1] == casas[2][2] && casas[2][2] == casas[3][3]
                && casas[3][3] != 2) {
            return casas[1][1];
        }
        if (casas[2][2] == casas[3][3] && casas[3][3] == casas[4][4]
                && casas[4][4] != 2) {
            return casas[2][2];
        }
        if (casas[3][3] == casas[4][4] && casas[4][4] == casas[5][5] 
                && casas[5][5]  != 2) {
            return casas[3][3];
        }
        if (casas[0][1] == casas[1][2] && casas[1][2] == casas[2][3]
                && casas[2][3] != 2) {
            return casas[2][1];
        }
        if (casas[1][2] == casas[2][3] && casas[2][3] == casas[3][4]
                && casas[3][4] != 2) {
            return casas[2][1];
        }
        if(casas[2][3] == casas[3][4] && casas[3][4] == casas[4][5]
                && casas[4][5] != 2){
            return casas[2][3];
        }
        if (casas[0][2] == casas[1][3] && casas[1][3] == casas[2][4]
                && casas[2][4] != 2) {
            return casas[2][1];
        }
        if (casas[1][3] == casas[2][4] && casas[2][4] == casas[3][5]
                && casas[3][5] != 2) {
            return casas[1][3];
        }
        if (casas[0][3] == casas[1][4] && casas[1][4] == casas[2][5]
                && casas[2][5] != 2) {
            return casas[0][3];
        }
        
        //diagonal secundária
        if (casas[2][0] == casas[1][1] && casas[1][1] == casas[0][2]
                && casas[0][2] != 2) {
            return casas[2][0];
        }
        if (casas[3][0] == casas[2][1] && casas[2][1] == casas[1][2]
                && casas[1][2] != 2) {
            return casas[3][0];
        }
        if (casas[2][1] == casas[1][2] && casas[1][2] == casas[0][3]
                && casas[0][3] != 2) {
            return casas[2][1];
        }
        if (casas[4][0] == casas[3][1] && casas[3][1] == casas[2][2]
                && casas[2][2] != 2) {
            return casas[4][0];
        }
        if (casas[3][1] == casas[2][2] && casas[2][2] == casas[1][3]
                && casas[1][3] != 2) {
            return casas[3][1];
        }
        if (casas[2][2] == casas[1][3] && casas[1][3] == casas[0][4]
                && casas[0][4] != 2) {
            return casas[4][2];
        }
        if (casas[5][0] == casas[4][1] && casas[4][1] == casas[3][2]
                && casas[3][2] != 2) {
            return casas[5][0];
        }
        if (casas[4][1] == casas[3][2] && casas[3][2] == casas[2][3]
                && casas[2][3] != 2) {
            return casas[4][1];
        }
        if (casas[3][2] == casas[2][3] && casas[2][3] == casas[1][4]
                && casas[1][4] != 2) {
            return casas[3][2];
        }
        if (casas[2][3] == casas[1][4] && casas[1][4] == casas[0][5]
                && casas[0][5] != 2) {
            return casas[2][3];
        }
        if (casas[5][1] == casas[4][2] && casas[4][2] == casas[3][3]
                && casas[3][3] != 2) {
            return casas[5][1];
        }
        if (casas[4][2] == casas[3][3] && casas[3][3] == casas[2][4]
                && casas[2][4] != 2) {
            return casas[4][2];
        }
        if (casas[3][3] == casas[2][4] && casas[2][4] == casas[1][5]
                && casas[1][5] != 2) {
            return casas[3][3];
        }
        if (casas[5][2] == casas[4][3] && casas[4][3] == casas[3][4]
                && casas[3][4] != 2) {
            return casas[5][2];
        } 
        if (casas[4][3] == casas[3][4] && casas[3][4] == casas[2][5]
                && casas[2][5] != 2) {
            return casas[4][3];
        }
        if (casas[5][3] == casas[4][4] && casas[4][4] == casas[3][5]
                && casas[3][5] != 2) {
            return casas[5][3];
        }
        empate--;
        if(empate == 0){
            return empate;
        }    
        return -2;
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
