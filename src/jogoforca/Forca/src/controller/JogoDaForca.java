package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    public void jogarForca() {
        // Lista de palavras
    	String[] palavrasVetor = {"Estrutura","Mordida","Seita","Oftalmologista","Socorro","Faculdade","Malvada","Abacaxi","Churrasco","Deuses","Sushi", "Borboleta", "Canguru", "Desenho", "Elefante", "Fantasia", "Girassol", "Harmonia", "Iguana", "Jangada", "Koala", "Libelula", "Magia", "Navegar", "Oceano", "Passaro", "Quimera", "Relampago", "Sabedoria", "Tartaruga", "Universo", "Violino", "Xadrez", "Zebrado", "Amizade", "Baleia", "Carrossel", "Diamante", "Estrela", "Foguete", "Gato", "Hidrante", "Ilusao", "Jupiter", "Kiwi", "Lua", "Mosaico", "Nuvem", "Ovelha", "Pintura", "Quadro", "Romance", "Sereia", "Tulipa", "Urso", "Vulcao", "Web", "Secreto", "Yoga", "Zodiaco" };
    	
        List<String> palavras = new ArrayList<>();
        for (String palavra : palavrasVetor) {
            palavras.add(palavra); //Adiciona palavras na lista
        }

        // Objetos
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
    	System.out.println("---------------------------------------------------");
    	System.out.println("----- Jogo da Forca FATEC Portas Abertas 2024 -----");
    	System.out.println("---------------------------------------------------");
    	System.out.println("Não há diferenciação entre maíusculas e minúsculas");
    	System.out.println("Palpites repetidos serão desconsiderados");
    	System.out.println("---------------------------------------------------");
        
        // Loop do jogo da forca
        boolean jogo = true;
        while(jogo) {
        	
        	
        	String palavra = palavras.remove(random.nextInt(palavras.size())); //Sorteia palavra e remove da lista
        	
        	palavra = palavra.toUpperCase();
        	
        	// Inicializa variáveis para o jogo da forca
            StringBuilder palavraOculta = new StringBuilder("_".repeat(palavra.length()));
            int tentativas = 6;
            boolean acertou = false;
            List<Character> letrasUsadas = new ArrayList<>();
        	
            while (tentativas > 0 && !acertou) { //Loop de jogo
                System.out.println("\nPalavra: " + palavraOculta);
                System.out.println("Tentativas restantes: " + tentativas);
                System.out.println("Letras usadas: " + letrasUsadas);
                System.out.print("Escolha uma letra: ");
               
                String palpite = scanner.nextLine();
                palpite = palpite.toUpperCase();
                
                char letra = palpite.charAt(0);
                
                if (letrasUsadas.contains(letra)) {
                    System.out.println("Você já usou essa letra!");
                    continue;
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
                } else {
                    tentativas--;
                    System.out.println("Palpite incorreto!\n");
                    switch (tentativas) {
					case 5:
						System.out.println("   (_)   ");
						break;
					case 4:
						System.out.println("   (_)   ");
						System.out.println("   ||   ");
						break;
					case 3:
						System.out.println("     (_)   ");
						System.out.println("   --||  ");
						break;
					case 2:
						System.out.println("      (_)   ");
						System.out.println("    --||--    ");
						break;
					case 1:
						System.out.println("      (_)   ");
						System.out.println("    --||--    ");
						System.out.println("     _|    ");
						break;
					case 0:
						System.out.println("      (_)   ");
						System.out.println("    --||--    ");
						System.out.println("     _||_    ");
						break;
					}
                    
                }
            }

            // Resultado do jogo
            if (acertou) {
                System.out.println("Parabéns! Você adivinhou a palavra: " + palavra);
            } else {
                System.out.println("Que pena! Você não conseguiu adivinhar a palavra: " + palavra);
            }
            
            System.out.println("\nGostaria de jogar de novo? (S/N)");
            String resposta = scanner.nextLine();
            
            if(!resposta.equalsIgnoreCase("S")) {
            	jogo = false;
            }
        }
        scanner.close();
    }
}