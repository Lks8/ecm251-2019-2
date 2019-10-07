package com.company.DAO;

import com.company.model.Produto;
import com.company.utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonProdutoDAO {
    private Connection connection;
    private static SingletonProdutoDAO instance = null;
    public static SingletonProdutoDAO getInstance(){
        if(instance == null)
            instance = new SingletonProdutoDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private SingletonProdutoDAO(String myConnection){
        try{
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e){
            e.printStackTrace();
            connection = null;
        }
    }
    public boolean insertProduto(Produto product){
        PreparedStatement comandoSQL;
        try{
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_PRODUTOS, 6));
            comandoSQL.setString(2,product.nome);
            comandoSQL.setInt(3,product.quantidade);
            comandoSQL.setString(4,product.fabricante);
            comandoSQL.setString(5,product.categoria);
            comandoSQL.setDouble(6,product.preco);
            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Produto> getAllProduto(){
        List<Produto> produtos = new ArrayList<>();
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAll(Constants.TABELA_PRODUTOS));
            while(rs.next()){
                Produto product = new Produto(
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria"),
                        rs.getDouble("preco")
                );
                product.id = rs.getInt("id");
                produtos.add(product);
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return produtos;
    }

    public Produto getProduto(int id){
        Produto produto = null;
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectId(Constants.TABELA_PRODUTOS, id));
            while(rs.next()){
                produto = new Produto(
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria"),
                        rs.getDouble("preco")
                    );
                produto.id = rs.getInt("id");
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return produto;
    }

    public List<Produto> getProdutosPorCategoria(String categoria){
        List<Produto> produtos = new ArrayList<>();
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectCategoria(Constants.TABELA_PRODUTOS, categoria));
            while(rs.next()){
                Produto product = new Produto(
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria"),
                        rs.getDouble("preco")
                );
                product.id = rs.getInt("id");
                produtos.add(product);
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return produtos;
    }
    public boolean vendaDeProduto(Produto product){
        try{
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(Constants.vendaDeProdutosPorId(Constants.TABELA_PRODUTOS, product));
            connection.commit();

        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
