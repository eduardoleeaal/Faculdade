import java.util.Random;
import java.util.Scanner;

public class Ex010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Escolha (par ou impar): ");
        String escolha = sc.nextLine().toLowerCase();

        System.out.print("Digite um numero: ");
        int numero = sc.nextInt();

        int numAleatorio = rand.nextInt(1, 10);

        int soma = numero + numAleatorio;
        System.out.println("\nO Computador escolheu: " + numAleatorio);

        String resultado;

        if (soma % 2 == 0) {
            System.out.println("Soma: " + soma + " -> Par");
            resultado = "par";
        } else {
            System.out.println("Soma: " + soma + " -> Ímpar");
            resultado = "impar";
        }

        if (escolha.equals(resultado)) {
            System.out.println("Você VENCEU!");
        } else {
            System.out.println("Você PERDEU!");
        }

        sc.close();
    }
}
