package hades;

import java.util.List;

// TUDO QUE ESTIVER PUBLIC É TEMPORARIO. COLOCAR GETTER E SETTER E DEIXAR PRIVATE
public class Cliente {
    private String nome;
    private String cnpj;
    private String risco;
    public List<Double> transacoesMes;
    private double movTotalMesAnterior;
    private double mediaValorMesAnterior;
    private double numTransacoes;
    private boolean paraiso;
    private double faturamento;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getRisco() {
        return risco;
    }
    public void setRisco(String risco) {
        this.risco = risco;
    }
    public List<Double> getTransacoesMes() {
        return transacoesMes;
    }
    public void setTransacoesMes(List<Double> transacoesMes) {
        this.transacoesMes = transacoesMes;
    }
    public double getMovTotalMesAnterior() {
        return movTotalMesAnterior;
    }
    public void setMovTotalMesAnterior(double movTotalMesAnterior) {
        this.movTotalMesAnterior = movTotalMesAnterior;
    }
    public double getMediaValorMesAnterior() {
        return mediaValorMesAnterior;
    }
    public void setMediaValorMesAnterior(double mediaValorMesAnterior) {
        this.mediaValorMesAnterior = mediaValorMesAnterior;
    }
    public double getNumTransacoes() {
        return numTransacoes;
    }
    public void setNumTransacoes(double numTransacoes) {
        this.numTransacoes = numTransacoes;
    }
    public boolean isParaiso() {
        return paraiso;
    }
    public void setParaiso(boolean paraiso) {
        this.paraiso = paraiso;
    }
    public double getFaturamento() {
        return faturamento;
    }
    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }
    public void solicitarAberturaDeConta();
    public void solicitarFechamentoDeConta();
    public void solicitarTrocaTerritorio();
    
}
