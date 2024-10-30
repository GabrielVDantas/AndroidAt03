package com.example.mobileatividade03.models;

public class Filme {

    private String titulo;

    private int ano;

    private String sinopse;

    private String diretor;

    private String imagem;

    public Filme(String titulo, int ano, String sinopse, String diretor, String imagem) {
        this.titulo = titulo;
        this.ano = ano;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.imagem = imagem;
    }

    public Filme() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
