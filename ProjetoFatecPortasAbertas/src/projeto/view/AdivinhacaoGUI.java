package projeto.view;

import javax.swing.*;

import projeto.controller.Adivinhacao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AdivinhacaoGUI extends JFrame {
    private Adivinhacao jogo;
    private JTextField inputChute;
    private JLabel labelDica;
    private JLabel labelTentativas;

    public AdivinhacaoGUI() {
        jogo = new Adivinhacao();
        initUI();
    }

    private void initUI() {
        setTitle("Jogo de Adivinhação");
        setSize(449, 359);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#eeffcc"));
        JLabel titleLabel = new JLabel("Adivinhe o número de 0 a 100");
        titleLabel.setBounds(129, 26, 189, 14);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        inputChute = new JTextField();
        inputChute.setBounds(118, 51, 200, 30);
        inputChute.setMaximumSize(new Dimension(200, 30));
        inputChute.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel.add(inputChute);

        JButton botaoChutar = new JButton("Chutar");
        botaoChutar.setBounds(158, 173, 104, 23);
        botaoChutar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoChutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarChute();
            }
        });
        
        botaoChutar.setBackground(Color.decode("#e6ffff"));
        
        panel.add(botaoChutar);

        labelDica = new JLabel("Dica:");
        labelDica.setBounds(158, 92, 160, 14);
        labelDica.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelDica);

        labelTentativas = new JLabel("Tentativas: 0");
        labelTentativas.setBounds(158, 133, 104, 14);
        labelTentativas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTentativas);

        JButton botaoReiniciar = new JButton("Reiniciar Jogo");
        botaoReiniciar.setBounds(128, 226, 174, 30);
        botaoReiniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciarJogo();
            }
        });
        botaoReiniciar.setBackground(Color.decode("#ccffb3"));
        panel.add(botaoReiniciar);
        
        JButton voltarMenuButton = new JButton("Voltar ao Menu");
        voltarMenuButton.setBounds(128, 279, 174, 30);
        voltarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipalGUI menu = new MenuPrincipalGUI();
                menu.setVisible(true);
                dispose();
            }
        });
        voltarMenuButton.setBackground(Color.decode("#ccffcc"));
        
        
        panel.add(voltarMenuButton);
    }

    private void verificarChute() {
        try {
            int chute = Integer.parseInt(inputChute.getText());
            if (jogo.verificarChute(chute)) {
                JOptionPane.showMessageDialog(this, "Parabéns! Você acertou o número: " + jogo.getNumero());
                reiniciarJogo();
            } else {
                labelDica.setText(jogo.obterDica(chute));
                labelTentativas.setText("Tentativas: " + jogo.getTentativas());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
        }
        inputChute.setText("");
    }

    private void reiniciarJogo() {
        jogo.reiniciarJogo();
        labelDica.setText("Dica:");
        labelTentativas.setText("Tentativas: 0");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AdivinhacaoGUI ex = new AdivinhacaoGUI();
            ex.setVisible(true);
        });
    }
}
