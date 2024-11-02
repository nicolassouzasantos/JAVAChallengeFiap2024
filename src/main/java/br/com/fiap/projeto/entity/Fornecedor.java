package br.com.fiap.projeto.entity;

public class Fornecedor {
    private String cnpj;
    private String telefone;
    private String email;
    private Produto produto; // Associação com Produto
    private Endereco endereco; // Associação com Endereco

    // Construtor vazio
    public Fornecedor() {}

    // Construtor completo
    public Fornecedor(String cnpj, String telefone, String email, Produto produto, Endereco endereco) {
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.produto = produto;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
