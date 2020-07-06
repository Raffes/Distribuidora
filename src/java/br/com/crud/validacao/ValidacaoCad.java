/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crud.validacao;

import br.com.crud.modelo.Usuario;

/**
 *
 * @author Neve
 */
public class ValidacaoCad {
   

    public int validarUsuario(Usuario valUsuario){
        
        if(valUsuario.getSenha().length() > 0 && valUsuario.getSenha().length() <= 6){
            
             return 1;
        }else{
            
             return 0;
        }
          
    }
    
}
