package hades;




public class Login {
    private String nome;
    private String senha;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Login(){};

    public Login(String nome, String senha) {
        try {
            if(verificaAcesso(nome, senha)) {
                this.nome = nome;
                this.senha = senha;
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    private boolean verificaAcesso(String login, String senha) {
        //buscar no BD login e senha, se bater retorna trueD
        //find
        return true;
    }
    
}
