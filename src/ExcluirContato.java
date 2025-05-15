import java.io.*;
import java.util.Scanner;

public class ExcluirContato {
    Scanner  lerNomeExcluir = new Scanner(System.in);
    private static final String ARQUIVO_CONTATOS = "CONTATOS.txt";

    public void excluirPorNome() {
        
        System.out.print("Digite o nome do contato que deseja excluir: ");
        String nomeParaExcluir = lerNomeExcluir.nextLine().toLowerCase().trim();

        StringBuilder novoConteudo = new StringBuilder();
        

        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_CONTATOS))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.toLowerCase().startsWith("nome: ")) {
                    String nomeAtual = linha.substring(6).toLowerCase().trim();

                    if (nomeAtual.equals(nomeParaExcluir)) {
                        
                        leitor.readLine();
                        leitor.readLine();
                        leitor.readLine();
                        
                        continue; // Não adiciona esse contato ao novo conteúdo
                    }
                }
              
                novoConteudo.append(linha).append("\n");
            
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // Reescreve o arquivo sem o contato removido
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO_CONTATOS, false))) {
            escritor.write(novoConteudo.toString());
            System.out.println("Contato excluído com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

    }
}