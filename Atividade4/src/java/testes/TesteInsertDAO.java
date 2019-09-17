/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Usuario;
import dao.PessoaDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class TesteInsertDAO {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Usuario p = new Usuario();
        
        // set de todos os dados
        //p.setNome("c");
        //p.setUsuario("a");
        //p.setSenha("b");
        
        PessoaDAO dao = new PessoaDAO();
        //dao.inserirPessoa(p);
        List<Usuario> lista = dao.buscarTodos();
        
        for (Usuario x: lista) {
            System.out.println(x.getId());
            System.out.println(x.getNome());
            System.out.println(x.getUsuario());
            
        }   
    }    

}
