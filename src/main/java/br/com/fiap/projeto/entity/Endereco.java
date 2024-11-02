package br.com.fiap.projeto.entity;

public class Endereco {

    private int enderecoId; // Corresponds to ENDERECO_ID in the database
    private String cidade;
    private String uf;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;

    // Constructor without arguments
    public Endereco() {}

    // Constructor with arguments
    public Endereco(int enderecoId, String cidade, String uf, String cep, String rua, String numero, String complemento) {
        this.enderecoId = enderecoId;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Getters and Setters
    public int getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(int enderecoId) {
        this.enderecoId = enderecoId;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
