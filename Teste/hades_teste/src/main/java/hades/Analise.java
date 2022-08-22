package hades;

import java.util.LinkedList;
import java.util.List;

public  class Analise {
    private Cliente cliente;
    private Analista analista;
    private double resultado;
    private String classificacao;
    private List<Double> analisadas;
    

    public Analise (Cliente cliente, Analista analista) {
        this.cliente = cliente;
        this.analista = analista;
        
    }

    public double analisar(Cliente cliente) {
        analisadas = new LinkedList<Double>();
        if (analista != null) {
            for (Double transacao: cliente.transacoesMes) { //como entrar nos dados de cliente ?
                analisadas.add(transacao);
            }
        }
        
        
        return resultado;
    }

    //mudar metodo para usar dentro de analisar
    private String classificar(double resultado) {
        resultado = analisar(cliente);
        //determina a classificação a partir da analise
        return classificacao;
    }
}
