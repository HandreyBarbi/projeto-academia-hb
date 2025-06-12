package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Treino;

public class TreinoDAO {
    private final Connection connection;

    public TreinoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Treino treino) throws SQLException {
        String sql = "INSERT INTO treino (aluno_id, tipo_treino, descricao, duracao_minutos, data_inicio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, treino.getIdAluno());
            stmt.setString(2, treino.getTipoTreino());
            stmt.setString(3, treino.getDescricao());
            stmt.setInt(4, treino.getDuracaoMinutos());
            stmt.setDate(5, treino.getDataInicio());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Treino treino) throws SQLException {
        String sql = "UPDATE treino SET aluno_id=?, tipo_treino=?, descricao=?, duracao_minutos=?, data_inicio=? WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, treino.getIdAluno());
            stmt.setString(2, treino.getTipoTreino());
            stmt.setString(3, treino.getDescricao());
            stmt.setInt(4, treino.getDuracaoMinutos());
            stmt.setDate(5, treino.getDataInicio());
            stmt.setInt(6, treino.getIdTreino());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM treino WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public Treino buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM treino WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearTreino(rs);
                }
            }
        }
        return null;
    }

    public List<Treino> listarTodos() throws SQLException {
        List<Treino> treino = new ArrayList<>();
        String sql = "SELECT * FROM treino";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                treino.add(mapearTreino(rs));
                
            }
        }
        
        return treino;
    }
    

    private Treino mapearTreino(ResultSet rs) throws SQLException {
        Treino treino = new Treino();
        treino.setIdTreino(rs.getInt("id"));
        treino.setIdAluno(rs.getInt("aluno_id"));
        treino.setTipoTreino(rs.getString("tipo_treino"));
        treino.setDescricao(rs.getString("descricao"));
        treino.setDuracaoMinutos(rs.getInt("duracao_minutos"));
        treino.setDataInicio(rs.getDate("data_inicio"));
        return treino;
    }
}
