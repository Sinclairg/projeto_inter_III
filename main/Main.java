package main;

import java.sql.Connection;

import database.Conexao;

public class Main {

    public static void main(String[] args) {

        Connection conn =
                Conexao.conectar();

        if (conn != null) {

            System.out.println(
                    "Sistema iniciado."
            );

        } else {

            System.out.println(
                    "Falha ao iniciar."
            );

        }
    }
}
