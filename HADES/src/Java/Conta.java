package Java;

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

    public void sacar();
    public void depoistar();
    public void transferir();
    
}
