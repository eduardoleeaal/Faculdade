import java.util.Scanner;

public class Ex004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double soma = 0;

        for (int i = 0; i < 5; i++){
            System.out.printf("Digite a %dº nota: ", i+1);
            double nota = sc.nextDouble();
            soma += nota;
        }

        double media = soma / 5;

        System.out.printf("\nMédia: %.2f", media);
        if (media >= 7){
            System.out.println("Aprovado!");
        } else {
            System.out.println("Reprovado!");
        }
    }
}
