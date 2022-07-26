package hades;

import java.util.Scanner;



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
            System.out.println("Bem vindo ao HADES! Selecione uma das funções abaixo:\n1 - Cadastrar\n2 - Fazer Login\n3 - sair");

            Scanner input = new Scanner(System.in);
            
            telaInicial = input.nextInt();

            switch (telaInicial) {
                case 1:
                    System.out.println("Selecione um tipo de cadastro:\n1 - Cliente\n2 - Gerente\n3 - Analista");
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

                                /*System.out.println("Risco: ");
                                String risco = input.next();

                                System.out.println("Você reside em paraíso fiscal? 1 - sim ; 0 - não ");
                                boolean paraiso = input.nextBoolean();*/


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
                            System.out.println("Digite seu cnpj: "); // XX.XXX.XXX/0001-XX 11.111.111/0001-11
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
                            break;

                        case 2:// login gerente
                        boolean gerenciando = true;
                            System.out.println("Digite seu Identificador: ");
                            user = input.next();
                            System.out.println("Digite sua senha: ");
                            senha = input.next();
                            usuario = Usuario.isCadastroOk(user, senha, "Gerente");

                            if(usuario != null) {
                                while(gerenciando) {
                                    //((Cliente)usuario).realizarTransacao();
                                    System.out.println("Escolha uma ação \n1 - setar risco e paraiso 2- Sair");
                                    escolha = input.nextInt();
                                   if(Integer.toString(escolha).matches("\\d{1}")) {
    
                                        if(escolha == 1){
                                            String cnpj;
                                            System.out.println("Digite o cnpj do cliente para analisar: ");
                                            cnpj = input.next();
                                            Usuario clienteAnalisado = Usuario.isAnaliseOk(cnpj);
                                            System.out.println("Risco: ");
                                            String risco = input.next();
                                            ((Cliente)clienteAnalisado).setRisco(risco);
                                            System.out.println("Cliente reside em paraíso fiscal? true ou false ");
                                            boolean paraiso = input.nextBoolean();
                                            ((Cliente)clienteAnalisado).setParaiso(paraiso);

                                        }
                                        if(escolha == 2) {
                                            gerenciando = false;
                                        } else if (escolha != 1) {
                                            System.out.println("Opção invalida.\n1 - Solicitar analise 2- Sair");
                                        }
                                   } else {
                                    System.out.println("Apenas um numero é aceito como resposta");
                                   }
                                }
                            }

                            break;

                        case 3:// login analista
                        boolean analisando = true;
                        System.out.println("Digite seu Identificador: ");
                        user = input.next();
                        System.out.println("Digite sua senha: ");
                        senha = input.next();
                        usuario = Usuario.isCadastroOk(user, senha, "Analista");

                        if(usuario != null) {
                            while(analisando) {
                                //((Cliente)usuario).realizarTransacao();
                                System.out.println("Escolha uma ação \n1 - iniciar analise 2- Sair");
                                escolha = input.nextInt();
                               if(Integer.toString(escolha).matches("\\d{1}")) {

                                    if(escolha == 1){
                                        Analise analise = new Analise((Analista)usuario);
                                        String cnpj;
                                        System.out.println("Digite o cnpj do cliente para analisar: ");
                                        cnpj = input.next();
                                        Usuario clienteAnalisado = Usuario.isAnaliseOk(cnpj);
                                        analise.analisar((Cliente)clienteAnalisado);
                                    }
                                    if(escolha == 2) {
                                        analisando = false;
                                    } else if (escolha != 1) {
                                        System.out.println("Opção invalida.\n1 - Solicitar analise 2- Sair");
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
                    execute = false;
                    input.close();

            }

        }

    }

}
