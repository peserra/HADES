package hades;

import java.util.Date;

public class Conta {
    private int agencia;
    private int numConta;
    private Cliente cliente;
    private Gerente gerente;
    private double saldo;
    private boolean status;
    private Date abertura;
    private boolean paraiso;
    private boolean bloqueada;

    public int getAgencia() {
        return agencia;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Gerente getGerente() {
        return gerente;
    }
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public Date getAbertura() {
        return abertura;
    }
    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }
    public boolean isParaiso() {
        return paraiso;
    }
    public void setParaiso(boolean paraiso) {
        this.paraiso = paraiso;
    }
    public boolean isBloqueada() {
        return bloqueada;
    }
    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }
    public void sacar();
    public void depoistar();
    public void transferir();
    
}
