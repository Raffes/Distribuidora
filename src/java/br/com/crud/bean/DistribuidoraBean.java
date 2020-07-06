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
import br.com.crud.validacao.ValidacaoCad;
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
    private ValidacaoCad val;
    
    private UsuarioDAO usuDAO;
    private CategoriaDAO catDAO;
    private BebidaDAO bebDAO;
    
    private ArrayList<Categoria> listCat;
    private ArrayList<Bebida> bebPesquisa; 
    private ArrayList<Categoria> catPesquisa;
    
    private String bebidaSku, categoria, valCad;
    
    public DistribuidoraBean(){
        usu = new Usuario();
        cat = new Categoria();
        beb = new Bebida();
        val = new ValidacaoCad();
        
        usuDAO = new UsuarioDAO();
        catDAO = new CategoriaDAO();
        bebDAO = new BebidaDAO();
       
        listCat = catDAO.listarCategoria();
        bebPesquisa = bebDAO.pesquisarBebidas(bebidaSku);
        catPesquisa = catDAO.pesquisarCategoria(categoria);
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getBebidaSku() {
        return bebidaSku;
    }

    public void setBebidaSku(String bebidaSku) {
        this.bebidaSku = bebidaSku;
    }

    public ArrayList<Bebida> getBebPesquisa() {
        return bebPesquisa;
    }

    public void setBebPesquisa(ArrayList<Bebida> bebPesquisa) {
        this.bebPesquisa = bebPesquisa;
    }

    public ArrayList<Categoria> getCatPesquisa() {
        return catPesquisa;
    }

    public void setCatPesquisa(ArrayList<Categoria> catPesquisa) {
        this.catPesquisa = catPesquisa;
    }

    public ValidacaoCad getVal() {
        return val;
    }

    public void setVal(ValidacaoCad val) {
        this.val = val;
    }

    public String getValCad() {
        return valCad;
    }

    public void setValCad(String valCad) {
        this.valCad = valCad;
    }

    
   
    
    /*MÉTODOS*/
    
    /*===================================================================INSERTS====================================================================*/
    public void addUsuario(){
        int result = val.validarUsuario(usu);
        
        
        if(result != 0){
            usuDAO.insertUsuario(usu);
            usu = new Usuario();
            this.valCad = "sucesso";
        }else{
            this.valCad = "erro";
        }
       
    }
    
    public void addBebida(){
        bebDAO.insertBebida(beb);
        beb = new Bebida();
    }
    
    public void addCategoria(){
        catDAO.insertCategoria(cat);
        cat = new Categoria();
        listCat = catDAO.listarCategoria();
    }
    
    /*===========================================================FIM DOS INSERTS====================================================================*/
    
    /*===================================================================SELECTS====================================================================*/
    
    public void pesquisarBebidas(){
        bebPesquisa = bebDAO.pesquisarBebidas(bebidaSku);
    }
    
    public void pesquisarCategoria(){
        catPesquisa = catDAO.pesquisarCategoria(categoria);
    }
    
    /*===========================================================FIM DOS SELECTS====================================================================*/
    
    /*===================================================VALIDAÇÃO DO FORMULARIO====================================================================*/
    
    
    
    
    
    /*============================================FIM DA VALIDAÇÃO DO FORMULARIO====================================================================*/
}
