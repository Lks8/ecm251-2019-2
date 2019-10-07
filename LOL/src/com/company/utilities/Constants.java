package com.company.utilities;

import com.company.model.Produto;

public class Constants {
    public static final String URL_MEU_BANCO = "jdbc:sqlite:meu_banco.db";
    public static int ID_NULO =  -1;
    public static final String TABELA_USUARIO = "usuarios";
    public static final String TABELA_PRODUTOS = "produtos";
    public static final String TABELA_VENDAS = "vendas";

    //Funções SQL

    public static final String getInsert(String table, int paramsCount){
        String sqlInsert = "INSERT INTO " + table + " VALUES (";
        for (int i = 0; i < paramsCount-1; i++) {
            sqlInsert += "?,";
        }
        sqlInsert += "?);";
        return sqlInsert;
    }

    public static final String selectAll(String table){
        return "SELECT * FROM " +table+";";
    }

    public static final String selectId(String table, int id){
        return "SELECT * FROM "+table+" WHERE id="+id+";";
    }

    public static final String selectLogin(String table, String nome, String senha){
        return "SELECT * FROM "+table+" WHERE nome='"+nome+"' AND senha='"+senha+"';";
    }

    public static final String selectCategoria(String table, String categoria){
        return "SELECT * FROM "+table+" WHERE categoria='"+categoria+"';";
    }

    public static final String vendaDeProdutosPorId(String table, Produto product){
        return "UPDATE "+ table + " SET nome=\"" + product.nome + "\"," +
                "quantidade=\"" + product.quantidade + "\"," +
                "fabricante=\"" + product.fabricante + "\"," +
                "categoria=\"" + product.categoria + "\"," +
                "preco=\"" + product.preco + "\" WHERE id=" + product.id+";";
    }
}
