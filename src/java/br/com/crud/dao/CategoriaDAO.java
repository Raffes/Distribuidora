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
import java.util.ArrayList;

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
    
    public ArrayList<Categoria> listarCategoria(){
        ArrayList<Categoria> listarCategoria = new ArrayList<>();
        try {
            sql = "select * from t_categoria";
            con = Conexao.openConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setCod_categoria(rs.getString("cod_categoria"));
                cat.setCategoria(rs.getString("categoria"));
                listarCategoria.add(cat);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return listarCategoria;
    }
    
    public ArrayList<Categoria> pesquisarCategoria(String pCat){
        ArrayList<Categoria> pCategoria = new ArrayList<>();
        
        try {
            sql = "SELECT * FROM t_categoria c WHERE c.categoria = ? OR c.cod_categoria > 0";
            
            con = Conexao.openConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pCat);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
               Categoria cate = new Categoria(); 
               cate.setCod_categoria(rs.getString("cod_categoria"));
               cate.setCategoria(rs.getString("categoria"));
                
                pCategoria.add(cate);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return pCategoria;
    }
    
}
