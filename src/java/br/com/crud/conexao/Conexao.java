/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neve
 */
public class Conexao {
    static Connection con = null;
    
    static String url = "jdbc:mysql://localhost:3306/d_distribuidora?useLegacyDatetimeCode=false&serverTimezone=America/Sao_Paulo";
    static String user = "root";
    static String password = "";
    
    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected");
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    public static void closeConnection(){
        try {
            con.close();
        }catch(SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
