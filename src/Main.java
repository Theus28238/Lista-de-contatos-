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
            System.out.println("3 - Procurar contato");
            System.out.println("4 - Excluir contato");
            System.out.println("5- Editar contato");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            opcao = op.nextInt();
            op.nextLine();

            switch (opcao) {
                case 1:
                    agenda.criarContato();
                    agenda.salvarContatoNoArquivo();
                    break;
                case 2:
                    agenda.exibirContatos();

                    break;
                case 3:
                    agenda.buscarContatoPorNome();
                    break;
                case 4:
                ExcluirContato excluir = new ExcluirContato();
                    excluir.excluirPorNome();
                    break;
                case 5:
                    EditarContato editar = new EditarContato();
                    editar.editarContatoPorNome();
                    break;
                case 6:
                    System.out.println("Saindo do aplicativo e salvando os dados. Não desligue a máquina.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);
        
        op.close();
    }
}
