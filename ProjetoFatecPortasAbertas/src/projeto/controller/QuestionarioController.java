package projeto.controller;

import projeto.model.estrutura.Questao;

import java.util.ArrayList;
import java.util.List;

public class QuestionarioController {
    private List<Questao> questoes;
    private int indiceAtual;
    private int acertos;
    private int erros;

    public QuestionarioController() {
        this.questoes = carregarQuestoes();
        this.indiceAtual = 0;
        this.acertos = 0;
        this.erros = 0;
    }

    private List<Questao> carregarQuestoes() {
        List<Questao> lista = new ArrayList<>();
        lista.add(new Questao("Qual é a versão mais recente do HTML?", new String[]{"HTML9", "HTML3", "HTML E4", "HTML 5", "HTML E5"}, 3));
        lista.add(new Questao("Para aparecer uma mensagem na tela em JavaScript, qual é o comando utilizado?", new String[]{"alert", "console.log", "console", "print", "System.out.println"}, 0));
        lista.add(new Questao("Para que serve o 3FN em Normalização?", new String[]{"Eliminação de dependências entre os atributos chaves", "Diminuição de redundâncias nas tabelas", "Organização dos atributos que dependem uns aos outros", "Tratamento de repetições de valores", "Otimização da execução de busca"}, 2));
        lista.add(new Questao("Do que se trata o inner join em SQL?", new String[]{"É o retorno de todos os registros da tabela A e dos comuns em A e B", "É o retorno de registros mais comuns de duas tabelas", "É o retorno de todos os registros da tabela B e dos comuns em A e B", "É o retorno de todos os registros de ambas as tabelas", "É o retornos de registros exclusivos das 2 tabelas"}, 1));
        lista.add(new Questao("Qual é a estrutura de repetição que a verificação é feita ao final da execução?", new String[]{"for (para)", "while (enquanto)", "do for (faça for)", "for while (para enquanto)", "do while (faça enquanto)"}, 4));
        lista.add(new Questao("Que comando na linha de comandos (cmd) é utilizado para o versionamento de projetos pelo Github?", new String[]{"github", "gitbucket", "heroku", "git", "notepad"}, 3));
        lista.add(new Questao("Quais respectivamente são as três principais linguagens ou extensões de arquivos utilizadas no desenvolvimento web e sua funcionalidades?", new String[]{"HTML: esqueleto da página; CSS: estilização; PHP: Lógica e conexão com o Banco de dados", "HTML: Lógica e dinamismo da página; CSS: estilização; JS: Esqueleto da página", "HTML: Lógica e dinamismo da página; CSS: Esqueleto da página; JS: Estilização", "HTML: esqueleto da página; CSS: estilização; JS: Lógica e dinamismo da página", "HTML: Estilização; CSS: Esqueleto da página; JS: Lógica e dinamismo da página"}, 3));
        lista.add(new Questao("No principal do pacote Office (ou 365 para empresas), quais são os Aplicativos principais?", new String[]{"Outlook, Access, OneNote", "PowerPoint, Word, Excel", "PowerPoint, Onenote, OneDrive", "OneDrive, Azure, OneNote", "Excel, Access, Outlook"}, 1));
        lista.add(new Questao("Qual o limite de linhas aceitado pelo Excel?", new String[]{"100000 linhas", "500000 linhas", "98316 linhas", "102831 linhas", "1048576 linhas"}, 4));
        lista.add(new Questao("Quais são as principais seleções no Word?", new String[]{"Arquivo, Página Inicial, Tabelas e Imagens, Design, Layout, Referências, Correspondências, Revisão, Exibir", "Arquivo, Página Inicial, Inserir, Design, Layout, Bibliografia, Correspondências, Revisão, Exibir", "Arquivo, Página Inicial, Inserir, Design, Layout, Referências, Correspondências, Revisão, Exibir", "Arquivo, Página Inicial, Inserir, Design, Layout, Bibliografia, Correspondências, Revisão, Exportar", "Arquivo, Menu, Inserir, Design, Layout, Bibliografia, Correspondências, Revisão, Exportar"}, 2));
        lista.add(new Questao("Veja o valor dessa variável: var[5][11]. O que significaria isso?", new String[]{"É um Vetor de 5 linhas e 11 colunas", "É um Vetor de 5 colunas e 11 linhas", "É um variável com 16 espaços de armazenamento", "É uma Matriz de 5 linhas e 11 colunas", "É uma Matriz de 5 colunas e 11 linhas"}, 3));
        lista.add(new Questao("Leia o enunciado: \"essa operação lógica faz com que se verifique se todos os valores verdadeiros. Sua contraparte é verificar somente um verdadeiro\". Do que se refere os dois operadores citados?", new String[]{"||(ou) e &&(e)", "não(!) e ||(ou)", "||(ou) e não(!)", "&&(e) e ||(ou)", "&&(e) e não(!)"}, 3));
        lista.add(new Questao("Quais são as principais estruturas condicionais?", new String[]{"if(se), else(se não), if else(se se não), switch if(escolha se)", "switch else(escolha se não), else if(se não se), else(se não), if (se)", "switch if(escolha se), else if(se não se), else(se não), if else (se se não)", "if switch(se escolha), switch(escolha), else(se não), if else(se não se)", "if(se), else(se não), else if(se não se), switch(escolha)"}, 4));
        lista.add(new Questao("Que sinal é utilizado no Excel para fazer um cálculo ou uso de fórmula em uma célula?", new String[]{"!", "=", ".", "@", ">"}, 1));
        lista.add(new Questao("Complete: Mesmo o Gimp quanto o Adobe Photoshop e outros editores de imagem costumam ter uma funcionalidade específica para adicionar diversos objetos e imagens entre ____", new String[]{"cascas", "espaços", "camadas", "máscaras", "coberturas"}, 2));
        return lista;
    }

    public Questao getQuestaoAtual() {
        return questoes.get(indiceAtual);
    }

    public boolean responder(int indiceResposta) {
        boolean acertou = (indiceResposta == getQuestaoAtual().getRespostaCorreta());
        if (acertou) {
            acertos++;
        } else {
            erros++;
        }
        indiceAtual++;
        return acertou;
    }

    public boolean temProximaQuestao() {
        return indiceAtual < questoes.size();
    }

    public int getAcertos() {
        return acertos;
    }

    public int getErros() {
        return erros;
    }
}
