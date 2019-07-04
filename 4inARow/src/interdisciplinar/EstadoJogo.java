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
    
    public void imprimeMatriz() {
        for (int i = 0; i < casas.length; i++) {
            for (int j = 0; j < casas[i].length; j++) {
                System.out.print(casas[i][j]+" ");
            }
            System.out.println("");
        }
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
        int vencedor = 0;

        //implementar 
        
        int jogador;
        int contador = 0;
        // Verifica ganhador na horizontal e vertical.
        for(int i = 5; i > 2; --i) {
            jogador = casas[i][5];
            contador = 1;
            for(int j = 4; j > 2; --j) {
                if(jogador != casas[i][j]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            }
            jogador = casas[5][i];
            contador = 1;
            for(int j = 4; j > 2; --j) {
                if(jogador != casas[j][i]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            }
        }
        for(int i = 4; i > 1; --i) {
            jogador = casas[i][5];
            contador = 1;
            
            jogador = casas[i][4];
            contador = 1;
            for(int j = 3; j > 1; --j) {
                if(jogador != casas[i][j]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            }
            jogador = casas[4][i];
            contador = 1;
            for(int j = 3; j > 1; --j) {
                if(jogador != casas[j][i]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            } 
         }
         for(int i = 3; i > 0; --i) {
            jogador = casas[i][5];
            contador = 1;
            jogador = casas[i][3];
            contador = 1;
            for(int j = 2; j > 0; --j) {
                if(jogador != casas[i][j]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            }
            jogador = casas[3][i];
            contador = 1;
            for(int j = 2; j > 0; --j) {
                if(jogador != casas[j][i]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            }
        } 
        for(int i = 2; i >= 0 ; --i) {
            jogador = casas[i][5];
            contador = 1;
            jogador = casas[i][2];
            contador = 1;
            for(int j = 1; j >= 0 ; --j) {
                if(jogador != casas[i][j]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            }
            jogador = casas[2][i];
            contador = 1;
            for(int j = 1; j >=0; --j) {
                if(jogador != casas[j][i]) {
                    break;
                }
                contador++;
            }
            if(contador == 3 && jogador != 2) {
                return jogador;
            } 
        }

        //diagonal principal adicionar as diagonais que faltam
        
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
        if (casas[0][1] == casas[1][2] && casas[1][2] == casas[2][3]
                && casas[2][3] != 2) {
            return casas[2][1];
        }
        if (casas[1][2] == casas[2][3] && casas[2][3] == casas[3][4]
                && casas[3][4] != 2) {
            return casas[2][1];
        }
        if (casas[0][2] == casas[1][3] && casas[1][3] == casas[2][4]
                && casas[2][4] != 2) {
            return casas[2][1];
        }

        //diagonal secundária adicionar as diagonais que faltam
        if (casas[3][0] == casas[2][1] && casas[2][1] == casas[1][2]
                && casas[1][2] != 2) {
            return casas[3][0];
        }
        if (casas[4][0] == casas[3][1] && casas[3][1] == casas[2][2]
                && casas[2][2] != 2) {
            return casas[4][0];
        }
        if (casas[3][1] == casas[2][2] && casas[2][2] == casas[1][3]
                && casas[1][3] != 2) {
            return casas[3][1];
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
        if (casas[5][1] == casas[4][2] && casas[4][2] == casas[3][3]
                && casas[3][3] != 2) {
            return casas[5][1];
        }
        if (casas[4][2] == casas[3][3] && casas[3][3] == casas[2][4]
                && casas[2][4] != 2) {
            return casas[4][2];
        }
        if (casas[5][2] == casas[4][3] && casas[4][3] == casas[3][4]
                && casas[3][4] != 2) {
            return casas[5][2];
        } 
        
        
        return vencedor;
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
