package hades;

import java.util.Scanner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        int telaInicial;
        int escolhaCadastro;
        int escolhaLogin;
        boolean execute = true;
        Usuario usuario = null;
        String user;
        String senha;
        Cliente cliente;
        Gerente gerente;
        Analista analista;
        System.out.println("----------------------------------------------");
        System.out.println(
                "\t\tBem vindo ao HADES!");
        while (execute) {
            System.out.println("----------------------------------------------");
            System.out.println(
                    "\t\tMENU\nSelecione uma das funções abaixo:\n1 - Cadastrar\n2 - Fazer Login\n3 - sair");
            System.out.print("Escolha do Usuario: ");
            Scanner input = new Scanner(System.in);

            telaInicial = input.nextInt();
            System.out.println("----------------------------------------------");
            switch (telaInicial) {
                case 1:
                    System.out.println("Selecione um tipo de cadastro:\n1 - Cliente\n2 - Gerente\n3 - Analista");
                    System.out.print("Escolha do Usuario: ");
                    escolhaCadastro = input.nextInt();
                    System.out.println("----------------------------------------------");
                    switch (escolhaCadastro) {
                        case 1:
                            try {
                                System.out.println("\t\tCadastro Cliente");
                                System.out.println("Insira os seus dados abaixo");

                                System.out.println("Digite seu primeiro nome: ");
                                String nomeCliente = input.next();

                                System.out.println("Escolha uma senha: ");
                                String senhaCliente = input.next();

                                System.out.println("CNPJ: ");
                                String cnpj = input.next();

                                System.out.println("Faturamento: ");
                                double faturamento = input.nextDouble();

                                cliente = new Cliente(nomeCliente, senhaCliente, cnpj, faturamento);
                                Usuario.adicionarCliente(cliente);
                                System.out.println(
                                        "Cadastro do cliente " + cliente.getNome() + " realizado com sucesso!");

                            } catch (Exception e) {

                                System.out.println(e.getMessage() + " Cadastro cancelado");
                            }
                            System.out.println("----------------------------------------------");
                            break;

                        case 2:
                            try {
                                System.out.println("\t\tCadastro Gerente");
                                System.out.println("Insira os seus dados abaixo");

                                System.out.println("Digite seu primeiro nome: ");
                                String nomeGerente = input.next();

                                System.out.println("Escolha uma senha: ");
                                String senhaGerente = input.next();

                                System.out.println("Insira o Id pessoal: ");
                                String id = input.next();

                                gerente = new Gerente(nomeGerente, senhaGerente, id);
                                Usuario.adicionarGerente(gerente);
                                System.out.println(
                                        "Cadastro do gerente " + gerente.getNome() + " realizado com sucesso!");

                            } catch (Exception e) {

                                System.out.println(e.getMessage() + " Cadastro cancelado");
                            }
                            System.out.println("----------------------------------------------");
                            break;
                        case 3:
                            try {
                                System.out.println("\t\tCadastro Analista");
                                System.out.println("Insira os seus dados abaixo");

                                System.out.println("Digite seu primeiro nome: ");
                                String nomeAnalista = input.next();

                                System.out.println("Escolha uma senha: ");
                                String senhaAnalista = input.next();

                                System.out.println("Insira o Id pessoal: ");
                                String id = input.next();

                                analista = new Analista(nomeAnalista, senhaAnalista, id);
                                Usuario.adicionarAnalista(analista);
                                System.out.println(
                                        "Cadastro do analista " + analista.getNome() + " realizado com sucesso!");

                            } catch (Exception e) {

                                System.out.println(e.getMessage() + " Cadastro cancelado");
                            }
                            System.out.println("----------------------------------------------");
                            break;

                    }
                    break;
                case 2:
                    System.out.println("\t\tMenu de Login");
                    System.out.println("Que tipo de login deseja fazer?\n1 - Cliente\n2 - Gerente\n3 - Analista");
                    System.out.print("Escolha do Usuario: ");
                    escolhaLogin = input.nextInt();
                    System.out.println("----------------------------------------------");
                    switch (escolhaLogin) {

                        case 1:// login cliente
                            System.out.println("\t\tLogin do Cliente");
                            System.out.println("Digite seu CNPJ: "); // XX.XXX.XXX/0001-XX 11.111.111/0001-11
                            user = input.next();
                            System.out.println("Digite sua Senha: ");
                            senha = input.next();
                            // usuario é um cliente, nesse caso
                            usuario = Usuario.isCadastroOk(user, senha, "Cliente");
                            boolean transferindo = true;
                            int escolha;
                            
                            if (usuario != null) {
                                while (transferindo) {
                                    System.out.println("\t\tTransação");
                                    System.out.println("1 - Nova transação\n2 - Cancelar");
                                    System.out.print("Escolha do Usuario: ");
                                    escolha = input.nextInt();
                                    System.out.println("----------------------------------------------");
                                    if (Integer.toString(escolha).matches("\\d{1}")) {
                                        if (escolha == 1) {
                                            ((Cliente) usuario).realizarTransacao();
                                        } else if (escolha == 2) {
                                            transferindo = false;
                                        } else if (escolha != 1) {
                                            System.out.println("Operação invalida");
                                            continue;
                                        }

                                    } else {
                                        System.out.println("Apenas um digito é aceito como resposta!");
                                    }
                                    System.out.println("----------------------------------------------");
                                }
                            }
                            break;

                        case 2:// login gerente
                            boolean gerenciando = true;
                            System.out.println("Digite seu Identificador: ");
                            user = input.next();
                            System.out.println("Digite sua Senha: ");
                            senha = input.next();
                            // usuario é um gerente, nesse caso
                            usuario = Usuario.isCadastroOk(user, senha, "Gerente");

                            if (usuario != null) {
                                while (gerenciando) {
                                    // ((Cliente)usuario).realizarTransacao();
                                    System.out.println(
                                            "Escolha uma ação\n1 - Adicionar risco e paraiso\n2 - Solicitar analise\n3 - Sair");
                                    System.out.print("Escolha do Usuario: ");
                                    escolha = input.nextInt();
                                    System.out.println("----------------------------------------------");
                                    if (Integer.toString(escolha).matches("\\d{1}")) {
                                        String cnpj;
                                        if (escolha == 1) {
                                            System.out.println("\t\tClassificação de Risco e Paraíso Fiscal");
                                            System.out.println("Digite o cnpj do cliente que deseja classificar: ");
                                            cnpj = input.next();
                                            Usuario clienteAnalisado = Usuario.isAnaliseOk(cnpj);
                                            System.out.println("Qual o risco do cliente?(alto/medio/baixo): ");
                                            String risco = input.next();
                                            ((Cliente) clienteAnalisado).setRisco(risco);
                                            System.out.println("Cliente reside em paraíso fiscal?(true/false):");
                                            boolean paraiso = input.nextBoolean();
                                            ((Cliente) clienteAnalisado).setParaiso(paraiso);
                                            System.out.println("----------------------------------------------");

                                        } else if (escolha == 2) {
                                            System.out.println("\t\tSolicitação de Analise");
                                            System.out.println("Digite o cnpj do cliente que necessita de analise: ");
                                            cnpj = input.next();
                                            ((Gerente) usuario).solicitarAnalise(cnpj);
                                            System.out.println("----------------------------------------------");

                                        } else if (escolha == 3) {
                                            gerenciando = false;
                                        } else {
                                            System.out
                                                    .println(
                                                            "Opção invalida.\n1 - Adicionar risco e paraiso\n2 - Solicitar analise\n3 - Sair");

                                        }
                                    } else {
                                        System.out.println("Apenas um digito é aceito como resposta!");
                                    }
                                    
                                }
                            }

                            break;

                        case 3:// login analista
                            boolean analisando = true;
                            System.out.println("Digite seu Identificador: ");
                            user = input.next();
                            System.out.println("Digite sua Senha: ");
                            senha = input.next();
                            // usuario é um analista, nesse caso
                            usuario = Usuario.isCadastroOk(user, senha, "Analista");

                            if (usuario != null) {
                                while (analisando) {
                                    // ((Cliente)usuario).realizarTransacao();
                                    System.out.println("Escolha uma ação \n1 - Iniciar análise\n2 - Sair");
                                    System.out.print("Escolha do Usuario: ");
                                    escolha = input.nextInt();
                                    System.out.println("----------------------------------------------");
                                    if (Integer.toString(escolha).matches("\\d{1}")) {

                                        if (escolha == 1) {
                                            // Analise analise = new Analise((Analista) usuario);
                                            // String cnpj;
                                            // System.out.println("Digite o cnpj do cliente para analisar: ");
                                            // cnpj = input.next();
                                            // Usuario clienteAnalisado = Usuario.isAnaliseOk(cnpj);
                                            // analise.analisar((Cliente) clienteAnalisado);
                                            ((Analista) usuario).executarAnalise();
                                        }
                                        if (escolha == 2) {
                                            analisando = false;
                                        } else if (escolha != 1) {
                                            System.out.println("Opção invalida.\n1 - Solicitar analise\n2 - Sair");
                                        }
                                    } else {
                                        System.out.println("Apenas um numero é aceito como resposta");
                                    }
                                }
                            }
                            break;

                    }
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar o Hades");
                    System.out.println("----------------------------------------------");
                    List<Cliente> listaClientes = Usuario.getListaClientes();
                    List<Gerente> listaGerentes = Usuario.getListaGerentes();
                    List<Analista> listaAnalistas = Usuario.getListaAnalistas();
                    List<Analise> listaAnalises = Analista.getListaAnalises();

                    Banco_de_Dados bd = new Banco_de_Dados(listaClientes, listaGerentes, listaAnalistas, listaAnalises);
                    execute = false;
                    input.close();

            }

        }

    }

}
