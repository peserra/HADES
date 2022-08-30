package hades;


import javax.management.InvalidAttributeValueException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Analista extends Usuario{
    private String identificador;
    private String resultadoAnalise;
    private Queue<Cliente> analisesSolicitadas = new LinkedList<Cliente>();
    private static List<Analise> listaAnalises = new LinkedList<Analise>();

    public Analista(){}
    public Analista(String nome, String senha, String identificador) throws Exception {
        super(nome, senha);
        setIdentificador(identificador);
        
    }
    public void executarAnalise() {
        Cliente cliente = analisesSolicitadas.remove();
        analisarTransacoes(cliente);
    }

    private void analisarTransacoes(Cliente cliente) {
        Analise analise = new Analise(this);
         //resultadoAnalise = analise.analisar(cliente);
        if (cliente != null) {
            resultadoAnalise = analise.analisar(cliente);
            System.out.println(resultadoAnalise);
            adicionarAnalise(analise);
        } else {
            System.out.println("Sem clientes para analisar no momento");
        }
        
    }
    
    public static void adicionarAnalise(Analise analise) {
        if (!listaAnalises.contains(analise)) {
            listaAnalises.add(analise);
        }
    }

    public String getIdentificador() {
        return identificador;
    }

    public static List<Analise> getListaAnalises() {
        return listaAnalises;
    }

    public Queue<Cliente> getAnalisesSolicitadas() {
        return analisesSolicitadas;
    }

    public void setIdentificador(String identificador) throws Exception {
        
        if(identificador.matches("\\d{6}")) {
            this.identificador = identificador;
        }
        else {
            throw new InvalidAttributeValueException("Seu identificador deve ser um numero de seis digitos na forma xxxxxx");
        }
    }
    
    public void solicitarAnalise(Cliente cliente, Gerente gerente) {
        boolean adicionado = false;
        if(gerente != null && cliente != null) {
            adicionado = addSolicitacao(cliente);
            if(adicionado) {
                System.out.println("Solicitação de analise realizada");
            } else {
                System.out.println("Cliente não encontrado, não foi possível analsar");
            }
              
        }
        
    }

    private boolean addSolicitacao(Cliente cliente) {
        if(cliente != null) {
            analisesSolicitadas.add(cliente);
            return true;
        }
        return false;
    }
        
}
