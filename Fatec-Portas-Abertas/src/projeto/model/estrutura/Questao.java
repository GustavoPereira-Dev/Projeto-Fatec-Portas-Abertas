package projeto.model.estrutura;

public class Questao {
    private String pergunta;
    private String[] alternativas;
    private int respostaCorreta;

    public Questao(String pergunta, String[] alternativas, int respostaCorreta) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }
}
