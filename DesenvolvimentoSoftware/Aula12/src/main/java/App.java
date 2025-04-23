import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario("Usuário");

        while(true){
            System.out.print("Digite o login: ");
            String login = sc.nextLine();
            System.out.print("Digite a senha: ");
            String senha = sc.nextLine();

            try {
                usuario.autenticar(login, senha);
            } catch (TentativasExcedidasException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
