package hades;

import java.util.LinkedList;
import java.util.List;

public abstract class Usuario {

    private long id;
    private String nome;
    private String senha;
    private static List<Cliente> listaClientes = new LinkedList<Cliente>();
    private static List<Gerente> listaGerentes = new LinkedList<Gerente>();
    private static List<Analista> listaAnalistas = new LinkedList<Analista>();
   
    
    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public static void adicionarCliente (Cliente cliente) {
        if(!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        }
    }

    public static void adicionarGerente (Gerente gerente) {
        if(!listaGerentes.contains(gerente)) {
            listaGerentes.add(gerente);
        }
    }

    public static void adicionarAnalista(Analista analista) {
        if(!listaAnalistas.contains(analista)) {
            listaAnalistas.add(analista);
        }
    }
    

    

        
}
