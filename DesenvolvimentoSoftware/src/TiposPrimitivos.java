import java.util.Scanner;

public class TiposPrimitivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Digite um numero: ");
        int number = sc.nextInt();

        byte valorByte = 127;
        short valorShort = 32767;
        int valorInt = 2147483647;
        long valorLong = 9223372036854775807L;

        // Tipos flutuantes
        float valorFloat = 3.4028235E38f;
        double valorDouble = 1.7976931348623157E308;

        // Tipo caractere
        char valorChar = 'A';

        // Tipo booleano
        boolean valorBoolean = true;

        System.out.println("=== Demonstração de Tipos Primitivos ===");
        System.out.println("Byte: " + valorByte);
        System.out.println("Short: " + valorShort);
        System.out.println("Int: " + valorInt);
        System.out.println("Long: " + valorLong);
        System.out.println("Float: " + valorFloat);
        System.out.println("Double: " + valorDouble);
        System.out.println("Char: " + valorChar);
        System.out.println("Boolean: " + valorBoolean);

        System.out.println("Número digitado: " + number);
    }
}
