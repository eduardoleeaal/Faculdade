import java.util.Scanner;

public class Ex006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número para ver sua tabuada: ");
        int valor = sc.nextInt();
        exibirTabuada(valor);
    }

    public static void exibirTabuada(int valor){
        for (int i = 1; i <= 10; i++){
            System.out.printf("%d x %d = %d\n", valor, i, i*valor);
        }
    }
}
