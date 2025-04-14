import java.util.Scanner;

public class SistemaLogin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Autenticavel  admin = new Administrador("Fernanda");
        Autenticavel user = new Cliente("João");

        System.out.println("=== LOGIN ADMIN ===");
        System.out.print("Usuário: ");
        String loginAdmin = sc.nextLine();
        System.out.print("Senha: ");
        String senhaAdmin = sc.nextLine();
        admin.autenticar(loginAdmin, senhaAdmin);

        System.out.println("=== LOGIN USER ===");
        System.out.print("Usuário: ");
        String loginUser = sc.nextLine();
        System.out.print("Senha: ");
        String senhaUser = sc.nextLine();
        user.autenticar(loginUser, senhaUser);
    }
}
