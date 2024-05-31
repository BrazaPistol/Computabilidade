import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame implements ActionListener {
    private JLabel labelNome, labelEndereco, labelTelefone, labelCpf, labelTipoSanguineo, labelCurso, labelContatoEmergencia, labelTelefoneEmergencia, labelFatorRH, labelMensagem, labelResultado, labelID;
    private JTextField textNome, textEndereco, textTelefone, textCPF, textContatoEmergencia, textTelefoneEmergencia, textID;
    private JComboBox<String> comboTipoSanguineo, comboCurso;
    private JComboBox<Character> comboFatorRH;
    private JButton botaoInserir, botaoLimpar, botaoPesquisar, botaoAlterar, botaoRemover;
    private JTextArea areaResultado;
    private ConexaoBancoDeDados objBancoDeDados;

    public InterfaceGrafica() {
        setTitle("SISTEMA DE MATRICULAS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
        labelNome = new JLabel("Nome Completo:");
        labelNome.setBounds(20, 20, 100, 20);
        add(labelNome);

        textNome = new JTextField();
        textNome.setBounds(150, 20, 200, 20);
        add(textNome);

        labelEndereco = new JLabel("Endereço:");
        labelEndereco.setBounds(20, 50, 100, 20);
        add(labelEndereco);

        textEndereco = new JTextField();
        textEndereco.setBounds(150, 50, 200, 20);
        add(textEndereco);

        labelTelefone = new JLabel("Telefone:");
        labelTelefone.setBounds(20, 80, 100, 20);
        add(labelTelefone);

        textTelefone = new JFormattedTextField(createFormatter("(##) #####-####"));
        textTelefone.setBounds(150, 80, 200, 20);
        add(textTelefone);

        labelCpf = new JLabel("CPF:");
        labelCpf.setBounds(20, 110, 100, 20);
        add(labelCpf);

        textCPF = new JFormattedTextField(createFormatter("###.###.###-##"));
        textCPF.setBounds(150, 110, 200, 20);
        add(textCPF);

        labelTipoSanguineo = new JLabel("Tipo de Sanguíneo:");
        labelTipoSanguineo.setBounds(20, 140, 120, 20);
        add(labelTipoSanguineo);

        comboTipoSanguineo = new JComboBox<>(new String[]{"A", "B", "AB", "O"});
        comboTipoSanguineo.setBounds(150, 140, 100, 20);
        add(comboTipoSanguineo);

        labelFatorRH = new JLabel("Fator RH:");
        labelFatorRH.setBounds(20, 170, 100, 20);
        add(labelFatorRH);

        comboFatorRH = new JComboBox<>(new Character[]{'+', '-'});
        comboFatorRH.setBounds(150, 170, 50, 20);
        add(comboFatorRH);

        labelCurso = new JLabel("Curso:");
        labelCurso.setBounds(20, 200, 100, 20);
        add(labelCurso);

        comboCurso = new JComboBox<>(new String[]{"Engenharia Elétrica", "Ciência da Computação", "Sistema de Informação", "Fisioterapia", "Psicologia", "Nutrição", "Farmácia", "Erfermagem", "Arquitetura", "Veterinária"});
        comboCurso.setBounds(150, 200, 200, 20);
        add(comboCurso);

        labelContatoEmergencia = new JLabel("Contato de Emergência:");
        labelContatoEmergencia.setBounds(20, 230, 150, 20);
        add(labelContatoEmergencia);

        textContatoEmergencia = new JTextField();
        textContatoEmergencia.setBounds(165, 230, 200, 20);
        add(textContatoEmergencia);

        labelTelefoneEmergencia = new JLabel("Telefone Emergência:");
        labelTelefoneEmergencia.setBounds(20, 260, 150, 20);
        add(labelTelefoneEmergencia);

        textTelefoneEmergencia = new JFormattedTextField(createFormatter("(##) #####-####"));
        textTelefoneEmergencia.setBounds(165, 260, 200, 20);
        add(textTelefoneEmergencia);


    
        botaoInserir = new JButton("Inserir");
        botaoInserir.setBounds(20, 300, 100, 30);
        botaoInserir.addActionListener(this);
        add(botaoInserir);

        botaoLimpar = new JButton("Limpar");
        botaoLimpar.setBounds(130, 300, 100, 30);
        botaoLimpar.addActionListener(this);
        add(botaoLimpar);

        botaoPesquisar = new JButton("Pesquisar");
        botaoPesquisar.setBounds(240, 300, 100, 30);
        botaoPesquisar.addActionListener(this);
        add(botaoPesquisar);

        botaoAlterar = new JButton("Alterar");
        botaoAlterar.setBounds(350, 300, 100, 30);
        botaoAlterar.addActionListener(this);
        add(botaoAlterar);

        botaoRemover = new JButton("Remover");
        botaoRemover.setBounds(460, 300, 100, 30);
        botaoRemover.addActionListener(this);
        add(botaoRemover);

        labelResultado = new JLabel("RESULTADOS DE PESQUISA NO BANCO DE DADOS");
        labelResultado.setBounds(460, 20, 600, 20);
        add(labelResultado);
        
        areaResultado = new JTextArea();
        areaResultado.setBounds(20, 340, 800, 400);
        areaResultado.setEditable(false);
        add(areaResultado);
        
        labelID = new JLabel("ID");
        labelID.setBounds(280, 330, 100, 25);
        add(labelID);
        
        textID = new JTextField();
        textID.setBounds(300, 330, 20, 25);
        add(textID);

        
        labelMensagem = new JLabel();
        labelMensagem.setBounds(20, 600, 540, 20);
        add(labelMensagem);

        
        setSize(500, 500);
        setLocationRelativeTo(null); 
        setVisible(true);

        objBancoDeDados = new ConexaoBancoDeDados();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoInserir) {
            inserirRegistro();
        } else if (e.getSource() == botaoLimpar) {
            limparCampos();
        } else if (e.getSource() == botaoPesquisar) {
            pesquisarRegistros();
        } else if (e.getSource() == botaoAlterar) {
            alterarRegistro();
        } else if (e.getSource() == botaoRemover) {
            removerRegistro();
        }
    }

    private void inserirRegistro() {
        try {
            Aluno aluno = criarAluno();
            String mensagem = objBancoDeDados.inserirDados(aluno);
            labelMensagem.setText(mensagem);
            limparCampos();
        } catch (SQLException ex) {
            labelMensagem.setText("Erro de inseção!");
            ex.printStackTrace();
        }
    }

    private void pesquisarRegistros() {
        try {
            ArrayList<String> resultados = objBancoDeDados.relatorio();
            exibirResultado(resultados);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void alterarRegistro() {
        int id = obterID();
        if (id != -1) {
            try {
                Aluno aluno = criarAluno();
                String mensagem = objBancoDeDados.alterarDados(aluno, id);
                labelMensagem.setText(mensagem);
            } catch (SQLException ex) {
                labelMensagem.setText("Erro ao alterar dados no banco!");
                ex.printStackTrace();
            }
        } else {
            labelMensagem.setText("Selecione um registro para alterar!");
        }
    }

    private void removerRegistro() {
        int id = obterID();
        if (id != -1) {
            try {
                String mensagem = objBancoDeDados.removerDados(id);
                labelMensagem.setText(mensagem);
            } catch (SQLException ex) {
                labelMensagem.setText("Erro ao remover dados!");
                ex.printStackTrace();
            }
        } else {
            labelMensagem.setText("Selecione um registro para remover!");
        }
    }

    private Aluno criarAluno() {
        return new Aluno(
                textNome.getText(),
                textEndereco.getText(),
                textTelefone.getText(),
                textCPF.getText(),
                comboTipoSanguineo.getSelectedItem().toString(),
                comboFatorRH.getSelectedItem().toString(),
                comboCurso.getSelectedItem().toString(),
                textContatoEmergencia.getText(),
                textTelefoneEmergencia.getText()
        );
    }

    private void exibirResultado(ArrayList<String> resultados) {
        areaResultado.setText(""); 
        for (String resultado : resultados) {
            resultado = resultado.replaceAll(", ", "\n");
            areaResultado.append(resultado + "\n\n"); 
        }
    }

    private void limparCampos() {
        textNome.setText("");
        textEndereco.setText("");
        textTelefone.setText("");
        textCPF.setText("");
        comboTipoSanguineo.setSelectedIndex(0);
        comboFatorRH.setSelectedIndex(0);
        comboCurso.setSelectedIndex(0);
        textContatoEmergencia.setText("");
        textTelefoneEmergencia.setText("");
    }

    private int obterID() {
        String idString = JOptionPane.showInputDialog("Digite o número de ID:");
        if (idString != null && !idString.isEmpty()) {
            try {
                return Integer.parseInt(idString);
            } catch (NumberFormatException e) {
                labelMensagem.setText("ID inválido! Por favor, insira um ID válido.");
                return -1;
            }
        } else {
            labelMensagem.setText("ID não inserido! Por favor, insira o ID registrado.");
            return -1;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceGrafica());
    }
    {
}
  private Format createFormatter(String s) {
    MaskFormatter formatter = null;
    try {
        formatter = new MaskFormatter(s);
    } catch (ParseException e) {
        e.printStackTrace();
    }
	return null;
  } 
}