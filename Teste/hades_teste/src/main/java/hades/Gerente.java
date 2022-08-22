package hades;


public class Gerente {
    private int id;
    private String login;
    private String senha;
    private String nome;
    private double autenticacao;

    public void abrirConta();
    public void fehcarConta();
    public void solicitarAnalise(Cliente cliente, Analista analista) {
        analista.executarAnalise(cliente);
    }
    public void trocarTerritorio();
    
}
