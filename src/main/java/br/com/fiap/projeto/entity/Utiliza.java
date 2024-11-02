package br.com.fiap.projeto.entity;

public class Utiliza {
    private Servico servico;
    private Produto produto;

    // Construtor vazio
    public Utiliza() {}

    // Construtor completo
    public Utiliza(Servico servico, Produto produto) {
        this.servico = servico;
        this.produto = produto;
    }

    // Getters e Setters
    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
