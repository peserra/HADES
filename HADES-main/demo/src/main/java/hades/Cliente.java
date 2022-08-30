package hades;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.management.InvalidAttributeValueException;

public class Cliente extends Usuario {
    private String cnpj;
    private double faturamento;
    private String risco;
    private boolean paraiso = false;
    private List<Transacao> transacoesMes;
    private int numTransacoesMesAnterior = 16;
    private double mediaValorMesAnterior = 10000000.0;
    Scanner input = new Scanner(System.in);

    public Cliente() {
    }

    public Cliente(String nome, String senha, String cnpj, double faturamento ) throws Exception {
        super(nome, senha);
        transacoesMes = new LinkedList<Transacao>();
        setCnpj(cnpj);
        setFaturamento(faturamento);
        setRisco(risco);
        setParaiso(paraiso);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws Exception {
        if (cnpj.matches("\\d{2}.\\d{3}.\\d{3}/0001-\\d{2}")) {
            this.cnpj = cnpj;
        } else {
            throw new InvalidAttributeValueException("cnpj deve ser da forma XX.XXX.XXX/0001-XX");
        }
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

    public void realizarTransacao () {
        System.out.println("Insira o valor da transação");
        Transacao t = new Transacao(input.nextDouble());
        if(!transacoesMes.contains(t)) {
            transacoesMes.add(t);
        }
    }
}
