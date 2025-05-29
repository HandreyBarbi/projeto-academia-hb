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
        String sql = "INSERT INTO treinos (aluno_id, tipo_treino, descricao, duracao_minutos, data_inicio) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "UPDATE treinos SET aluno_id=?, tipo_treino=?, descricao=?, duracao_minutos=?, data_inicio=? WHERE idtreino=?";
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

    public void deletar(int idtreino) throws SQLException {
        String sql = "DELETE FROM treinos WHERE idtreino=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idtreino);
            stmt.executeUpdate();
        }
    }

    public Treino buscarPorId(int idtreino) throws SQLException {
        String sql = "SELECT * FROM treinos WHERE idtreino=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idtreino);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapearTreino(rs);
                }
            }
        }
        return null;
    }

    public List<Treino> listarTodos() throws SQLException {
        List<Treino> treinos = new ArrayList<>();
        String sql = "SELECT * FROM treinos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                treinos.add(mapearTreino(rs));
            }
        }
        return treinos;
    }

    private Treino mapearTreino(ResultSet rs) throws SQLException {
        Treino treino = new Treino();
        treino.setIdTreino(rs.getInt("idtreino"));
        treino.setIdAluno(rs.getInt("aluno_id"));
        treino.setTipoTreino(rs.getString("tipo_treino"));
        treino.setDescricao(rs.getString("descricao"));
        treino.setDuracaoMinutos(rs.getInt("duracao_minutos"));
        treino.setDataInicio(rs.getDate("data_inicio"));
        return treino;
    }
}
