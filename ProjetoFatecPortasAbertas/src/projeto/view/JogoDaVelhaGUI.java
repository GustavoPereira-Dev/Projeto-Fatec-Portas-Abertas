package projeto.view;

import projeto.controller.JogoDaVelhaController;
import projeto.model.estrutura.JogoDaVelha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JogoDaVelhaGUI extends JFrame {
    private JogoDaVelhaController controle;
    private JButton[][] botoes;
    private JLabel statusLabel;

    public JogoDaVelhaGUI() {
        controle = new JogoDaVelhaController(new JogoDaVelha());
        initUI();
    }

    private void initUI() {
        setTitle("Jogo da Velha");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        

        botoes = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j] = new JButton(" ");
                botoes[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                botoes[i][j].setBackground(Color.decode("#ddff99"));
                final int linha = i;
                final int coluna = j;
                botoes[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (controle.fazerJogada(linha, coluna)) {
                            atualizarTabuleiro();
                            if (controle.verificarVencedor()) {
                                statusLabel.setText("Jogador " + controle.getJogadorAtual() + " venceu!");
                                bloquearBotoes();
                            } else if (controle.verificarEmpate()) {
                                statusLabel.setText("Empate!");
                            } else {
                                controle.trocarJogador();
                                statusLabel.setText("Vez do jogador: " + controle.getJogadorAtual());
                            }
                        }
                    }
                });
                panel.add(botoes[i][j]);
            }
        }

        statusLabel = new JLabel("Vez do jogador: " + controle.getJogadorAtual());
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton reiniciarButton = new JButton("Reiniciar Jogo");
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.reiniciarTabuleiro();
                atualizarTabuleiro();
                desbloquearBotoes();
                statusLabel.setText("Vez do jogador: " + controle.getJogadorAtual());
            }
        });
        reiniciarButton.setBackground(Color.decode("#fff5cc"));

        JButton voltarMenuButton = new JButton("Voltar ao Menu");
        voltarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipalGUI menu = new MenuPrincipalGUI();
                menu.setVisible(true);
                dispose();
            }
        });
        voltarMenuButton.setBackground(Color.decode("#ffe6cc"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 2));
        bottomPanel.add(reiniciarButton);
        bottomPanel.add(voltarMenuButton);

        add(statusLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private void atualizarTabuleiro() {
        char[][] tabuleiro = controle.getTabuleiro();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setText(String.valueOf(tabuleiro[i][j]));
            }
        }
    }

    private void bloquearBotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setEnabled(false);
            }
        }
    }

    private void desbloquearBotoes() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setEnabled(true);
                botoes[i][j].setText(" ");
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JogoDaVelhaGUI ex = new JogoDaVelhaGUI();
            ex.setVisible(true);
        });
    }
}
