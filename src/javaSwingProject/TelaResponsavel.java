package javaSwingProject;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaResponsavel {
	JFrame frame;
	JTextField nomeField, cpfField, telefoneField, emailField, enderecoField, idadeField;
	JButton proximoButton;

	public TelaResponsavel() {
		frame = new JFrame("Etapa 1 de - 3 - Dados do Responsável");
		nomeField = new JTextField();
		cpfField = new JTextField();
		telefoneField = new JTextField();
		emailField = new JTextField();
		enderecoField = new JTextField();
		idadeField = new JTextField();
		proximoButton = new JButton("Avançar");
		
		proximoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idade = Integer.parseInt(idadeField.getText());
                if (idade >= 18) {
                    Responsavel responsavel = new Responsavel(
                            nomeField.getText(),
                            cpfField.getText(),
                            telefoneField.getText(),
                            emailField.getText(),
                            enderecoField.getText(),
                            idade
                    );
                    frame.dispose();
                    new TelaCrianca(responsavel);
                } else {
                    JOptionPane.showMessageDialog(frame, "O responsável deve ser maior de 18 anos.");
                }
            }
        });
		
		  JPanel panel = new JPanel(new GridLayout(0, 2));
		  panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
	        panel.add(new JLabel("Nome:"));
	        panel.add(nomeField);
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(new JLabel("CPF:"));
	        panel.add(cpfField);
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(new JLabel("Telefone:"));
	        panel.add(telefoneField);
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(new JLabel("Email:"));
	        panel.add(emailField);
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(new JLabel("Endereço:"));
	        panel.add(enderecoField);
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(new JLabel("Idade:"));
	        panel.add(idadeField);
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(new JLabel(""));
	        panel.add(proximoButton);

	        frame.add(panel);
	        frame.setSize(350, 350);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	}
}
