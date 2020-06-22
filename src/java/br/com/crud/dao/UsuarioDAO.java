/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.conexao.Conexao;
import br.com.crud.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Neve
 */
public class UsuarioDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection con;
    private String sql;
    
    public void insertUsuario(Usuario usuario){
        try{
            sql = "insert into t_usuario(nome, email, dataNascimento, senha) VALUES (? ,?, STR_TO_DATE(?, '%d/%m/%Y'), MD5(?))";
            con = Conexao.openConnection();
            
            ps = con.prepareStatement(sql);
   
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getDataNascimento());
            ps.setString(4, usuario.getSenha());
            
            ps.execute();
            Conexao.closeConnection();
            
            
        }catch(SQLException e){
            System.out.println(e);
            
            
        }
    }
    
    
    
}
