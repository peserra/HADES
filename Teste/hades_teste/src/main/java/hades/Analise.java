package hades;

import java.util.LinkedList;
import java.util.List;

public class Analise {
    private Cliente cliente;
    private Analista analista;
    private String resultado;
    private String classificacao;
    private List<Double> analisadas;
    private int pontuacao = 0;

    public Analise(Analista analista, Cliente cliente) {
        this.cliente = cliente;
        this.analista = analista;

    }

    public String analisar(Cliente cliente) {
        analisadas = new LinkedList<Double>();
        if (analista != null) {
            for (Double transacao : cliente.transacoesMes) { // como entrar nos dados de cliente ?
                analisadas.add(transacao);
            }
        }
        double somaValores = 0;
        for (Double transacao : analisadas) {
            somaValores += transacao;
        }

        // Criterios de analise
        try {
            // criterio valor das transacoes
            switch (cliente.getRisco()) {
                case "baixo":
                    if (somaValores > (cliente.getMovTotalMesAnterior() * 1.2)) {
                        pontuacao++;
                    }
                case "medio":
                    if (somaValores > (cliente.getMovTotalMesAnterior() * 1.15)) {
                        pontuacao++;
                    }
                case "alto":
                    if (somaValores > (cliente.getMovTotalMesAnterior() * 1.1)) {
                        pontuacao++;
                    }
            }

            // analise paraiso
            if (cliente.isParaiso() && somaValores > 0) {
                pontuacao++;
            }

            // faturamento
            if (somaValores > cliente.getFaturamento()) {
                pontuacao++;
            }

            // criterio quantidade das analises
            switch (cliente.getRisco()) {
                case "baixo":
                    if (analisadas.size() > (cliente.getNumTransacoes() * 1.2)) {
                        pontuacao++;
                    }
                case "medio":
                    if (analisadas.size() > (cliente.getNumTransacoes() * 1.15)) {
                        pontuacao++;
                    }
                case "alto":
                    if (analisadas.size() > (cliente.getNumTransacoes() * 1.1)) {
                        pontuacao++;
                    }
            }

            resultado = classificar(pontuacao);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = "Não foi possível analisar, tente novamente";
        } finally {
            System.out.println("Fim da analise");
        }
        return resultado;

    }

    private String classificar(int pontuacao) {
        classificacao = "";
        if (pontuacao > 0 && pontuacao <= 2)
            classificacao = "Alpha";
        else
            classificacao = "Omega";
        return classificacao;
    }
}
