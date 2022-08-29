package hades;

public class Transacao {

    private static long id = 0; //id da transacao
    
    private double valor; // valor da transacao

    public Transacao(){
        id++;
    }
    public Transacao(double valor){
        this();
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getId() {
        return id;
    }
        
}
