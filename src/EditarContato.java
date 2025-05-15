import java.io.*;
import java.util.Scanner;

public class EditarContato {

    private static final String ARQUIVO_CONTATOS = "CONTATOS.txt";

    public void editarContatoPorNome() {
        Scanner lerNomeEditar = new Scanner(System.in);
        System.out.print("Digite o nome do contato que deseja editar: ");
        String nomeProcurado = lerNomeEditar.nextLine().toLowerCase().trim();

        StringBuilder novoConteudo = new StringBuilder();
        boolean contatoEncontrado = false;

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_CONTATOS))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.toLowerCase().startsWith("nome: ")) {
                    String nomeAtual = linha.substring(6).toLowerCase().trim();

                    if (nomeAtual.equals(nomeProcurado)) {
                        contatoEncontrado = true;

                        System.out.println("Contato encontrado!");
                        System.out.print("Novo nome (ou pressione Enter para manter): ");
                        String novoNome = lerNomeEditar.nextLine().trim();
                        if (novoNome.isEmpty()) novoNome = linha.substring(6); // mantém nome atual
                        novoConteudo.append("Nome: ").append(novoNome).append("\n");

                        String numeroLinha = leitor.readLine();
                        System.out.print("Novo número (ou pressione Enter para manter): ");
                        String novoNumero = lerNomeEditar.nextLine().trim();
                        if (novoNumero.isEmpty()) novoNumero = numeroLinha.substring(8); //mantem o número atual
                        novoConteudo.append("Número: ").append(novoNumero).append("\n");

                        String emailLinha = leitor.readLine();
                        System.out.print("Novo e-mail (ou pressione Enter para manter): ");
                        String novoEmail = lerNomeEditar.nextLine().trim();
                        if (novoEmail.isEmpty()) novoEmail = emailLinha.substring(7); //mantem o email atual
                        novoConteudo.append("Email: ").append(novoEmail).append("\n");

                        leitor.readLine(); // pula linha separadora
                        novoConteudo.append("---------------------------\n");

                    } else {
                        // contato diferente, copia normalmente
                        novoConteudo.append(linha).append("\n");
                        novoConteudo.append(leitor.readLine()).append("\n");
                        novoConteudo.append(leitor.readLine()).append("\n");
                        novoConteudo.append(leitor.readLine()).append("\n");
                    }
                } else {
                    novoConteudo.append(linha).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        if (!contatoEncontrado) {
            System.out.println("Contato não encontrado.");
            return;
        }

        // Reescreve o arquivo com as edições
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_CONTATOS))) {
            escritor.write(novoConteudo.toString());
            System.out.println("Contato editado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar alterações: " + e.getMessage());
        }
    }
}
