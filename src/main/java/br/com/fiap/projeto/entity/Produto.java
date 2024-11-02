package br.com.fiap.projeto.entity;

public class Produto {
    private long codProduto;
    private String marca;
    private String tipo;
    private String nome;
    private double valorProduto;

    // Construtor vazio
    public Produto() {}

    // Construtor completo
    public Produto(long codProduto, String marca, String tipo, String nome, double valorProduto) {
        this.codProduto = codProduto;
        this.marca = marca;
        this.tipo = tipo;
        this.nome = nome;
        this.valorProduto = valorProduto;
    }

    // Getters e Setters
    public long getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(long codProduto) {
        this.codProduto = codProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
}
