/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.Classes;

/**
 *
 * @author FabricioF
 */
public class Usuario {
    private int id_usuario;
    private int matricula;
    private String nome;
    
    public Usuario(int matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    /**
     * @return the codigo
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the codigo to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
}
