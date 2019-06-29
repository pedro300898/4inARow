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
        {2, 2, 2, 2, 2, 2},};
    public static final int CASA_VAZIA = 2;
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
        for (int i = 0; i < 6; ++i) {
            EstadoJogo e = clonar();
            if (e.realizarJogada(jogador, i)) {
                filhos.add(e);
            }
        }
        return filhos;
    }

    public EstadoJogo clonar() {
        EstadoJogo clone = new EstadoJogo();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                clone.casas[i][j] = casas[i][j];
            }
        }
        return clone;
    }

    public int determinarVencedor() {
        int vencedor = -1;

        //implementar 
        //diagonal
        if (casas[2][0] == casas[3][1] && casas[3][1] == casas[4][2]
                && casas[4][2] == casas[5][3] && casas[5][3] != EstadoJogo.CASA_VAZIA) {
            return casas[2][0];
        }

        if (casas[1][0] == casas[2][1] && casas[2][1] == casas[3][2]
                && casas[3][2] == casas[4][3] && casas[4][3] != EstadoJogo.CASA_VAZIA) {
            return casas[1][0];
        }
        if (casas[2][1] == casas[3][2] && casas[3][2] == casas[4][3]
                && casas[4][3] == casas[5][4] && casas[5][4] != EstadoJogo.CASA_VAZIA) {
            return casas[2][1];
        }

        if (casas[0][0] == casas[1][1] && casas[1][1] == casas[2][2]
                && casas[2][2] == casas[3][3] && casas[3][3] != EstadoJogo.CASA_VAZIA) {
            return casas[0][0];
        }
        if (casas[1][1] == casas[2][2] && casas[2][2] == casas[3][3]
                && casas[3][3] == casas[4][4] && casas[4][4] != EstadoJogo.CASA_VAZIA) {
            return casas[1][1];
        }
        if (casas[2][2] == casas[3][3] && casas[3][3] == casas[4][4]
                && casas[4][4] == casas[5][5] && casas[5][5] != EstadoJogo.CASA_VAZIA) {
            return casas[2][2];
        }

        if (casas[0][1] == casas[1][2] && casas[1][2] == casas[2][3]
                && casas[2][3] == casas[3][4] && casas[3][4] != EstadoJogo.CASA_VAZIA) {
            return casas[2][1];
        }
        if (casas[1][2] == casas[2][3] && casas[2][3] == casas[3][4]
                && casas[3][4] == casas[4][5] && casas[4][5] != EstadoJogo.CASA_VAZIA) {
            return casas[2][1];
        }
        if (casas[0][2] == casas[1][3] && casas[1][3] == casas[2][4]
                && casas[2][4] == casas[3][5] && casas[3][5] != EstadoJogo.CASA_VAZIA) {
            return casas[2][1];
        }

        
        
        
        if (casas[3][0] == casas[2][1] && casas[2][1] == casas[1][2]
                && casas[1][2] == casas[0][3] && casas[0][3] != EstadoJogo.CASA_VAZIA) {
            return casas[3][0];
        }
        if (casas[4][0] == casas[3][1] && casas[3][1] == casas[2][2]
                && casas[2][2] == casas[1][3] && casas[1][3] != EstadoJogo.CASA_VAZIA) {
            return casas[4][0];
        }
        if(casas[3][1] == casas[2][2] && casas[2][2] == casas[1][3]
                && casas[1][3] == casas[0][4] && casas[0][4] != EstadoJogo.CASA_VAZIA) {
            return casas[3][1];
        }
        if(casas[5][0] == casas[4][1] && casas[4][1] == casas[3][2]
                && casas[3][2] == casas[2][3] && casas[2][3] != EstadoJogo.CASA_VAZIA) {
            return casas[5][0];
        }
        if(casas[4][1] == casas[3][2] && casas[3][2] == casas[2][3]
                && casas[2][3] == casas[1][4] && casas[1][4] != EstadoJogo.CASA_VAZIA) {
            return casas[4][1];
        }
        if(casas[3][2] == casas[2][3] && casas[2][3] == casas[1][4]
                && casas[1][4] == casas[0][5] && casas[0][5] != EstadoJogo.CASA_VAZIA) {
            return casas[3][2];
        }
        if(casas[5][1] == casas[4][2] && casas[4][2] == casas[3][3]
                && casas[3][3] == casas[2][4] && casas[2][4] != EstadoJogo.CASA_VAZIA) {
            return casas[5][1];
        }
        if(casas[4][2] == casas[3][3] && casas[3][3] == casas[2][4]
                && casas[2][4] == casas[1][5] && casas[1][5] != EstadoJogo.CASA_VAZIA) {
            return casas[4][2];
        }
        if(casas[5][2] == casas[4][3] && casas[4][3] == casas[3][4]
                && casas[3][4] == casas[2][5] && casas[2][5] != EstadoJogo.CASA_VAZIA) {
            return casas[5][2];
        }
        return vencedor;
    }

}
