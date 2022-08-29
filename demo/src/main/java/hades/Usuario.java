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
    private static Usuario cadastroOk;

    public Usuario() {
    }

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

    public static void adicionarCliente(Cliente cliente) {
        if (!listaClientes.contains(cliente)) {
            listaClientes.add(cliente);
        }
    }

    public static void adicionarGerente(Gerente gerente) {
        if (!listaGerentes.contains(gerente)) {
            listaGerentes.add(gerente);
        }
    }

    public static void adicionarAnalista(Analista analista) {
        if (!listaAnalistas.contains(analista)) {
            listaAnalistas.add(analista);
        }
    }

    public static List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public static void setListaClientes(List<Cliente> listaClientes) {
        Usuario.listaClientes = listaClientes;
    }

    public static List<Gerente> getListaGerentes() {
        return listaGerentes;
    }

    public static void setListaGerentes(List<Gerente> listaGerentes) {
        Usuario.listaGerentes = listaGerentes;
    }

    public static List<Analista> getListaAnalistas() {
        return listaAnalistas;
    }

    public static void setListaAnalistas(List<Analista> listaAnalistas) {
        Usuario.listaAnalistas = listaAnalistas;
    }

    public static Usuario isCadastroOk(String login, String senha, String entidade) {
        cadastroOk = verificaCadastro(login, senha, entidade);
        if (cadastroOk != null) {
            System.out.println("Usuario encontrado! Conectando...");
        } else {
            System.out.println("Usuario não encontrado, retornando para tela inicial");
        }
        return cadastroOk;
    }

    private static Usuario verificaCadastro(String login, String senha, String entidadeBuscada) {

        switch (entidadeBuscada.toUpperCase()) {
            case "CLIENTE":
                if (!listaClientes.isEmpty()) {
                    for (Cliente cliente : listaClientes) {
                        if ((cliente.getCnpj() == login) && (cliente.getSenha() == senha)) {
                            return cliente;
                        }
                    }
                }
                break;
            case "GERENTE":
                if (!listaGerentes.isEmpty()) {
                    for (Gerente gerente : listaGerentes) {
                        if (gerente.getIdentificador() == login && gerente.getSenha() == senha) {
                            return gerente;
                        }
                    }
                }
                break;
            case "ANALISTA":
                if (!listaAnalistas.isEmpty()) {
                    for (Analista analista : listaAnalistas) {
                        if (analista.getIdentificador() == login && analista.getSenha() == senha) {
                            return analista;
                        }
                    }
                }
                break;
        }

        return null;
    }

}
