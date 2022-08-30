package hades;

import javax.management.InvalidAttributeValueException;

public class Gerente extends Usuario {
    private String identificador;

    public Gerente() {
    }

    public Gerente(String nome, String senha, String identificador) throws Exception {
        super(nome, senha);
        setIdentificador(identificador);

    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) throws Exception {

        if (identificador.matches("\\d{6}")) {
            this.identificador = identificador;
        } else {
            throw new InvalidAttributeValueException(
                    "Seu identificador deve ser um numero de seis digitos na forma xxxxxx");
        }
    }

    public void solicitarAnalise(String cnpj) {
        Usuario cliente = Usuario.isAnaliseOk(cnpj);
        int indiceAnalista = buscaAnalistaAleatorio();
        if (indiceAnalista < 0) {
            System.out.println("Nenhum analista cadastrado ainda! Impossivel solicitar analise");
        } else {
            Usuario analistaRetornado = Usuario.getListaAnalistas().get(indiceAnalista);
            if (Usuario.getListaClientes().contains(cliente)) {
                ((Analista)analistaRetornado).solicitarAnalise((Cliente)cliente, this);
            }
        }

    }

    private int buscaAnalistaAleatorio() {
        
        if (!Usuario.getListaAnalistas().isEmpty()) {
            
            return (int)Math.floor((Math.random() * Usuario.getListaAnalistas().size()));// retorna um inteiro aleatorio para ser
                                                                             // indice de busca de analista
        }

        return -1;
    }

}
