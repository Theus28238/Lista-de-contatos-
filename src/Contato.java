
import java.util.Scanner;


public class Contato {
    private String nome;
    private String numero;
    private String email;


    private static final Scanner lerContato = new Scanner(System.in);


    public void adicionarContato() {
        System.out.println("Digite o nome do contato:");
        nome = lerContato.nextLine();

        System.out.println("Digite o número do contato:");
        numero = lerContato.nextLine();

        System.out.println("Digite o email do contato:");
        email = lerContato.nextLine();
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
