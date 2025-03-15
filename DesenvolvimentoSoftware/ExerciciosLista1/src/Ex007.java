import java.util.Scanner;

public class Ex007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // (100, 50, 20, 10, 5, 2, 1)
        int notas100, notas50, notas20, notas10, notas5, notas2, notas1;
        System.out.print("Digite o valor do Saque: ");
        int saque = sc.nextInt();

        notas100 = saque / 100;
        saque %= 100;

        notas50 = saque / 50;
        saque %= 50;

        notas20 = saque / 20;
        saque %= 20;

        notas10 = saque / 10;
        saque %= 10;

        notas5 = saque / 5;
        saque %= 5;

        notas2 = saque / 2;
        saque %= 2;

        notas1 = saque;


        System.out.println("Notas de 100: " + notas100);
        System.out.println("Notas de 50: " + notas50);
        System.out.println("Notas de 20: " + notas20);
        System.out.println("Notas de 10: " + notas10);
        System.out.println("Notas de 5: " + notas5);
        System.out.println("Notas de 2: " + notas2);
        System.out.println("Notas de 1: " + notas1);
        sc.close();
    }
}
