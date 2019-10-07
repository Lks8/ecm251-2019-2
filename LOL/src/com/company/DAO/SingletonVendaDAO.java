package com.company.DAO;

import com.company.model.Usuario;
import com.company.model.Venda;
import com.company.utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonVendaDAO {
    private Connection connection;
    private static SingletonVendaDAO instance = null;
    public static SingletonVendaDAO getInstance(){
        if(instance == null)
            instance = new SingletonVendaDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private SingletonVendaDAO(String myConnection){
        try{
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e){
            e.printStackTrace();
            connection = null;
        }
    }

    public boolean insertVenda(Venda venda){
        PreparedStatement comandoSQL;
        try{
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_VENDAS, 4));
            comandoSQL.setInt(2,venda.produto);
            comandoSQL.setInt(3,venda.quantidade);
            comandoSQL.setInt(4,venda.usuario);
            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.executeUpdate();
            connection.commit();
            connection.close();
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

    public List<Venda> getAllVenda(){
        List<Venda> vendas = new ArrayList<>();
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAll(Constants.TABELA_VENDAS));
            while(rs.next()){
                Venda venda = new Venda(
                        rs.getInt("produto"),
                        rs.getInt("quantidade"),
                        rs.getInt("usuario")
                );
                venda.id = rs.getInt("id");
                vendas.add(venda);
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return vendas;
    }


}
