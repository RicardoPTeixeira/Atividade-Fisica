package com.ricardo.atividadefisica;

public class Dados {
    private String nome;
    private String peso;
    private String idade;
    private String sexo;
    private String diaDaSemana;
    private String descritivo;

    public Dados(String n, String p, String i, String s, String d, String desc) {
        nome = n;
        peso = p;
        idade = i;
        sexo = s;
        diaDaSemana = d;
        descritivo = desc;
    }

    public Dados() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getDescritivo() {
        return descritivo;
    }

    public void setDescritivo(String descritivo) {
        this.descritivo = descritivo;
    }
}
