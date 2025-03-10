import java.util.Scanner;

public class OperadoresAritmeticos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double num1 = sc.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = sc.nextDouble();

        System.out.println("Soma: " + (num1 + num2));
        System.out.println("Subtração: " + (num1 - num2));
        System.out.println("Multiplicação: " + (num1 * num2));
        System.out.println("Divisão: " + (num1 / num2));
        System.out.println("Resto: " + (num1 % num2));
        System.out.println("Potência: " + Math.pow(num1, num2));
        System.out.println("Raíz quadrada: " + Math.sqrt(num1));
        sc.close();
    }
}
