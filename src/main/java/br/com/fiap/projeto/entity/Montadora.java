package br.com.fiap.projeto.entity;

public class Montadora {
    private int idMontadora;
    private String cnpj;
    private String nome;
    private Automovel automovel; // Associação com Automovel

    // Construtor vazio
    public Montadora() {}

    // Construtor completo
    public Montadora(int idMontadora, String cnpj, String nome, Automovel automovel) {
        this.idMontadora = idMontadora;
        this.cnpj = cnpj;
        this.nome = nome;
        this.automovel = automovel;
    }

    // Getters e Setters
    public int getIdMontadora() {
        return idMontadora;
    }

    public void setIdMontadora(int idMontadora) {
        this.idMontadora = idMontadora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }
}
