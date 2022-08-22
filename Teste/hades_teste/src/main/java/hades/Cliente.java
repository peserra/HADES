package hades;

import java.util.List;

// TUDO QUE ESTIVER PUBLIC É TEMPORARIO. COLOCAR GETTER E SETTER E DEIXAR PRIVATE
public class Cliente {
    private String nome;
    private String cnpj;
    private String risco;
    public List<Double> transacoesMes;
    public double movTotalMesAnterior;
    private double mediaValorMesAnterior;
    public double numTransacoes;
    public boolean paraiso;
    public double faturamento;

    public void solicitarAberturaDeConta();
    public void solicitarFechamentoDeConta();
    public void solicitarTrocaTerritorio();
    
}
