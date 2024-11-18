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

    //Método para realizar uma jogada
    public boolean fazerJogada(int linha, int coluna) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }
        // Se a jogada for inválida, o retorno será false 
        return false; 
    }

    //Método para verificar se tem um vencedor 
    public boolean verificarVencedor() {
        // Deve-se verificar linhas, colunas e diagonais 
        // se o vencedor for encontrado, retornar true
        // caso não haja vencedor
        return false;  
    }

    //Método para verificar se tem empate
    public boolean verificarEmpate() {
        // Irá retornar true se não tiver tela 
        return true; 
    }

    // Método para trocar o jogador atual
    public void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}
