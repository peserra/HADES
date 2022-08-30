package hades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Banco_de_Dados {

    private String diretorio = System.getProperty("user.dir");
        
    public Banco_de_Dados(List<Cliente> listaClientes,List<Gerente> listaGerentes, List<Analista> listaAnalistas,List<Analise> listaAnalise){
    
    File dir = new File(diretorio);
    File movimentacoes = new File(dir, "Movimentacoes.txt");
    File clientes = new File(dir, "clientes.txt");
    File gerentes = new File(dir, "gerentes.txt");
    File analistas= new File(dir, "analistas.txt");
    File analises = new File(dir, "analises.txt");
    try {

        //neste ponto criamos o arquivo fisicamente
        movimentacoes.createNewFile();
        clientes.createNewFile();
        gerentes.createNewFile();
        analistas.createNewFile();
        analises.createNewFile();

 
        FileWriter fileWriterClientes = new FileWriter(clientes, true);
        FileWriter fileWriterGerentes= new FileWriter(gerentes, true);
        FileWriter fileWriterAnalistas = new FileWriter(analistas, true);
        FileWriter fileWriterMovimentacoes = new FileWriter(movimentacoes, true);
        FileWriter fileWriterAnalises = new FileWriter(analises, true);


        PrintWriter printWriterClientes = new PrintWriter(fileWriterClientes);
        PrintWriter printWriterGerentes = new PrintWriter(fileWriterGerentes);
        PrintWriter printWriterAnalistas = new PrintWriter(fileWriterAnalistas);
        PrintWriter printWriterMovimentacoes= new PrintWriter(fileWriterMovimentacoes);
        PrintWriter printWriterAnalises = new PrintWriter(fileWriterAnalises);

        //Agora vamos escrever no arquivo com o método  println(),
        // que nos permite escrever linha a linha no arquivo
        for(Cliente cliente : listaClientes){
        printWriterClientes.print(cliente.getNome()+ ";");    
        printWriterClientes.print(cliente.getCnpj()+ ";");
        printWriterClientes.print(cliente.getFaturamento()+";");
        printWriterClientes.print(cliente.getRisco()+";\n");
        }

        for(Gerente gerente : listaGerentes){
            printWriterGerentes.print(gerente.getNome()+ ";");    
            printWriterGerentes.print(gerente.getIdentificador()+ ";\n");
            }

        for(Analista analista : listaAnalistas){
            printWriterAnalistas.print(analista.getNome()+ ";");    
            printWriterAnalistas.print(analista.getIdentificador()+ ";\n");
            }
        for(Analise analise : listaAnalise){
            printWriterAnalises.print(analise.getCliente().getNome()+ ";");
            printWriterAnalises.print(analise.getAnalista().getNome()+ ";");   
            printWriterAnalises.print(analise.getResultado() + ";\n");
            }
        for(Cliente cliente: listaClientes) {
            
            for(Transacao transacao: cliente.getTransacoesMes()) {
                printWriterMovimentacoes.print(cliente.getNome() + ";" + cliente.getCnpj() + ";" + transacao.getValor() + ";\n");
            }
            printWriterMovimentacoes.println();
        }
    


        //o método flush libera a escrita no arquivo
        printWriterClientes.flush();
        printWriterAnalistas.flush();
        printWriterAnalises.flush();
        printWriterGerentes.flush();
        printWriterMovimentacoes.flush();

        //No final precisamos fechar o arquivo
        printWriterClientes.close();
        printWriterAnalistas.close();
        printWriterAnalises.close();
        printWriterGerentes.close();
        printWriterMovimentacoes.close();

    } catch (IOException e) {
        e.printStackTrace();
    }

    }


    //boolean exists = arquivo.exists();




}
