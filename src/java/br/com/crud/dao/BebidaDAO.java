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
import java.util.ArrayList;

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
    
    public ArrayList<Bebida> pesquisarBebidas(String bebidaSku){
        ArrayList<Bebida> pBebidas = new ArrayList<>();
        
        try {
            sql = "SELECT c.categoria, b.nome_bebida, b.teor_alcoolico, b.nacionalidade, b.preco, b.estoque, b.descricao, b.sku FROM t_categoria c\n" +
                  "INNER JOIN t_bebida b\n" +
                  "ON c.cod_categoria = b.cod_categoria\n" +
                  "WHERE b.nome_bebida = ? OR b.sku = ? or cod_bebidas > 0";
            
            con = Conexao.openConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, bebidaSku);
            ps.setString(2, bebidaSku);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                Bebida bebList = new Bebida();
                
                bebList.setCategoria(rs.getString("categoria"));
                bebList.setNomeBebida(rs.getString("nome_bebida"));
                bebList.setTeorAcoolico(rs.getString("teor_alcoolico"));
                bebList.setNacionalidade(rs.getString("nacionalidade"));
                bebList.setPreco(rs.getString("preco"));
                bebList.setEstoque(rs.getString("estoque"));
                bebList.setDescricao(rs.getString("descricao"));
                bebList.setSku(rs.getString("sku"));
                
                pBebidas.add(bebList);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return pBebidas;
    }
    
}
