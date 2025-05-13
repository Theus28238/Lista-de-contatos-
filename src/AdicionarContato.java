import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class AdicionarContato {
    private String nome;
    private String numero;
    private String email;

    private static ArrayList<AdicionarContato> contatos = new ArrayList<>();


    private static Scanner lerContato = new Scanner(System.in);


    public void adicionarContato() {
        System.out.println("Digite o nome do contato:");
        nome = lerContato.nextLine();

        System.out.println("Digite o número do contato:");
        numero = lerContato.nextLine();

        System.out.println("Digite o email do contato:");
        email = lerContato.nextLine();
    }

    public static void criarContato() {
        AdicionarContato contat = new AdicionarContato();
        contat.adicionarContato();
        contatos.add(contat);
        System.out.println("Seu contato adicionado com sucesso!");
    }

    private static final String caminhoArquivo = "CONTATOS.txt";
    private static final boolean acrescentarNoArquivo = true;

    public static void salvarContatoNoArquivo() {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoArquivo, acrescentarNoArquivo))) {
            for (AdicionarContato con : contatos) {
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

    public static void exibirContatos() {
        if (contatos.isEmpty()) {
                System.out.println("Nenhum contato salvo.");
            } else {
                for (AdicionarContato con : contatos) {
                    System.out.println("Nome: " + con.getNome());
                    System.out.println("Número: " + con.getNumero());
                    System.out.println("Email: " + con.getEmail());
                    System.out.println("---------------------------");
                }
        }

    }


    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
