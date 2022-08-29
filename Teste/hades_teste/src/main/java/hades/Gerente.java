package hades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Gerente extends Login { //tabela Gerente possui clientes
    @Id
    @GeneratedValue
    private int id;
    private String cpf;

    private List<Cliente> clientes;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Gerente(){}

    public Gerente(String nome, String senha, String cpf) {
        super(nome, senha);
        this.cpf = cpf;
    }

    public void abrirConta();
    public void fecharConta();
    public void solicitarAnalise(Cliente cliente, Analista analista) {
        analista.analisarTransacoes(cliente);
    }
    
    
}
