package projeto.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MenuPrincipalGUI extends JFrame {

    public MenuPrincipalGUI() {
    	
        initUI();
    }

    private void initUI() {
        setTitle("Menu Principal");
        setSize(443, 317);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.decode("#4d94ff"));
        JButton forcaButton = new JButton("Jogo da Forca");
        forcaButton.setBounds(24, 139, 192, 40);
        forcaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JogoDaForcaGUI forcaGUI = new JogoDaForcaGUI();
                forcaGUI.setVisible(true);
                dispose();
            }
        });
        forcaButton.setBackground(Color.decode("#00ffcc"));

        JButton adivinhacaoButton = new JButton("Jogo de Adivinhação");
        adivinhacaoButton.setBounds(119, 209, 192, 40);
        adivinhacaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AdivinhacaoGUI adivinhacaoGUI = new AdivinhacaoGUI();
                adivinhacaoGUI.setVisible(true);
                dispose();
            }
        });
        adivinhacaoButton.setBackground(Color.decode("#ffff99"));

        JButton velhaButton = new JButton("Jogo da Velha");
        velhaButton.setBounds(226, 139, 192, 40);
        velhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JogoDaVelhaGUI velhaGUI = new JogoDaVelhaGUI();
                velhaGUI.setVisible(true);
                dispose();
            }
        });
        velhaButton.setBackground(Color.decode("#66ff66"));
        
        JButton testeButton = new JButton("Quiz");
        testeButton.setBounds(24, 74, 192, 40);
        testeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	QuizTecnologiaGUI testeButtonGUI = new QuizTecnologiaGUI();
            	testeButtonGUI.setVisible(true);
                dispose();
            }
        });
        testeButton.setBackground(Color.decode("#33ccff"));
        
        JButton questionarioButton = new JButton("Questionario");
        questionarioButton.setBounds(226, 74, 192, 40);
        questionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	QuestionarioGUI questionarioButtonGUI = new QuestionarioGUI();
            	questionarioButtonGUI.setVisible(true);
                dispose();
            }
        });
        questionarioButton.setBackground(Color.decode("#ccccff"));
        getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Selecione um jogo", SwingConstants.CENTER);
        titleLabel.setBounds(119, 11, 192, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        

        getContentPane().add(titleLabel);
        getContentPane().add(forcaButton);
        getContentPane().add(adivinhacaoButton);
        getContentPane().add(velhaButton);
        getContentPane().add(testeButton);
        getContentPane().add(questionarioButton);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MenuPrincipalGUI menu = new MenuPrincipalGUI();
            menu.setVisible(true);
        });
    }
}
