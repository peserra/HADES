package hades;

public class Analista extends Usuario{
    private String id;
    private String resultadoAnalise;

    public Analista(String nome, String senha, String id) {
        super(nome, senha);
        this.id = id;
        
    }

    public void analisarTransacoes(Cliente cliente) {
        Analise analise = new Analise(this);
        resultadoAnalise = analise.analisar(cliente);
        System.out.println(resultadoAnalise);
    }
        
}
