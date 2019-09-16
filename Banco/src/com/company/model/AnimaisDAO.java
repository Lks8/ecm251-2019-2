package com.company.model;

import com.company.utilities.Constants;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimaisDAO {
    private Connection conn;
    private static AnimaisDAO instance = null;
    public static AnimaisDAO getInstance() {
        if(instance == null){
            instance=new AnimaisDAO();
        }
        return instance;
    }

    private AnimaisDAO(){
        try {
            conn = DriverManager.getConnection(Constants.kUrlBanco);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private final String kTableName = "animais;";
    private final String kSelectAllSql = "SELECT * FROM" + kTableName+ ";";
    public Animal getAnimal(String nomne){
        }
    public List<Animal> getAll(){
        List<Animal> animais = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(kSelectAllSql);
        while(rs.next()){
            Animal animal = new Animal(rs.getInt("id"));
            animal.nome = rs.getString("nome");
            animal.tipo = rs.getString("tipo");
            animal.lat = rs.getString("lat");
            animal.lon = rs.getString("lon");
            animal.altura = rs.getString("altura");
            animal.peso = rs.getString("peso");
            return animais;
        }
    }
    public boolean insertAnimal(Animal animal){}
    public boolean updateAnimal(Animal animal){}
    public boolean deleteAnimal(Animal animal){}
}
