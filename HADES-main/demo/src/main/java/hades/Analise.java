package hades;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Analise {
    
    private Analista analista;
    private Cliente cliente;
    private String resultado;
    private String classificacao;
    private int pontuacao;
    private List<Transacao> analisadas;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Analista getAnalista() {
        return analista;
    }

    public void setAnalista(Analista analista) {
        this.analista = analista;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Transacao> getAnalisadas() {
        return analisadas;
    }

    public void setAnalisadas(List<Transacao> analisadas) {
        this.analisadas = analisadas;
    }

    public Analise(Analista analista) {
       this.analista = analista;
    }
       

    

    public String analisar(Cliente cliente) {
        setCliente(cliente);
        analisadas = new LinkedList<Transacao>();
        if (analista != null) {
            for (Transacao transacao : cliente.getTransacoesMes()) { // como entrar nos dados de cliente ?
                analisadas.add(transacao);
            }
        }
        double somaValores = 0;
        for (Transacao transacao : analisadas) {
            somaValores += transacao.getValor();
        }

        // Criterios de analise
        try {
            // criterio valor das transacoes
            switch (cliente.getRisco().toLowerCase()) {
                case "baixo":
                    if (somaValores > (cliente.getMediaValorMesAnterior() * 1.2)) {
                        pontuacao++;
                    }
                case "medio":
                    if (somaValores > (cliente.getMediaValorMesAnterior() * 1.15)) {
                        pontuacao++;
                    }
                case "alto":
                    if (somaValores > (cliente.getMediaValorMesAnterior() * 1.1)) {
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
            switch (cliente.getRisco().toLowerCase()) {
                case "baixo":
                    if (analisadas.size() > (cliente.getNumTransacoesMesAnterior() * 1.2)) {
                        pontuacao++;
                    }
                case "medio":
                    if (analisadas.size() > (cliente.getNumTransacoesMesAnterior() * 1.15)) {
                        pontuacao++;
                    }
                case "alto":
                    if (analisadas.size() > (cliente.getNumTransacoesMesAnterior() * 1.1)) {
                        pontuacao++;
                    }
            }

            resultado = classificar(pontuacao);
            System.out.println("o resultado da análise foi: "+ resultado);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = "Não foi possível analisar, tente novamente";
        } finally {
            System.out.println("\nFim da analise");
        }
        return resultado;

    }

    private String classificar(int pontuacao) {
        classificacao = "";
        if (pontuacao > 0 && pontuacao <= 2)
            classificacao = "Alpha";
        else if (pontuacao > 2)
            classificacao = "Omega";
        else
            classificacao = "Movimentação dentro da conformidade";
        return classificacao;
    }

    



}
