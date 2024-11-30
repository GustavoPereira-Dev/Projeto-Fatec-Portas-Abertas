package projeto.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import projeto.controller.QuestionarioController;
import projeto.model.estrutura.Questao;

public class QuestionarioGUI extends JFrame {
    private int numeroPergunta = 0;
    private QuestionarioController controle;
    private JPanel painelPergunta;
    private JPanel painelResultado;
    private JButton proximaButton;
    private CardLayout cardLayout;
    private JPanel painelCards;
    private JButton[] botoesAlternativas;
    private int respostaSelecionada = -1;

    public QuestionarioGUI() {
        controle = new QuestionarioController();
        setTitle("Quiz de Tecnologia");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(173, 216, 230));

        cardLayout = new CardLayout();
        painelCards = new JPanel(cardLayout);

        painelPergunta = new JPanel();
        painelPergunta.setBackground(new Color(240, 248, 255));
        painelPergunta.setBorder(new EmptyBorder(20, 20, 20, 20));
        painelCards.add(painelPergunta, "Pergunta");

        painelResultado = new JPanel();
        painelResultado.setBackground(new Color(240, 248, 255));
        painelResultado.setBorder(new EmptyBorder(20, 20, 20, 20));
        painelResultado.setLayout(new BoxLayout(painelResultado, BoxLayout.Y_AXIS));
        painelCards.add(painelResultado, "Resultado");

        getContentPane().add(painelCards);
        exibirPergunta();

        setVisible(true);
    }

    private void criarPergunta(String pergunta, String[] opcoes) {
        painelPergunta.removeAll();
        painelPergunta.setLayout(new BoxLayout(painelPergunta, BoxLayout.Y_AXIS));

        JLabel perguntaLabel = new JLabel("<html><body style='width: 550px;'>" + pergunta + "</body></html>");
        perguntaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        perguntaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        //("<html><body style='width: 200px;'>Este é um exemplo de JLabel que contém texto longo e que será quebrado em várias linhas se ultrapassar a largura permitida.</body></html>"
        painelPergunta.add(Box.createRigidArea(new Dimension(0, 20)));
        painelPergunta.add(perguntaLabel);

        JPanel opcoesPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        opcoesPanel.setBackground(new Color(240, 248, 255));

        botoesAlternativas = new JButton[opcoes.length];
        for (int i = 0; i < opcoes.length; i++) {
            JButton opcao = new JButton("<html><div style='text-align: center;'>" + opcoes[i] + "</div></html>");
            opcao.setFont(new Font("SansSerif", Font.PLAIN, 14));
            opcao.setBackground(Color.WHITE);
            opcao.setFocusPainted(false);
            opcao.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            opcao.setCursor(new Cursor(Cursor.HAND_CURSOR));

            final int indice = i;
            opcao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JButton botao : botoesAlternativas) {
                        botao.setBackground(Color.WHITE);
                    }
                    opcao.setBackground(new Color(144, 238, 144));
                    respostaSelecionada = indice;
                    proximaButton.setEnabled(true);
                }
            });

            botoesAlternativas[i] = opcao;
            opcoesPanel.add(opcao);
        }

        painelPergunta.add(Box.createRigidArea(new Dimension(0, 20)));
        painelPergunta.add(opcoesPanel);

        proximaButton = new JButton("Continuar");
        proximaButton.setEnabled(false);
        proximaButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        proximaButton.setBackground(new Color(34, 139, 34));
        proximaButton.setForeground(Color.WHITE);
        proximaButton.setFocusPainted(false);
        proximaButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        proximaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        proximaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (respostaSelecionada != -1) {
                    if (respostaSelecionada != controle.getQuestaoAtual().getRespostaCorreta()) {
                        botoesAlternativas[respostaSelecionada].setBackground(Color.RED);
                    }
                    controle.responder(respostaSelecionada);
                    respostaSelecionada = -1;
                    Timer timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            numeroPergunta++;
                            exibirPergunta();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });

        painelPergunta.add(Box.createRigidArea(new Dimension(0, 20)));
        painelPergunta.add(proximaButton);

        painelPergunta.revalidate();
        painelPergunta.repaint();
    }

    private void exibirPergunta() {
        if (controle.temProximaQuestao()) {
            Questao questao = controle.getQuestaoAtual();
            criarPergunta(questao.getPergunta(), questao.getAlternativas());
            cardLayout.show(painelCards, "Pergunta");
        } else {
            mostrarResultado();
        }
    }

    private void mostrarResultado() {
        painelResultado.removeAll();
        painelResultado.setBackground(new Color(255, 223, 186));

        int acertos = controle.getAcertos();
        int erros = controle.getErros();
        String resultadoTexto = String.format("<html><div style='text-align: center; font-size: 24px; font-weight: bold; color: #2e8b57;'>Acertos: %d<br/>Erros: %d</div></html>", acertos, erros);

        JLabel resultadoLabel = new JLabel(resultadoTexto);
        resultadoLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        resultadoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultadoLabel.setForeground(new Color(34, 139, 34));
        painelResultado.add(Box.createRigidArea(new Dimension(0, 30)));
        painelResultado.add(resultadoLabel);

        JButton refazerButton = new JButton("Refazer o Teste");
        refazerButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        refazerButton.setBackground(new Color(34, 139, 34));
        refazerButton.setForeground(Color.WHITE);
        refazerButton.setFocusPainted(false);
        refazerButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        refazerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        refazerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle = new QuestionarioController();
                numeroPergunta = 0;
                exibirPergunta();
                cardLayout.show(painelCards, "Pergunta");
            }
        });
        
        JButton voltarMenuButton = new JButton("Voltar ao Menu");
        voltarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarMenuButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        voltarMenuButton.setBackground(Color.RED);
        voltarMenuButton.setForeground(Color.WHITE);
        voltarMenuButton.setFocusPainted(false);
        voltarMenuButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        voltarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipalGUI menu = new MenuPrincipalGUI();
                menu.setVisible(true);
                dispose();
            }
        });

        painelResultado.add(Box.createRigidArea(new Dimension(0, 20)));
        painelResultado.add(refazerButton);
        painelResultado.add(voltarMenuButton);
        
        painelResultado.revalidate();
        painelResultado.repaint();

        cardLayout.show(painelCards, "Resultado");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            QuizTecnologiaGUI ex = new QuizTecnologiaGUI();
            ex.setVisible(true);
        });
    }
}
