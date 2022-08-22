package Java;
public class Analista {
    private String login;
    private String senha;
    private int id;
    private double autenticacao;

    public Analista (String login, String senha) {
        try {
            if(verificaAcesso(login, senha)) {
                this.login = login;
                this.senha = senha;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void executarAnalise(Cliente cliente, Transacao transacao) {
        Analise analise = new Analise(cliente, this, transacao);
    }
    public void bloquearConta(Conta conta) {


    }
    public void desbloquerConta(Conta conta) {
        try {
            if (conta.isBloqueada()) {
                conta.setBloqueada(false);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            
        }
    }
    private boolean verificaAcesso(String login, String senha) {
        //buscar no BD login e senha, se bater retorna trueD
        return true;
    }
}
