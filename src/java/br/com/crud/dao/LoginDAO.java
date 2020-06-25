/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.conexao.Conexao;
import br.com.crud.modelo.Login;
//import br.com.crud.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Neve
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;//receber o resultado do select
    String sql;
    
    
    public String verificarUsuario(Login login) throws ClassNotFoundException, SQLException{
        String emailDB = "";
        String senhaDB = "";
        
        sql = "select * from t_usuario where email = ? and senha = ?";
        
        try {
            con = Conexao.openConnection();
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getSenha());
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                emailDB = rs.getString("email");
                senhaDB = rs.getString("senha");
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        if(emailDB.equals(login.getEmail()) && senhaDB.equals(login.getSenha())){
           HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
           session.setAttribute("email", emailDB);
           return "home.xhtml";
        }else{
            return "index.xhtml";
        }
    }
    
    /*public Login selectUsuario(Login login){
        Login user = null;
        try{
        sql = "select ?, ? from t_usuario";
        con = Conexao.openConnection();
        ps = con.prepareStatement(sql);
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getSenha());
            rs = ps.executeQuery();
       
            if (rs.next()) {
                user = new Login();
                
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
            }
            Conexao.closeConnection();
            
            
            
        }catch(SQLException ex){
            System.out.println("Erro no SELECT: LoginDAO");
            
        }return user;
    }
    
    public ArrayList<Login> selectLogin(Login login) {
        ArrayList<Login> listaLogin = new ArrayList<>();
        try {
            sql = "select ?, ? from t_usuario";
            con = Conexao.openConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getSenha());
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Login user = new Login();
                
                user.setEmail(rs.getString("email"));
                user.setSenha(rs.getString("senha"));
                
                listaLogin.add(user);
            }
            Conexao.closeConnection();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaLogin;
    }*/
    
    
}
