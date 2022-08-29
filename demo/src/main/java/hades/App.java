package hades;

import java.util.Scanner;

import javax.swing.SwingConstants;

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
        while (execute) {
            System.out.println("Bem vindo ao HADES! Selecione uma das funções abaixo?\n1 - Cadastrar\n2 - Fazer Login\n3 - sair");

            Scanner input = new Scanner(System.in);
            telaInicial = input.nextInt();

            switch (telaInicial) {
                case 1:
                    System.out.println("Que tipo de cadastro deseja fazer?\n1 - Cliente\n2 - Gerente\n3 - Analista");
                    escolhaCadastro = input.nextInt();
                    switch (escolhaCadastro) {
                        case 1:
                            try {
                                System.out.println("Insira os seus dados abaixo");

                                System.out.println("Digite seu nome: ");
                                String nomeCliente = input.next();

                                System.out.println("Escolha uma senha: ");
                                String senhaCliente = input.next();

                                System.out.println("CNPJ: ");
                                String cnpj = input.next();

                                System.out.println("Faturamento: ");
                                double faturamento = input.nextDouble();

                                cliente = new Cliente(nomeCliente, senhaCliente, cnpj, faturamento);
                                Usuario.adicionarCliente(cliente);
                                System.out.println("Cadastro do cliente " + cliente.getNome() + " realizado com sucesso!");
                                
                                

                            } catch (Exception e) {

                                System.out.println(e.getMessage() + " Cadastro cancelado");
                            }
                            break;

                        case 2:
                            try {
                                System.out.println("Insira os seus dados abaixo");

                                System.out.println("Digite seu nome: ");
                                String nomeGerente = input.next();

                                System.out.println("Escolha uma senha: ");
                                String senhaGerente = input.next();

                                System.out.println("Insira o Id pessoal: ");
                                String id = input.next();

                                gerente = new Gerente(nomeGerente, senhaGerente, id);
                                Usuario.adicionarGerente(gerente);
                                System.out.println("Cadastro do gerente " + gerente.getNome() + " realizado com sucesso!");

                            } catch (Exception e) {

                                System.out.println(e.getMessage() + " Cadastro cancelado");
                            }
                            break;
                        case 3:
                            try {
                                System.out.println("Insira os seus dados abaixo");

                                System.out.println("Digite seu nome: ");
                                String nomeAnalista = input.next();

                                System.out.println("Escolha uma senha: ");
                                String senhaAnalista = input.next();

                                System.out.println("Insira o Id pessoal: ");
                                String id = input.next();

                                analista = new Analista(nomeAnalista, senhaAnalista, id);
                                Usuario.adicionarAnalista(analista);
                                System.out.println("Cadastro do analista " + analista.getNome() + " realizado com sucesso!");


                            } catch (Exception e) {

                                System.out.println(e.getMessage() + " Cadastro cancelado");
                            }
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Que tipo de login deseja fazer?\n1 - Cliente\n2 - Gerente\n3 - Analista");
                    escolhaLogin = input.nextInt();
                    
                    switch (escolhaLogin) {
                        
                        case 1:// login cliente
                            System.out.println("Digite seu cnpj: ");
                            user = input.next();
                            System.out.println("Digite sua senha: ");
                            senha = input.next();
                            usuario = Usuario.isCadastroOk(user, senha, "Cliente");
                            boolean transferindo = true;
                            int escolha;
                            if(usuario != null) {
                                while(transferindo) {
                                    ((Cliente)usuario).realizarTransacao();
                                    System.out.println("Transação realizada com sucesso!\n1 - Nova transação\n2 - Cancelar");
                                    escolha = input.nextInt();
                                   if(Integer.toString(escolha).matches("\\d{1}")) {
                                        if(escolha == 2) {
                                            transferindo = false;
                                        } else if (escolha != 1) {
                                            System.out.println("Opção invalida.\n1 - Nova transação\n2 - Cancelar");
                                        }
                                   } else {
                                    System.out.println("Apenas um numero é aceito como resposta");
                                   }
                                }
                            }

                        case 2:// login gerente
                        case 3:// login analista

                    }
                    break;
                case 3:
                    System.out.println("Obrigado por utilizar o Hades");
                    execute = false;

            }

        }

    }

}
