package hades;

import java.util.Scanner;

/**
 * Hades app 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int telaInicial;
        int escolhaCadastro;
        int escolhaLogin;
        Cliente cliente;
        System.out.println("Bem vindo ao HADES! Selecione uma das funções abaixo?\n1 - Cadastrar\n2 - Fazer Login");

        Scanner input = new Scanner(System.in);
        telaInicial = input.nextInt();
        
        switch(telaInicial) {
            case 1:
                System.out.println("Que tipo de cadastro deseja fazer?\n1 - Cliente\n2 - Gerente\n3 - Analista");
                escolhaCadastro = input.nextInt();
                switch(escolhaCadastro) {
                    case 1:
                        System.out.println("Insira os seus dados abaixo");
                        cliente = new Cliente();
                        System.out.println("Digite seu nome: ");
                        String nomeCliente = input.next();
                        cliente.setNome(nomeCliente);

                        System.out.println("Escolha uma senha: ");
                        String senhaCliente = input.next();
                        cliente.setSenha(senhaCliente);

                        System.out.println("CNPJ: ");
                        String cnpj = input.next();
                        cliente.setCnpj(cnpj);

                        System.out.println("Faturamento: ");
                        double faturamento = input.nextDouble();
                        cliente.setFaturamento(faturamento);
                                            
                        
                }
                
        }
        
    }
}
