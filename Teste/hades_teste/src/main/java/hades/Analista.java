package hades;



import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Persistence;

@Entity
public class Analista extends Login {
    @Id
    @GeneratedValue
    private long id;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager em = emf.createEntityManager();
    private String resultadoAnalise;
    
         

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public Analista (String login, String senha) {
        super(login, senha);
    }
    // Gerente > analista.executarAnalise(cliente)
    public void analisarTransacoes(Cliente cliente) { // cria uma instancia de analise e executa a analise
        Analise analise = new Analise(this, cliente);
        resultadoAnalise = analise.analisar(cliente);
        System.out.println(resultadoAnalise);
        
    }

    public void bloquearConta(Conta conta) {
        try {
            if (!conta.isBloqueada()) {
                conta.setBloqueada(true);
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            
        }


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
    
}
