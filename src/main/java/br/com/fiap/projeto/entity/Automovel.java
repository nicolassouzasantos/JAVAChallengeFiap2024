package br.com.fiap.projeto.entity;

public class Automovel {
    private String placa;
    private int ano;
    private String modelo;
    private double motorizacao;
    private Servico servico; // Associação com Servico

    // Construtor vazio
    public Automovel() {}

    // Construtor completo
    public Automovel(String placa, int ano, String modelo, double motorizacao, Servico servico) {
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.motorizacao = motorizacao;
        this.servico = servico;
    }

    // Getters e Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(double motorizacao) {
        this.motorizacao = motorizacao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
