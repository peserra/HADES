package Java;

import java.util.List;

public class Cliente {
    private String nome;
    private String cnpj;
    private String risco;
    private List transacoesMes;
    private double movTotalMesAnterior;
    private double mediaValorMesAnterior;
    private double mediaNumTransacoes;

    public void solicitarAberturaDeConta();
    public void solicitarFechamentoDeConta();
    public void solicitarTrocaTerritorio();
    
}
