package projeto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JogoDaForca {
    private String[] palavrasVetor = {"Estrutura","Mordida","Seita","Oftalmologista","Socorro","Faculdade","Malvada","Abacaxi","Churrasco","Deuses","Sushi", "Borboleta", "Canguru", "Desenho", "Elefante", "Fantasia", "Girassol", "Harmonia", "Iguana", "Jangada", "Koala", "Libelula", "Magia", "Navegar", "Oceano", "Passaro", "Quimera", "Relampago", "Sabedoria", "Tartaruga", "Universo", "Violino", "Xadrez", "Zebrado", "Amizade", "Baleia", "Carrossel", "Diamante", "Estrela", "Foguete", "Gato", "Hidrante", "Ilusao", "Jupiter", "Kiwi", "Lua", "Mosaico", "Nuvem", "Ovelha", "Pintura", "Quadro", "Romance", "Sereia", "Tulipa", "Urso", "Vulcao", "Web", "Secreto", "Yoga", "Zodiaco"};
    private List<String> palavras;
    private Random random = new Random();
    private int tentativas;
    private String palavra;
    private StringBuilder palavraOculta;
    private List<Character> letrasUsadas;
    private boolean acertou;

    public JogoDaForca() {
        palavras = new ArrayList<>();
        for (String palavra : palavrasVetor) {
            palavras.add(palavra);
        }
    }

    public void iniciarJogo() {
        palavra = palavras.remove(random.nextInt(palavras.size())).toUpperCase();
        palavraOculta = new StringBuilder("_".repeat(palavra.length()));
        tentativas = 6;
        letrasUsadas = new ArrayList<>();
        acertou = false;
    }

    public String getPalavraOculta() {
        return palavraOculta.toString();
    }

    public int getTentativas() {
        return tentativas;
    }

    public List<Character> getLetrasUsadas() {
        return letrasUsadas;
    }

    public boolean verificarPalpite(char letra) {
        if (letrasUsadas.contains(letra)) {
            return false;
        }

        letrasUsadas.add(letra);
        if (palavra.indexOf(letra) >= 0) {
            for (int i = 0; i < palavra.length(); i++) {
                if (palavra.charAt(i) == letra) {
                    palavraOculta.setCharAt(i, letra);
                }
            }
            if (palavraOculta.toString().equals(palavra)) {
                acertou = true;
            }
            return true;
        } else {
            tentativas--;
            return false;
        }
    }

    public boolean isAcertou() {
        return acertou;
    }

    public String getPalavra() {
        return palavra;
    }
}
