package com.company.DAO;

import com.company.model.Produto;
import com.company.model.Usuario;
import com.company.utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SingletonUsuarioDAO {
    private Connection connection;
    private static SingletonUsuarioDAO instance = null;
    public static SingletonUsuarioDAO getInstance(){
        if(instance == null)
            instance = new SingletonUsuarioDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private SingletonUsuarioDAO(String myConnection){
        try{
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e){
            e.printStackTrace();
            connection = null;
        }
    }
    public boolean insertUsuario(Usuario user){
        PreparedStatement comandoSQL;
        try{
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_USUARIO, 3));
            comandoSQL.setString(2,user.nome);
            comandoSQL.setString(3,user.senha);
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

    public Usuario Login(String nome, String senha){
        Usuario user = null;
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectLogin(Constants.TABELA_USUARIO, nome, senha));
            while(rs.next()){
                user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("senha")
                );
                user.id = rs.getInt("id");
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public Usuario getUser(int id){
        Usuario user = null;
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectId(Constants.TABELA_USUARIO, id));
            while(rs.next()){
                user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("senha")
                );
                user.id = rs.getInt("id");
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return user;
    }

    public List<Usuario> getAllUsuario(){
        List<Usuario> usuarios = new ArrayList<>();
        try{
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAll(Constants.TABELA_USUARIO));
            while(rs.next()){
                Usuario usuario = new Usuario(
                        rs.getString("nome"),
                        rs.getString("senha")
                );
                usuario.id = rs.getInt("id");
                usuarios.add(usuario);
            }
            rs.close();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return usuarios;
    }

}
