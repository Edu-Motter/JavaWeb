/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Usuario;
import dao.PessoaDAO;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class TesteInsertDAO {
    public static void main(String[] args) throws ClassNotFoundException {
        Usuario p = new Usuario();
        
        // set de todos os dados
        //p.setNome("Luiza");
        //p.setUsuario("luiza@gmail.com");
        
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
