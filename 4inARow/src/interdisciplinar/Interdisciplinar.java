/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interdisciplinar;

/**
 *
 * @author João Pedro
 */
public class Interdisciplinar {

    // Mantém informações a respeito do estado atual do jogo.
    private static EstadoJogo estado;
    // Armazena qual é o jogador atual...
    private static int jogadorAtual;
    
    
    public static void fazJogada (int coluna) {
        //ao clicar no botao, chamar esse metodo
        if (jogadorAtual == -1) {
            if (estado.realizarJogada(-1, coluna)) {
                //estado.imprimeMatriz();
                jogadorAtual = 1;
                Minimax minimax = new Minimax(estado.clonar());
                int jogada = minimax.melhorJogada();
                estado.realizarJogada(1, jogada);
                jogadorAtual = -1;
                estado.imprimeMatriz();
                if(1==estado.determinarVencedor()){
                    View.setViewVerde();
                }else if(-1==estado.determinarVencedor()){
                    View.setViewAmarelo();
                }
            }
        }
        
    }
    
    public static void inicializarEstadoJogo() {
        estado = new EstadoJogo();
        jogadorAtual = -1; // Quem começa a jogar é humano
    }
}
