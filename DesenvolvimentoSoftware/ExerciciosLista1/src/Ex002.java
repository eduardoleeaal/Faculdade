import java.util.Scanner;

public class Ex002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 10; i++){
            System.out.print("Digite um numero: ");
            int num = sc.nextInt();

            if (num % 2 == 0){
                count += 1;
            }
        }

        System.out.println("Quantidade de números pares: " + count);
    }
}
