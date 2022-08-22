package Java;

public  class Analise {
    private Cliente cliente;
    private Analista analista;
    private Transacao transacao;

    public Analise (Cliente cliente, Analista analista, Transacao transacao) {
        this.cliente = cliente;
        this.analista = analista;
        this.transacao = transacao;
    }
}
