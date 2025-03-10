import java.util.Scanner;

public class OperadoresRelacionais {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int num1 = sc.nextInt();

        System.out.print("Digite o segundo número: ");
        int num2 = sc.nextInt();

        System.out.println("O primeiro número é maior que o segundo? " + (num1 > num2));
        System.out.println("O primeiro número é menor que o segundo? " + (num1 < num2));
        System.out.println("O primeiro número é igual ao segundo? " + (num1 == num2));
        System.out.println("O primeiro número é diferente do segundo? " + (num1 != num2));
        System.out.println("O primeiro número é maior ou igual ao segundo? " + (num1 >= num2));
        System.out.println("O primeiro número é menor ou igual ao segundo? " + (num1 <= num2));
        sc.close();
    }
}
