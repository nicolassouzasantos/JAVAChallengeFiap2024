package br.com.fiap.projeto.entity;

public class Servico {
    private int idServico;
    private String tipoServico;
    private String duracao;
    private char delivery;
    private Oficina oficina; // Associação com Oficina

    // Construtor vazio
    public Servico() {}

    // Construtor completo
    public Servico(int idServico, String tipoServico, String duracao, char delivery, Oficina oficina) {
        this.idServico = idServico;
        this.tipoServico = tipoServico;
        this.duracao = duracao;
        this.delivery = delivery;
        this.oficina = oficina;
    }

    // Getters e Setters
    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public char getDelivery() {
        return delivery;
    }

    public void setDelivery(char delivery) {
        this.delivery = delivery;
    }

    public Oficina getOficina() {
        return oficina;
    }

    public void setOficina(Oficina oficina) {
        this.oficina = oficina;
    }
}
