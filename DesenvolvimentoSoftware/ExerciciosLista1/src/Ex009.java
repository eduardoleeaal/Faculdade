import java.util.Random;
import java.util.Scanner;

public class Ex009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random rand = new Random();
        int numeroAleatorio = rand.nextInt(1, 101);

        int numero;
        do {
            System.out.print("Digite seu palpite: ");
            numero = sc.nextInt();

            if (numero < numeroAleatorio) {
                System.out.println("Muito baixo! Tente um numero maior");
            } else if (numero > numeroAleatorio) {
                System.out.println("Muito baixo! Tente um numero menor");
            } else {
                System.out.println("Parabéns! Você acertou!");
            }

        } while (numero != numeroAleatorio);

        sc.close();

    }
}
