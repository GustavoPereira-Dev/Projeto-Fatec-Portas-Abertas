package projeto.controller;

import projeto.model.estrutura.JogoDaVelha;

public class JogoDaVelhaController {
    private JogoDaVelha estrutura;

    public JogoDaVelhaController(JogoDaVelha estrutura) {
        this.estrutura = estrutura;
    }

    public boolean fazerJogada(int linha, int coluna) {
        return estrutura.fazerJogada(linha, coluna);
    }

    public boolean verificarVencedor() {
        return estrutura.verificarVencedor();
    }

    public boolean verificarEmpate() {
        return estrutura.verificarEmpate();
    }

    public void trocarJogador() {
        estrutura.trocarJogador();
    }

    public char getJogadorAtual() {
        return estrutura.getJogadorAtual();
    }

    public char[][] getTabuleiro() {
        return estrutura.getTabuleiro();
    }

    public void reiniciarTabuleiro() {
        estrutura.reiniciarTabuleiro();
    }
}
