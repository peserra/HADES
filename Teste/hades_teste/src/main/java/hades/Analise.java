package hades;

import java.util.LinkedList;
import java.util.List;
// MUDAR TUDO Q FOR PUBLIC EM CLIENTE PARA GETTER E SETTER E USAR AQUI
public class Analise {
    private Cliente cliente;
    private Analista analista;
    private String resultado;
    private String classificacao;
    private List<Double> analisadas;
    private String riscoCliente;

    public Analise(Analista analista, Cliente cliente) {
        this.cliente = cliente;
        this.analista = analista;

    }

    public String analisar(Cliente cliente) {
        analisadas = new LinkedList<Double>();
        int pontuacao = 0;
        if (analista != null) {
            for (Double transacao : cliente.transacoesMes) { // como entrar nos dados de cliente no BD ?
                analisadas.add(transacao);
            }

            double somaTransacoes = 0;
            // soma transacoes
            for (Double transacao : analisadas) {
                somaTransacoes += transacao;
            }

            try {
                // analisa valor movimentacao
                switch (riscoCliente) {
                    case "baixo":
                        if (somaTransacoes > cliente.movTotalMesAnterior * 1.2) {
                            pontuacao++;
                        }
                    case "medio":
                        if (somaTransacoes > cliente.movTotalMesAnterior * 1.15) {
                            pontuacao++;
                        }
                    case "alto":
                        if (somaTransacoes > cliente.movTotalMesAnterior * 1.10) {
                            pontuacao++;
                        }
                }
                // analisa paraiso
                if (cliente.paraiso == true && somaTransacoes != 0) {
                    pontuacao++;
                }

                // faturamento
                if (cliente.faturamento < somaTransacoes) {
                    pontuacao++;
                }
                // numero transacoes
                switch (riscoCliente) {
                    case "baixo":
                        if (analisadas.size() > cliente.numTransacoes * 1.2) {
                            pontuacao++;
                        }
                    case "medio":
                        if (analisadas.size() > cliente.numTransacoes * 1.15) {
                            pontuacao++;
                        }
                    case "alto":
                        if (analisadas.size() > cliente.numTransacoes * 1.10) {
                            pontuacao++;
                        }
                }

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        resultado = classificar(pontuacao);
        return resultado;
    }

    // mudar metodo para usar dentro de analisar
    private String classificar(int pontuacao) {
        if(pontuacao > 0 && pontuacao <= 2)
            classificacao = "Alpha";
        else
            classificacao = "Omega";
            
        return classificacao;
    }
}
