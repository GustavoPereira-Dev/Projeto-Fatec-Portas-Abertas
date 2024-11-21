package projeto.controller;

import java.util.Random;

public class Adivinhacao {
    private Random random = new Random();
    private int numero;
    private int tentativas;

    public Adivinhacao() {
        this.numero = gerarNumero();
        this.tentativas = 0;
    }

    public int gerarNumero() {
        return random.nextInt(101);
    }

    public boolean verificarChute(int chute) {
        tentativas++;
        return chute == numero;
    }

    public String obterDica(int chute) {
        if (chute > numero) {
            return "O número é menor.";
        } else {
            return "O número é maior.";
        }
    }

    public int getNumero() {
        return numero;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void reiniciarJogo() {
        this.numero = gerarNumero();
        this.tentativas = 0;
    }
}
