package hades;

import java.util.LinkedList;
import java.util.List;

import javax.management.InvalidAttributeValueException;

public class Cliente extends Usuario{
    private String cnpj;
    private double faturamento;
    private String risco;
    private boolean paraiso = false; 
    private List<Transacao> transacoesMes;
    private int numTransacoesMesAnterior = 16; 
    private double mediaValorMesAnterior = 10000000.0;  


        
    public Cliente(String nome, String senha, String cnpj, double faturamento) throws Exception {
        super(nome, senha);
        transacoesMes = new LinkedList<Transacao>();
        this.cnpj = cnpj;
        setFaturamento(faturamento);

    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) throws Exception {
        if (faturamento >= 0) {
            this.faturamento = faturamento;
        } else {
            throw new InvalidAttributeValueException("Faturamento nao pode ser negativo");
        }        
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public boolean isParaiso() {
        return paraiso;
    }

    public void setParaiso(boolean paraiso) {
        this.paraiso = paraiso;
    }

    public List<Transacao> getTransacoesMes() {
        return transacoesMes;
    }

    public void setTransacoesMes(List<Transacao> transacoesMes) {
        this.transacoesMes = transacoesMes;
    }

    public int getNumTransacoesMesAnterior() {
        return numTransacoesMesAnterior;
    }

    public void setNumTransacoesMesAnterior(int numTransacoesMesAnterior) {
        this.numTransacoesMesAnterior = numTransacoesMesAnterior;
    }

    public double getMediaValorMesAnterior() {
        return mediaValorMesAnterior;
    }

    public void setMediaValorMesAnterior(double mediaValorMesAnterior) {
        this.mediaValorMesAnterior = mediaValorMesAnterior;
    }
    
        
    
}
