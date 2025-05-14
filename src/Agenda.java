import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    private final static ArrayList<Contato> contatos = new ArrayList<Contato>();
    Scanner lerScanner = new Scanner(System.in);
    // Criação de contato na classe Agenda
    public void criarContato(){
        Contato contato = new Contato();
        contato.adicionarContato();
        contatos.add(contato);
        System.out.println("Seu contato adicionado com sucesso!");
    }
        

    // Constantes para ser usadas
    private static final String arquivoNovo = "CONTATOS.txt";
    private static final boolean acrescentarNoArquivo = true;

    public void salvarContatoNoArquivo() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoNovo, acrescentarNoArquivo))) {
            for (Contato con : contatos) {
                escritor.write("Nome: " + con.getNome() + "\n");
                escritor.write("Número: " + con.getNumero() + "\n");
                escritor.write("Email: " + con.getEmail() + "\n");
                escritor.write("---------------------------\n");
            }
            System.out.println("Salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o contato no arquivo: " + e.getMessage());
        }
    }

    public static final String caminhoDoArquivo = "CONTATOS.txt";

    public void exibirContatos(){
        try (BufferedReader leitura = new BufferedReader(new FileReader(caminhoDoArquivo))) {
            StringBuilder agendaGeral = new StringBuilder();
            String linhaLer = leitura.readLine();
            while (linhaLer != null){
                agendaGeral.append(linhaLer).append("\n");
                linhaLer = leitura.readLine();
            }
            System.out.println(agendaGeral.toString());
        } catch (Exception e){
            System.out.println("Erro ao ler o Arquivo" + e.getMessage());
        }
    }


    //MÉTODO PARA PROCURAR CONTATOS
    public void buscarContatoPorNome() {
        String procurar;
        System.out.println("Digite o contato que queria procurar");
        procurar = lerScanner.next().toLowerCase().trim();
        try (BufferedReader leituraDoArquivo = new BufferedReader(new FileReader(caminhoDoArquivo))){
            String linhaler = leituraDoArquivo.readLine().toLowerCase();
            while (linhaler != null){
            if (linhaler.startsWith("Nome: ")){
                String nome = linhaler.substring(5).toLowerCase().trim();
                    if (nome.equals(procurar)){
                        System.out.println(linhaler);
                        System.out.println(leituraDoArquivo.readLine());
                        System.out.println(leituraDoArquivo.readLine());
                        System.out.println(leituraDoArquivo.readLine());
                        return;
                    }
                }
                linhaler = leituraDoArquivo.readLine();
            }



        } catch (Exception e) {
            System.out.println("Erro ao ler o Arquivo" + e.getMessage());
        }
}


}
