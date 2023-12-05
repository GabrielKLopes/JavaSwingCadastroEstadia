package javaSwingProject;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEstadia {
    JFrame frame;
    JTextField tempoUtilizadoField, nomeResponsavelField, nomeCriancaField;
    JButton confirmarButton;

    Responsavel responsavel;
    Crianca crianca;

    public TelaEstadia(Responsavel responsavel, Crianca crianca) {
        this.responsavel = responsavel;
        this.crianca = crianca;
        frame = new JFrame("Etapa 3 de - 3 - Dados da Estadia ");
        tempoUtilizadoField = new JTextField();
        confirmarButton = new JButton("Calcular e Mostrar Resumo");

        nomeResponsavelField = new JTextField(responsavel.nome);
        nomeResponsavelField.setEditable(false);
        nomeResponsavelField.setBackground(Color.WHITE);  // Define a cor de fundo

        nomeCriancaField = new JTextField(crianca.nome);
        nomeCriancaField.setEditable(false);
        nomeCriancaField.setBackground(Color.WHITE);  // Define a cor de fundo

        tempoUtilizadoField.setColumns(5);  // Reduz o tamanho do campo de entrada

        confirmarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tempoUtilizado = Integer.parseInt(tempoUtilizadoField.getText());
                Estadia estadia = new Estadia(
                        responsavel,
                        crianca,
                        tempoUtilizado
                );
                double custo = estadia.calcularCusto();
                JOptionPane.showMessageDialog(frame,
                        "Dados da Estadia:\n" +
                                "Nome Responsável: " + estadia.responsavel.nome + "\n" +
                                "CPF Responsável: " + estadia.responsavel.cpf + "\n" +
                                "Telefone Responsável: " + estadia.responsavel.telefone + "\n" +
                                "Email Responsável: " + estadia.responsavel.email + "\n" +
                                "Endereço Responsável: " + estadia.responsavel.endereco + "\n" +
                                "Idade Responsável: " + estadia.responsavel.idade + "\n" +
                                "Nome Criança: " + estadia.crianca.nome + "\n" +
                                "Idade Criança: " + estadia.crianca.idade + "\n" +
                                "Sexo Criança: " + estadia.crianca.sexo + "\n" +
                                "Tempo no brinquedo: " + estadia.tempoUtilizado + " minutos\n" +
                                "Valor A pagar: R$" + custo);
            }
        });

        JPanel panel = new JPanel(new GridLayout(0, 1)); // Organiza os componentes verticalmente
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Adiciona os componentes ao painel principal
        panel.add(new JLabel("Responsável:"));
        panel.add(nomeResponsavelField);
        panel.add(new JLabel("Criança:"));
        panel.add(nomeCriancaField);
        panel.add(new JLabel("Tempo Utilizado (minutos):"));
        panel.add(tempoUtilizadoField);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(confirmarButton);

        frame.add(panel);
        frame.setSize(400, 250); // Ajusta o tamanho do frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
