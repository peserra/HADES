package hades;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Persistence;

@Entity
public class Cliente extends Login {
    @Id
    @GeneratedValue
    private long id;

    //hardcoded pelo cliente
    private String cnpj = "";
    private double faturamento = 0; 
    
    //setado pelo gerente
    private String risco = ""; 
    private boolean paraiso = false; 
   
    @OneToMany
    private List<Transacoes> transacoesMes;



    //hardcoded por causa de falta de tempo
    private int numTransacoesMesAnterior = 16; 
    private double mediaValorMesAnterior = 10000000.0;  

      
    //persistencia
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    
    public Cliente() {
        
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

    public void setFaturamento(double faturamento) {
        if (faturamento >= 0) {
            this.faturamento = faturamento;
        }
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco, Gerente gerente) {
        if(gerente!= null) {
            this.risco = risco;
        }
    }

    public boolean isParaiso() {
        return paraiso;
    }

    public void setParaiso(boolean paraiso, Gerente gerente) {
        if(gerente!= null) {
            this.paraiso = paraiso;
        }        
    }

    public List<Transacoes> getTransacoesMes() {
        return transacoesMes;
    }

    public void setTransacoesMes(List<Transacoes> transacoesMes) {
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

    
   
    // nao precisa de destino, vai só encher o array de controle
    private void realizarTransacao(Transacoes transacao) {
        if(transacao.getValor() > 0) {
            transacoesMes.add(transacao);
        }

        em.getTransaction().begin();
        em.persist(transacoesMes);
        em.getTransaction().commit();
    }

    //ver depois
    private LinkedList<Double> retornarDoBanco (EntityManager em) {
        em.find(entityClass, primaryKey)
    }
   
}
