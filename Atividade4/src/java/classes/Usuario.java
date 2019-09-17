/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.io.Serializable;

/**
 *
 * @author eduardo
 */
public class Usuario implements Serializable{
    private int id;
    private String nome;
    private String usuario;
    private String senha;
    
    public Usuario() {
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   
    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", nome=" + nome + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
}
