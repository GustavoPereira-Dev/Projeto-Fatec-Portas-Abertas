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

        JButton forcaButton = new JButton("Jogo da Forca");
        forcaButton.setBounds(24, 125, 192, 40);
        forcaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JogoDaForcaGUI forcaGUI = new JogoDaForcaGUI();
                forcaGUI.setVisible(true);
                dispose();
            }
        });

        JButton adivinhacaoButton = new JButton("Jogo de Adivinhação");
        adivinhacaoButton.setBounds(113, 215, 192, 40);
        adivinhacaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	AdivinhacaoGUI adivinhacaoGUI = new AdivinhacaoGUI();
                adivinhacaoGUI.setVisible(true);
                dispose();
            }
        });

        JButton velhaButton = new JButton("Jogo da Velha");
        velhaButton.setBounds(226, 125, 192, 40);
        velhaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JogoDaVelhaGUI velhaGUI = new JogoDaVelhaGUI();
                velhaGUI.setVisible(true);
                dispose();
            }
        });
        
        JButton testeButton = new JButton("Quiz");
        testeButton.setBounds(24, 51, 192, 40);
        testeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	QuizTecnologia testeButtonGUI = new QuizTecnologia();
            	testeButtonGUI.setVisible(true);
                dispose();
            }
        });
        
        JButton questionarioButton = new JButton("Questionario");
        questionarioButton.setBounds(226, 51, 192, 40);
        questionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	QuestionarioGUI questionarioButtonGUI = new QuestionarioGUI();
            	questionarioButtonGUI.setVisible(true);
                dispose();
            }
        });
        getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Selecione um jogo", SwingConstants.CENTER);
        titleLabel.setBounds(0, 0, 192, 40);
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
