// AULA 03
import java.util.Scanner;

public class LeituraDeDados {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número inteiro: ");
        int inteiro = sc.nextInt();

        System.out.println("Digite um número decimal: ");
        double decimal = sc.nextDouble();

        System.out.println("Digite uma palavra: ");
        String palavra = sc.next();

        sc.nextLine(); // limpeza de buffer
        System.out.println("Digite uma frase: ");
        String frase = sc.nextLine();

        System.out.println("Você digitou o número inteiro: " + inteiro);
        System.out.println("Você digitou o número decimal: " + decimal);
        System.out.println("Você digitou a palavra: " + palavra);
        System.out.println("Você digitou a frase: " + frase);

        sc.close();
    }
}
