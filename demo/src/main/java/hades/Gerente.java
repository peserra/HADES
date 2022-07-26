package hades;

import javax.management.InvalidAttributeValueException;

public class Gerente extends Usuario {
    private String identificador;

    public Gerente(){}
    public Gerente(String nome, String senha, String identificador) throws Exception {
        super(nome, senha);
        setIdentificador(identificador);
             
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
