package br.com.fiap.projeto.entity;

public class Oficina {
    private String cnpj;
    private String nomeFantasia;
    private String tipo;
    private Endereco endereco; // Associação com Endereco

    // Construtor vazio
    public Oficina() {}

    // Construtor completo
    public Oficina(String cnpj, String nomeFantasia, String tipo, Endereco endereco) {
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.tipo = tipo;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
