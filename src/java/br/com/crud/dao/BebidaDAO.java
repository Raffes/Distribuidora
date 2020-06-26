/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.dao;

import br.com.crud.conexao.Conexao;
import br.com.crud.modelo.Bebida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Neve
 */
public class BebidaDAO {
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    
    public boolean insertBebida(Bebida bebida){
        try{
            sql = "insert into t_bebida(sku, nome_bebida, descricao, teor_alcoolico, preco, estoque, nacionalidade, cod_cliente, cod_categoria) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            con = Conexao.openConnection();
            ps = con.prepareStatement(sql);
            
            
            ps.setString(1, bebida.getSku());
            ps.setString(2, bebida.getNomeBebida());
            ps.setString(3, bebida.getDescricao());
            ps.setString(4, bebida.getTeorAcoolico());
            ps.setString(5, bebida.getPreco());
            ps.setString(6, bebida.getEstoque());
            ps.setString(7, bebida.getNacionalidade());
            ps.setString(8, bebida.getCliente());
            ps.setString(9, bebida.getCodCategoria());
            
            ps.execute();
            Conexao.closeConnection();
            
            return true;
        }catch(SQLException e){
            System.out.println(e);
            
            return false;
        }
    }
}
