import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner op = new Scanner(System.in);
        int opcao;
        Agenda agenda = new Agenda();

        System.out.println("=========================================");
        System.out.println("=========================================");
        System.out.println("Bem vindo ao seu aplicativo de contatos!");
        System.out.println("=========================================");
        System.out.println("------- o que você deseja fazer? --------");
        System.out.println("=========================================");


        do {
            System.out.println("\n1 - Adicionar contato");
            System.out.println("2 - Ver contatos");
            System.out.println("3 - Sair e salvar");
            System.out.print("Escolha: ");
            opcao = op.nextInt();
            op.nextLine();

            switch (opcao) {
                case 1:
                    agenda.criarContato();
                    break;
                case 2:
                    agenda.exibirContatos();
                    break;
                case 3:
                    System.out.println("Saindo e salvando...");
                    agenda.salvarContatoNoArquivo();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 3);

        op.close();
    }
}
