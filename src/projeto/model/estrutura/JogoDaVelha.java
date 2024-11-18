package projeto.model.estrutura;

//Obs.: Podem fazer as alterações que quiserem, ainda está incompleto

public class JogoDaVelha {
    // Tabuleiro
    public char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    // Jogador inicial é 'X', porém pode ser alterado
    public char jogadorAtual = 'X'; 

    // Método para realizar uma jogada
    public boolean fazerJogada(int linha, int coluna) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }
        // Se a jogada for inválida, o retorno será false 
        return false; 
    }

    // Método para verificar se tem um vencedor 
    public boolean verificarVencedor() {
        for (int num = 0; num < 3; num++) { // Verificação por linha e coluna
    	    if (tabuleiro[num][0] == jogadorAtual && tabuleiro[num][1] == jogadorAtual && tabuleiro[num][2] == jogadorAtual)
    	        return true;
    	    if (tabuleiro[0][num] == jogadorAtual && tabuleiro[1][num] == jogadorAtual && tabuleiro[2][num] == jogadorAtual)
    		    return true;
        }
        // Verificação das diagonais
        if (tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual && tabuleiro[3][3] == jogadorAtual)
            return true;
        if (tabuleiro[1][3] == jogadorAtual && tabuleiro[2][2] == jogadorAtual && tabuleiro[3][1] == jogadorAtual)
            return true;
        // Sem vencedores, retorna false
        return false;  
    }

    // Método para verificar se tem empate
    public boolean verificarEmpate() {
        // Verifica se há espaços vazios ainda 
        for (int i = 0; i < 3; i++) {
    	    for (int j = 0; j < 3; j++) {
    		    if (tabuleiro[i][j] == ' ')
    			    return false;
    	    }
        }
        // Irá retornar true se não tiver tela
        return true; 
    }

    // Método para trocar o jogador atual
    public void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    // Retorna o jogador atual
    public char getJogador(){
        return jogadorAtual;
    }
}
