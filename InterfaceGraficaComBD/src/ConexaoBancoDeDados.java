
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexaoBancoDeDados {

    private Connection conexao;
    private final String URL_BancoDeDados = "jdbc:mysql://localhost:3306/nomebd";
    private final String usuario = "root";
    private final String senha = "admin";

    public ConexaoBancoDeDados() {
        iniciarConexao();
    }

    private void iniciarConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL_BancoDeDados, usuario, senha);
            System.out.println("Conexão feita com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao acessar o banco de dados!");
        }
    }

    public String inserirDados(Aluno Aluno) throws SQLException {
        if (conexao != null) {
            PreparedStatement psInsert = conexao.prepareStatement("INSERT INTO Aluno" +
                    "(nome_completo, endereco, telefone, cpf, tipo_sanguineo, fator_rh, curso, contato_emergencia, telefone_emergencia)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            psInsert.setString(1, Aluno.getNome());
            psInsert.setString(2, Aluno.getEndereco());
            psInsert.setString(3, Aluno.getTelefone());
            psInsert.setString(4, Aluno.getCpf());
            psInsert.setString(5, Aluno.getTipoSanguineo());
            psInsert.setString(6, Aluno.getFatorRh());
            psInsert.setString(7, Aluno.getCurso());
            psInsert.setString(8, Aluno.getContatoEmergencia());
            psInsert.setString(9, Aluno.getTelefoneEmergencia());
            psInsert.executeUpdate();
            return "Aluno cadastrado com sucesso!";
        } else {
            return "Erro! Inserção mal sucessida!";
        }
    }

    public String alterarDados(Aluno aluno, int id) throws SQLException {
        if (conexao != null) {
            PreparedStatement psUpdate = conexao.prepareStatement("UPDATE aluno SET " +
                    "nome_completo=?, endereco=?, telefone=?, cpf=?, tipo_sanguineo=?, fator_rh=?, curso=?, contato_emergencia=?, telefone_emergencia=? WHERE id=?");
            psUpdate.setString(1, aluno.getNome());
            psUpdate.setString(2, aluno.getEndereco());
            psUpdate.setString(3, aluno.getTelefone());
            psUpdate.setString(4, aluno.getCpf());
            psUpdate.setString(5, aluno.getTipoSanguineo());
            psUpdate.setString(6, aluno.getFatorRh());
            psUpdate.setString(7, aluno.getCurso());
            psUpdate.setString(8, aluno.getContatoEmergencia());
            psUpdate.setString(9, aluno.getTelefoneEmergencia());
            psUpdate.setInt(10, id);
            psUpdate.executeUpdate();
            return "Alteração de dados feita com sucesso!";
        } else {
            return "Erro de alteração!";
        }
    }

    public String removerDados(int id) throws SQLException {
        if (conexao != null) {
            PreparedStatement psDelete = conexao.prepareStatement("DELETE FROM aluno WHERE id=?");
            psDelete.setInt(1, id);
            psDelete.executeUpdate();
            return "Remoção bem sucessida!";
        } else {
            return "Erro na remoção!";
        }
    }

    public ArrayList<String> relatorio() throws SQLException {
        ArrayList<String> relatorioBancoDeDados = new ArrayList<>();
        if (conexao != null) {
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Aluno");
            while (rs.next()) {
                String id = rs.getString("id");
                String nome = rs.getString("nome_completo");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String cpf = rs.getString("cpf");
                String tipoSanguineo = rs.getString("tipo_sanguineo");
                String fatorRh = rs.getString("fator_rh");
                String curso = rs.getString("curso");
                String contatoEmergencia = rs.getString("contato_emergencia");
                String telefoneEmergencia = rs.getString("telefone_emergencia");
                String result = String.format("ID: %s, Nome: %s, Endereço: %s, Telefone: %s, CPF: %s, Tipo Sanguíneo: %s, Fator RH: %s, Curso: %s, Contato de Emergência: %s, Telefone de Emergência: %s",
                        id, nome, endereco, telefone, cpf, tipoSanguineo, fatorRh, curso, contatoEmergencia, telefoneEmergencia);
                relatorioBancoDeDados.add(result);
            }
        }
        return relatorioBancoDeDados;
    }
}