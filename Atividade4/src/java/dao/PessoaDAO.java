/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardo
 */
public class PessoaDAO {
    public PessoaDAO() {
    }
    
    public List<Usuario> buscarTodos() {
        
        List<Usuario> resultado = new ArrayList<Usuario>();
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try {
            con = ConnectionFactory.getConnection();
            st = con.prepareStatement("SELECT * from tb_usuario");
            rs = st.executeQuery();
            
            while (rs.next()){
              Usuario p = new Usuario();
              p.setNome(rs.getString("nome_usuario"));
              p.setUsuario(rs.getString("login_usuario"));
              p.setSenha(rs.getString("senha_usuario"));
              resultado.add(p);
            }
            return resultado;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (rs!=null)
                try {rs.close();} catch (Exception e){}
            if (st!=null)
                try {st.close();} catch (Exception e){}
            if (con!=null)
                try {con.close();} catch (Exception e){}
        }
        //return null;
    }
    
    public void inserirPessoa(Usuario pessoa) throws ClassNotFoundException, SQLException{
        Connection con = null;
        PreparedStatement st = null;
        
        try {
            con = ConnectionFactory.getConnection();
           
            st = con.prepareStatement("INSERT INTO tb_usuario (nome_usuario,login_usuario,senha_usuario) VALUES (?,?,?)");
            st.setString(1, pessoa.getNome());
            st.setString(2, pessoa.getUsuario());
            st.setString(3, pessoa.getSenha());
            System.out.println("Inserindo!");
            st.executeUpdate();
            
        } catch (SQLException e) {
           throw new RuntimeException(e);
        } finally {
            if (st!=null)
                try {st.close();} catch (SQLException e){}
            if (con!=null)
                try {con.close();} catch (SQLException e){}
        }
    }   

}

