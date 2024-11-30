package projeto.view;

import projeto.controller.JogoDaForca;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class JogoDaForcaGUI extends JFrame {
    private JogoDaForca jogo;
    private JLabel palavraLabel;
    private JLabel tentativasLabel;
    private JLabel letrasUsadasLabel;
    private JTextField inputLetra;

    public JogoDaForcaGUI() {
        jogo = new JogoDaForca();
        initUI();
    }

    private void initUI() {
        setTitle("Jogo da Forca");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#e6ffff"));

        JLabel titleLabel = new JLabel("Jogo da Forca FATEC Portas Abertas 2024");
        titleLabel.setBounds(80, 11, 240, 14);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleLabel);

        palavraLabel = new JLabel();
        palavraLabel.setBounds(112, 50, 145, 22);
        palavraLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(palavraLabel);

        tentativasLabel = new JLabel();
        tentativasLabel.setBounds(112, 83, 145, 14);
        tentativasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(tentativasLabel);

        letrasUsadasLabel = new JLabel();
        letrasUsadasLabel.setBounds(112, 119, 159, 14);
        letrasUsadasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(letrasUsadasLabel);

        inputLetra = new JTextField(1);
        inputLetra.setBounds(112, 155, 152, 20);
        inputLetra.setMaximumSize(new Dimension(50, 30));
        inputLetra.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPalpite();
            }
        });
        panel.add(inputLetra);

        JButton novoJogoButton = new JButton("Novo Jogo");
        novoJogoButton.setBounds(112, 216, 152, 34);
        novoJogoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarJogo();
            }
        });
        novoJogoButton.setBackground(Color.decode("#80ffdf"));
        
        
        panel.add(novoJogoButton);

        
        JButton voltarMenuButton = new JButton("Voltar ao Menu");
        voltarMenuButton.setBounds(112, 266, 152, 34);
        voltarMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        voltarMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuPrincipalGUI menu = new MenuPrincipalGUI();
                menu.setVisible(true);
                dispose();
            }
        });
        voltarMenuButton.setBackground(Color.decode("#b3e0ff"));
        panel.add(voltarMenuButton);
        iniciarJogo();
    }

    private void iniciarJogo() {
        jogo.iniciarJogo();
        atualizarTela();
    }

    private void verificarPalpite() {
        String palpite = inputLetra.getText().toUpperCase();
        if (!palpite.isEmpty() && palpite.length() == 1 && Character.isLetter(palpite.charAt(0))) {
            char letra = palpite.charAt(0);
            jogo.verificarPalpite(letra);
            inputLetra.setText("");
            atualizarTela();

            if (jogo.isAcertou()) {
                JOptionPane.showMessageDialog(this, "Parabéns! Você adivinhou a palavra: " + jogo.getPalavra());
                iniciarJogo();
            } else if (jogo.getTentativas() == 0) {
                JOptionPane.showMessageDialog(this, "Que pena! Você não conseguiu adivinhar a palavra: " + jogo.getPalavra());
                iniciarJogo();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, insira uma única letra válida.", "Erro", JOptionPane.ERROR_MESSAGE);
            inputLetra.setText("");
        }
    }

    private void atualizarTela() {
        palavraLabel.setText("Palavra: " + jogo.getPalavraOculta());
        tentativasLabel.setText("Tentativas restantes: " + jogo.getTentativas());
        letrasUsadasLabel.setText("Letras usadas: " + jogo.getLetrasUsadas());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JogoDaForcaGUI ex = new JogoDaForcaGUI();
            ex.setVisible(true);
        });
    }
}
