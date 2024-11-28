package projeto.model.estrutura;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Questionario {
    private String pergunta;
    private String[] alternativas;
    private int respostaCorreta;

    public Questionario(String pergunta, String[] alternativas, int respostaCorreta) {
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

    public void embaralharAlternativas() {
        List<String> listaAlternativas = Arrays.asList(alternativas);
        Collections.shuffle(listaAlternativas);
        listaAlternativas.toArray(alternativas);
        respostaCorreta = listaAlternativas.indexOf(alternativas[respostaCorreta]);
    }
}
