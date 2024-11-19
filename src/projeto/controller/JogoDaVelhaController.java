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
            //Exibir o tabuleiro
            System.out.println("Tabuleiro atual:");
            exibirTabuleiro();

            //Inicio da jogada, será digitado linha, depois coluna
            System.out.println("Digite o número da linha (1, 2 ou 3): ");
            int linha = obterEntrada() - 1;  
            System.out.println("Digite o número da coluna (1, 2 ou 3): ");
            int coluna = obterEntrada() - 1;  

            // Fazer a jogada
            if (estrutura.fazerJogada(linha, coluna)) {
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
                    // Opção para reiniciar o jogo.
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
            } else {
                System.out.println("Jogada inválida. Tente novamente.");
            }
        }
    }

    private void exibirTabuleiro() {
        char[][] tabuleiro = estrutura.tabuleiro;
        System.out.println("  1   2   3");
        for (int i = 0; i < 3; i++) {
        	// Exibir o número da coluna
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " "); 
                //Criar as divisões das colunas
                if (j < 2) System.out.print("| ");  
            }
            System.out.println();
            if (i < 2) {
                System.out.println("--------------"); 
            }
        }
    }

    private int obterEntrada() {
        return scanner.nextInt();
    }
}
