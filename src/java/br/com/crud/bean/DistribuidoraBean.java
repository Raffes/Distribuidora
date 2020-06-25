/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.bean;

import br.com.crud.dao.LoginDAO;
import br.com.crud.dao.UsuarioDAO;
//import br.com.crud.modelo.Login;
import br.com.crud.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Neve
 */
@ManagedBean(name = "bean")
@SessionScoped
public class DistribuidoraBean {
    private Usuario usu;
    //private Login login;
    private UsuarioDAO usuDAO;
    private LoginDAO loginDAO;
    
    public DistribuidoraBean(){
        usu = new Usuario();
        //login = new Login();
        usuDAO = new UsuarioDAO();
        loginDAO = new LoginDAO();
    }

    

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public UsuarioDAO getUsuDAO() {
        return usuDAO;
    }

    public void setUsuDAO(UsuarioDAO usuDAO) {
        this.usuDAO = usuDAO;
    }
    
    public void addUsuario(){
        usuDAO.insertUsuario(usu);
        usu = new Usuario();
        
    }
    
}
