package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Aluno;

public class AlunoDAO {
    private String nome;
    private String cpf;
    private Date data_nascimento;
    private String telefone;
    private String email;

    public AlunoDAO(String nome, String cpf, Date data_nascimento, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.email = email;
    }

    public AlunoDAO() {
        // Construtor vazio para uso do DAO
    }

    public void cadastrar(Connection conn, Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, cpf, data_nascimento, telefone, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.executeUpdate();
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    
    public List<Aluno> listar(Connection conn) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setCpf(rs.getString("cpf"));
                // Conversão de java.sql.Date para java.util.Date
                java.sql.Date dataSql = rs.getDate("data_nascimento");
                if (dataSql != null) {
                    aluno.setDataNascimento(new java.util.Date(dataSql.getTime()));
                }
                aluno.setTelefone(rs.getString("telefone"));
                aluno.setEmail(rs.getString("email"));
                alunos.add(aluno);
            }
        }
        return alunos;
    }

    public void atualizarAluno(Connection conn, Aluno aluno) throws SQLException{
        String sql = "UPDATE alunos SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, email = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setDate(3, new java.sql.Date(aluno.getDataNascimento().getTime()));
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getEmail());
            stmt.setInt(6, aluno.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirAluno(Connection conn, Aluno aluno) throws SQLException{
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, aluno.getId());
            stmt.executeUpdate();
        }
    }
    
    public Aluno buscarPorId(Connection conn, int id) throws SQLException{
            String sql = "SELECT * FROM alunos WHERE id = ?";
            try(PreparedStatement stmt = conn.prepareStatement(sql)){
                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        Aluno aluno = new Aluno();
                        aluno.setId(rs.getInt("Id -> "));
                        aluno.setNome(rs.getString("Nome -> "));
                        aluno.setCpf(rs.getString("CPF -> "));
                        java.sql.Date dataSql = rs.getDate("Data de nascimento -> ");
                        if (dataSql != null){
                            aluno.setDataNascimento(new java.util.Date(dataSql.getTime()));
                        }
                        aluno.setTelefone(rs.getString("Telefone -> "));
                        aluno.setEmail(rs.getString("Email -> "));
                        return aluno;
                    }
                }
            }
            return null; // Essa parte é para caso não seja encontrado o aluno :P
            
    }

    public List<Aluno> buscarPorNome(Connection conn, String nome) throws SQLException {
    List<Aluno> alunos = new ArrayList<>();
    String sql = "SELECT * FROM alunos WHERE nome LIKE ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Aluno aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                    java.sql.Date dataSql = rs.getDate("data_nascimento");
                    if (dataSql != null) {
                        aluno.setDataNascimento(new java.util.Date(dataSql.getTime()));
                    }
                    aluno.setTelefone(rs.getString("telefone"));
                    aluno.setEmail(rs.getString("email"));
                    alunos.add(aluno);
                }
            }
        }
        return alunos;
    }
}
