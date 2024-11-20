package projeto.controller;

//Obs.: Podem fazer as alterações que quiserem, ainda está incompleto

import projeto.model.estrutura.JogoDaVelha;
import java.util.Scanner;

public class JogoDaVelhaController {
    private JogoDaVelha estrutura;
    private Scanner scanner;
    
    public JogoDaVelhaController(JogoDaVelha estrutura) {
        this.estrutura = estrutura;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarJogo() {      
        while (true) {
            // Fazer a jogada
        	validarTabuleiro();
            
            if (estrutura.verificarVencedor()) {
                exibirTabuleiro();
                System.out.println("Jogador " + estrutura.jogadorAtual + " venceu!");
                // Opção para reiniciar o jogo:
                // System.out.println("Deseja jogar novamente? (S/N)");
                // String resposta = scanner.next().toUpperCase();
                // if (!resposta.equals("S")) {
                //     System.out.println("Obrigado por jogar!");
                //     break;
                // }
                break;
            } else if (estrutura.verificarEmpate()) {
                exibirTabuleiro();
                System.out.println("Empate!");
                // Opção para reiniciar o jogo:
                // System.out.println("Deseja jogar novamente? (S/N)");
                // String resposta = scanner.next().toUpperCase();
                // if (!resposta.equals("S")) {
                //     System.out.println("Obrigado por jogar!");
                //     break;
                // }
                break;
            }
                // Trocar o jogador
                estrutura.trocarJogador();
        }
    }

    private void exibirTabuleiro() {
        char[][] tabuleiro = estrutura.tabuleiro;
        System.out.println("Tabuleiro atual:\n   1   2   3");
        for (int i = 0; i < 3; i++) {
        	// Exibir o número da coluna
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j]); 
                //Criar as divisões das colunas
                if (j < 2) System.out.print(" |");  
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  ---+---+---"); 
            }
        }
    }
    
    private void validarTabuleiro() {
    	int linha, coluna;
    	while (true){
            //Exibir o tabuleiro
            exibirTabuleiro();
            //Inicio da jogada, será digitado linha, depois coluna
            linha = obterEntrada("Vez do jogador '" + estrutura.jogadorAtual + "'\nDigite o número da linha (1, 2 ou 3): ") - 1;  
            coluna = obterEntrada("Digite o número da coluna (1, 2 ou 3): ") - 1;

            if (estrutura.fazerJogada(linha, coluna)){
                break; // Valida a jogada
            }
            System.out.println("\nJogada inválida, tente novamente");
        }
    }
    private int obterEntrada(String mensagem) {
        int entrada = 0;
        while (true) {
        	try {
    	        System.out.println(mensagem);
    		    entrada = Integer.parseInt(scanner.nextLine());
    		    if (entrada >= 1 && entrada <= 3) {
    			    break;
    		    } else {
    			    System.out.println("Entrada inválida, tente novamente.");
    		    }
    	    } catch (NumberFormatException e) {
    		    System.out.println("Entrada inválida, tente novamente.");
    	    }
        }
        return entrada;
    }

}
