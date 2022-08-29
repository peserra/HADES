package hades;

import javax.management.InvalidAttributeValueException;

public class Analista extends Usuario{
    private String identificador;
    private String resultadoAnalise;

    public Analista(){}
    public Analista(String nome, String senha, String identificador) throws Exception {
        super(nome, senha);
        setIdentificador(identificador);
        
    }

    public void analisarTransacoes(Cliente cliente) {
        Analise analise = new Analise(this);
        resultadoAnalise = analise.analisar(cliente);
        System.out.println(resultadoAnalise);
    }

    public String getIdentificador() {
        return identificador;
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
