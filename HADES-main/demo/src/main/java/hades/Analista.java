package hades;


import javax.management.InvalidAttributeValueException;
import java.util.LinkedList;
import java.util.List;

public class Analista extends Usuario{
    private String identificador;
    private String resultadoAnalise;
    private static List<Analise> listaAnalises = new LinkedList<Analise>();

    public Analista(){}
    public Analista(String nome, String senha, String identificador) throws Exception {
        super(nome, senha);
        setIdentificador(identificador);
        
    }

    public void analisarTransacoes(Cliente cliente) {
        Analise analise = new Analise(this);
        resultadoAnalise = analise.analisar(cliente);
        System.out.println(resultadoAnalise);
        adicionarAnalise(analise);
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

    public void setIdentificador(String identificador) throws Exception {
        
        if(identificador.matches("\\d{6}")) {
            this.identificador = identificador;
        }
        else {
            throw new InvalidAttributeValueException("Seu identificador deve ser um numero de seis digitos na forma xxxxxx");
        }
    }
        
}
