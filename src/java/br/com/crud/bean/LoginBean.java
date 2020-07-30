/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.bean;

import br.com.crud.conexao.Conexao;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Neve
 */
@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
 
    private String cod_usu;
    private String usuario;
    private String email;
    private String senha;
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    
    public String deslogar(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/security/index.xhtml?faces-redirect=true";
    }
    
 
    public String logar() throws ClassNotFoundException, SQLException {
        
        
        String emailDB = "";
        String senhaDB = "";
        
        sql = "select * from t_usuario where email = ? and senha = ?";
        
        try {
            con = Conexao.openConnection();
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, this.email);
            ps.setString(2, this.senha);
            
            rs = ps.executeQuery();
            
            while (rs.next()){
                this.cod_usu = rs.getString("cod_cliente");
                this.usuario = rs.getString("nome");
                emailDB = rs.getString("email");
                senhaDB = rs.getString("senha");
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        
        if(emailDB.equals(this.email) && senhaDB.equals(this.senha)){
           HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
           session.setAttribute("email", emailDB);
           return "/app/home.xhtml?faces-redirect=true";
        }else{
            return "/security/login.xhtml?faces-redirect=true";
        }
        
        
    }

    public String getCod_usu() {
        return cod_usu;
    }

    public void setCod_usu(String cod_usu) {
        this.cod_usu = cod_usu;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}

