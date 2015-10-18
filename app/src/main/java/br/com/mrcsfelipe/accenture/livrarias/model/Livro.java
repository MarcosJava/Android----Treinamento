package br.com.mrcsfelipe.accenture.livrarias.model;

import java.io.Serializable;

/**
 * Created by markFelipe on 17/10/15.
 */
public class Livro implements Serializable{

    private Integer id;
    private String nome;
    private String autor;
    private String editora;

    public Livro(Integer id, String nome, String autor, String editora) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.editora = editora;
    }

    public Livro() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                '}';
    }
}
