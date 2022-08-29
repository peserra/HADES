package hades;

import java.util.Scanner;



public class App 
{
    public static void main( String[] args )
    {
        int telaInicial;
        int escolhaCadastro;
        int escolhaLogin;
        Cliente cliente;
        Gerente gerente;
        
        System.out.println("Bem vindo ao HADES! Selecione uma das funções abaixo?\n1 - Cadastrar\n2 - Fazer Login");

        Scanner input = new Scanner(System.in);
        telaInicial = input.nextInt();
        
        switch(telaInicial) {
            case 1:
                System.out.println("Que tipo de cadastro deseja fazer?\n1 - Cliente\n2 - Gerente\n3 - Analista");
                escolhaCadastro = input.nextInt();
                switch(escolhaCadastro) {
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
                            
                        } catch (Exception e) {
                            
                            System.out.println(e.getMessage() + "Cadastro cancelado");
                        }
                        break;
                              
                    case 2:
                        try {
                            System.out.println("Insira os seus dados abaixo");
                        
                            System.out.println("Digite seu nome: ");
                            String nomeCliente = input.next();
                        
                            System.out.println("Escolha uma senha: ");
                            String senhaCliente = input.next();
                            
                            System.out.println("Insira o Id pessoal: ");
                            String id = input.next();
                                                     
                        

                            gerente = new Gerente(nomeCliente, senhaCliente, id);
                            Usuario.adicionarGerente(gerente);
                            
                        } catch (Exception e) {
                            
                            System.out.println(e.getMessage() + "Cadastro cancelado");
                        }
                        break;
                                                
                }
                
        }
        
    }
       
}

