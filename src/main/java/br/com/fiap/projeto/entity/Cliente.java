package br.com.fiap.projeto.entity;

public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private Automovel automovel; // Associação com Automovel
    private Endereco endereco;   // Associação com Endereco

    // Construtor vazio
    public Cliente() {}

    // Construtor completo
    public Cliente(String cpf, String nome, String telefone, String email, Automovel automovel, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.automovel = automovel;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Automovel getAutomovel() {
        return automovel;
    }

    public void setAutomovel(Automovel automovel) {
        this.automovel = automovel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
