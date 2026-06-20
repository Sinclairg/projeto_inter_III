package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/proj_int_III";

    private static final String USER =
            "postgres";

    private static final String PASSWORD =
            "postgres";

    public static Connection conectar() {

        try {

            Connection conn =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println(
                    "Conexão realizada com sucesso!"
            );

            return conn;

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao conectar ao banco."
            );

            e.printStackTrace();

            return null;
        }
    }
}