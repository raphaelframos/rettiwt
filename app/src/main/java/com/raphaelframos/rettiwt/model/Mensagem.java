package com.raphaelframos.rettiwt.model;

public class Mensagem {

    private String nome;
    private String mensagem;
    private String foto;

    public Mensagem(){}

    public Mensagem(String nome, String mensagem, String foto) {
        setFoto(foto);
        setMensagem(mensagem);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getMensagemInvertida() {
        StringBuilder texto = new StringBuilder(getMensagem());
        return texto.reverse().toString();
    }
}
