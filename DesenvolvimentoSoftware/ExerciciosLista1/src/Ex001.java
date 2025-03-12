import java.util.Scanner;

public class Ex001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = {0, 0, 0, 0, 0};

        for (int i = 0; i < numeros.length; i++){
            System.out.printf("Digite o numero da posição %d: ", i);
            numeros[i] = sc.nextInt();
        }
        int soma = 0;

        for (int num : numeros){
            soma += num;
        }

        System.out.println("A soma dos números é: " + soma);
    }
}
