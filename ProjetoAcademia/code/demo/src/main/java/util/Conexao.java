package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    public static Connection createConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/academia?useSSL=false&serverTimezone=UTC",
                "root",
                "" // Aqui você coloca sua senha do MySQL caso tiver alguma
            );
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
            // Log detalhado para debug
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
