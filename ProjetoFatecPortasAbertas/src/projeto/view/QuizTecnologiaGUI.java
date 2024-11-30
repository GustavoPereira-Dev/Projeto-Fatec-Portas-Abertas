package projeto.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class QuizTecnologiaGUI extends JFrame {
    private int numeroPergunta = 0;
    private int pontosProgramacao = 0;
    private int pontosDesign = 0;
    private int pontosRedes = 0;
    private int pontosDados = 0;
    private int pontosSeguranca = 0;
    private JPanel painelPergunta;
    private JPanel painelResultado;
    private JButton proximaButton;
    private CardLayout cardLayout;
    private JPanel painelCards;

    public QuizTecnologiaGUI() {
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
        exibirPergunta(numeroPergunta);

        setVisible(true);
    }

    private void exibirPergunta(int numeroPergunta) {
        painelPergunta.removeAll(); 
        painelPergunta.setLayout(new BoxLayout(painelPergunta, BoxLayout.Y_AXIS));

        
        switch (numeroPergunta) {
            case 0:
                criarPergunta("1. O que você prefere fazer?", new String[]{
                        "Criar coisas no computador.",
                        "Desenhar algo bonito e útil.",
                        "Mexer com computadores e redes.",
                        "Trabalhar com números e gráficos.",
                        "Proteger sistemas e dados."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 1:
                criarPergunta("2. Qual dessas frases combina mais com você?", new String[]{
                        "Quero aprender a programar.",
                        "Amo coisas bem organizadas e com\n boa aparência.",
                        "Gosto de entender como tudo funciona por trás.",
                        "Adoro descobrir padrões e entender dados.",
                        "Quero ser quem impede hackers de invadirem."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 2:
                criarPergunta("3. Qual tecnologia te chama mais atenção?", new String[]{
                        "Aplicativos e sites.",
                        "Design e interfaces.",
                        "Redes e servidores.",
                        "Dados e gráficos.",
                        "Segurança digital."
                }, new int[]{1, 2, 3, 4, 5});
                break;
             case 3:
                criarPergunta("4. O que você gostaria de fazer no futuro?", new String[]{
                        "Criar aplicativos ou jogos.",
                        "Trabalhar com design e criatividade.",
                        "Resolver problemas técnicos de computadores e redes.",
                        "Analisar e organizar grandes volumes de dados.",
                        "Evitar que hackers invadam sistemas."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 4:
                criarPergunta("5. Qual atividade parece mais divertida?", new String[]{
                        "Programar e ver algo funcionando.",
                        "Fazer algo visual ficar incrível.",
                        "Consertar ou configurar computadores e redes.",
                        "Explorar números para entender o mundo.",
                        "Descobrir falhas e proteger sistemas"
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 5:
                criarPergunta("6. Se você tivesse que escolher, o que gostaria de estudar primeiro?", new String[]{
                        "Linguagens de programação.",
                        "Como criar sites bonitos e atraentes.",
                        "Como redes e internet realmente funcionam.",
                        "Como usar gráficos e planilhas para analisar dados.",
                        "Como proteger senhas e dados."
                }, new int[]{1, 2, 3, 4, 5});
                break;
             case 6:
                criarPergunta("7. Com qual frase você se identifica mais?", new String[]{
                        "Gosto de resolver problemas lógicos e criar coisas úteis.",
                        "Quero aprender a desenhar coisas que todos gostem de usar.",
                        "Gosto de entender e consertar sistemas e equipamentos.",
                        "Adoro trabalhar com números e encontrar padrões.",
                        "Me interessa saber como evitar invasões de sistemas."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 7:
                criarPergunta("8. Que tipo de projeto você gostaria de trabalhar?", new String[]{
                        "Um app ou site que ajude pessoas.",
                        "Um design incrível para um site ou aplicativo.",
                        "Um sistema de servidores funcionando perfeitamente.",
                        "Um relatório mostrando dados importantes para uma empresa..",
                        "Um sistema seguro que ninguém consiga invadir."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 8:
                criarPergunta("9. O que você acha mais interessante na tecnologia?", new String[]{
                        "Criar algo novo com códigos.",
                        "Tornar as coisas mais bonitas e fáceis de usar.",
                        "Entender como tudo está conectado.",
                        "Descobrir o que os dados podem contar.",
                        "Impedir problemas e ataques virtuais."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            case 9:
                criarPergunta("10. Se você tivesse um computador na sua frente agora, o que faria?", new String[]{
                        "Começaria a programar.",
                        "Criaria um layout bonito para um site.",
                        "Testaria conexões e redes.",
                        "Analisaria dados ou criaria gráficos..",
                        "Procuraria por falhas de segurança para corrigir."
                }, new int[]{1, 2, 3, 4, 5});
                break;
            
        }
    }

    private void criarPergunta(String pergunta, String[] opcoes, int[] pontos) {
    painelPergunta.removeAll();
    painelPergunta.setLayout(new BoxLayout(painelPergunta, BoxLayout.Y_AXIS));

    
    JLabel perguntaLabel = new JLabel(pergunta); 
    perguntaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    perguntaLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
    painelPergunta.add(Box.createRigidArea(new Dimension(0, 20))); 
    painelPergunta.add(perguntaLabel);

   
    JPanel opcoesPanel = new JPanel(new GridLayout(0, 1, 10, 10)); 
    opcoesPanel.setBackground(new Color(240, 248, 255)); 

    ButtonGroup grupo = new ButtonGroup();
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
                atualizarPontos(pontos[indice]);
                proximaButton.setEnabled(true); 
                
                for (Component c : opcoesPanel.getComponents()) {
                    c.setBackground(Color.WHITE);
                }
                opcao.setBackground(new Color(144, 238, 144)); 
            }
        });

        grupo.add(opcao);
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
            numeroPergunta++;
            if (numeroPergunta >= 10) { 
                mostrarResultado();
            } else {
                exibirPergunta(numeroPergunta);
            }
        }
    });

    painelPergunta.add(Box.createRigidArea(new Dimension(0, 20)));
    painelPergunta.add(proximaButton);

    painelPergunta.revalidate();
    painelPergunta.repaint();
}

    private void atualizarPontos(int pontos) {
        switch (pontos) {
            case 1: pontosProgramacao++; break;
            case 2: pontosDesign++; break;
            case 3: pontosRedes++; break;
            case 4: pontosDados++; break;
            case 5: pontosSeguranca++; break;
        }
    }

    private void mostrarResultado() {
    painelResultado.removeAll();

 
    painelResultado.setBackground(new Color(255, 223, 186)); 

    
    String resultadoTexto = "<html><div style='text-align: center; font-size: 24px; font-weight: bold; color: #2e8b57;'>" +
            (pontosProgramacao > pontosDesign && pontosProgramacao > pontosRedes && pontosProgramacao > pontosDados && pontosProgramacao > pontosSeguranca ? 
            "Você tem mais afinidade com Programação!" :
            pontosDesign > pontosProgramacao && pontosDesign > pontosRedes && pontosDesign > pontosDados && pontosDesign > pontosSeguranca ?
            "Você tem mais afinidade com Design!" :
            pontosRedes > pontosProgramacao && pontosRedes > pontosDesign && pontosRedes > pontosDados && pontosRedes > pontosSeguranca ?
            "Você tem mais afinidade com Redes!" :
            pontosDados > pontosProgramacao && pontosDados > pontosDesign && pontosDados > pontosRedes && pontosDados > pontosSeguranca ?
            "Você tem mais afinidade com Análise de Dados!" :
            "Você tem mais afinidade com Segurança Digital!") +
            "</div></html>";

   
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
            numeroPergunta = 0;
            pontosProgramacao = 0;
            pontosDesign = 0;
            pontosRedes = 0;
            pontosDados = 0;
            pontosSeguranca = 0;
            exibirPergunta(numeroPergunta);
            cardLayout.show(painelCards, "Pergunta");
        }
    });

    painelResultado.add(Box.createRigidArea(new Dimension(0, 20)));
    painelResultado.add(refazerButton);

    painelResultado.revalidate();
    painelResultado.repaint();
    
    cardLayout.show(painelCards, "Resultado");
    
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

    painelResultado.add(Box.createRigidArea(new Dimension(0, 10)));
    painelResultado.add(voltarMenuButton);
}


    }

