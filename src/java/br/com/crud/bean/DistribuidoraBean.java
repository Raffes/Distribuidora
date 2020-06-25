/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.bean;

import br.com.crud.dao.BebidaDAO;
import br.com.crud.dao.CategoriaDAO;
import br.com.crud.dao.UsuarioDAO;
import br.com.crud.modelo.Bebida;
import br.com.crud.modelo.Categoria;
import br.com.crud.modelo.Usuario;
import java.util.ArrayList;
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
    private Categoria cat;
    private Bebida beb;
    
    private UsuarioDAO usuDAO;
    private CategoriaDAO catDAO;
    private BebidaDAO bebDAO;
    
    private ArrayList<Categoria> listCat;
    
    public DistribuidoraBean(){
        usu = new Usuario();
        cat = new Categoria();
        beb = new Bebida();
        
        usuDAO = new UsuarioDAO();
        catDAO = new CategoriaDAO();
        bebDAO = new BebidaDAO();
       
        listCat = catDAO.listarCategoria();
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

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }

    public Bebida getBeb() {
        return beb;
    }

    public void setBeb(Bebida beb) {
        this.beb = beb;
    }

    public CategoriaDAO getCatDAO() {
        return catDAO;
    }

    public void setCatDAO(CategoriaDAO catDAO) {
        this.catDAO = catDAO;
    }

    public BebidaDAO getBebDAO() {
        return bebDAO;
    }

    public void setBebDAO(BebidaDAO bebDAO) {
        this.bebDAO = bebDAO;
    }

    public ArrayList<Categoria> getListCat() {
        return listCat;
    }

    public void setListCat(ArrayList<Categoria> listCat) {
        this.listCat = listCat;
    }
    
    public void addUsuario(){
        usuDAO.insertUsuario(usu);
        usu = new Usuario();
    }
    
    public void addBebida(){
        bebDAO.insertBebida(beb);
        beb = new Bebida();
    }
    
    public void addCategoria(){
        catDAO.insertCategoria(cat);
        cat = new Categoria();
    }
    
}
