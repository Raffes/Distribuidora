/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.conexao.Conexao;
import br.com.crud.modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Neve
 */
public class CategoriaDAO {
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    public boolean insertCategoria(Categoria categoria){
        try{
            sql = "insert into t_categoria (categoria) values (?)";
            
            con = Conexao.openConnection();
            ps = con.prepareStatement(sql);
            
            
            ps.setString(1, categoria.getCategoria());
            
            ps.execute();
            Conexao.closeConnection();
            
            return true;
        }catch(SQLException e){
            System.out.println(e);
            
            return false;
        }
    }
}
