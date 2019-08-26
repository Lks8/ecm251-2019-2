package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:meu_banco.db");
        } catch (SQLException e ){
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}
