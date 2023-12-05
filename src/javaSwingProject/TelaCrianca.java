package javaSwingProject;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCrianca {
    JFrame frame;
    JTextField nomeCriancaField, idadeCriancaField, sexoCriancaField;
    JButton proximoButton;
    Responsavel responsavel;

    public TelaCrianca(Responsavel responsavel) {
        this.responsavel = responsavel;
        frame = new JFrame("Etapa 2 de - 3 - Dados da Criança");
        nomeCriancaField = new JTextField();
        idadeCriancaField = new JTextField();
        sexoCriancaField = new JTextField();
        proximoButton = new JButton("Avançar");

        proximoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idadeCrianca = Integer.parseInt(idadeCriancaField.getText());
                if (idadeCrianca < 10) {
                    Crianca crianca = new Crianca(
                            responsavel,
                            nomeCriancaField.getText(),
                            sexoCriancaField.getText(),
                            idadeCrianca
                    );
                    frame.dispose();
                    new TelaEstadia(responsavel, crianca);
                } else {
                    JOptionPane.showMessageDialog(frame, "A criança deve ter menos de 10 anos.");
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(0, 2));
		  panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        panel.add(new JLabel("Nome da Criança:"));
        panel.add(nomeCriancaField);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Idade da Criança:"));
        panel.add(idadeCriancaField);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel("Sexo da Criança:"));
        panel.add(sexoCriancaField);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(proximoButton);

        frame.add(panel);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
