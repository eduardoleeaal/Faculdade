import java.util.ArrayList;
import java.util.Scanner;

public class Ex003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        int maior = 0;
        int menor = 0;

        for (int i = 0; i < 10; i++){
            int n = sc.nextInt();
            numeros.add(n);
        }

        for (int i = 0; i < 10; i++){
            if (i == 0){
                maior = numeros.getFirst();
                menor = numeros.getFirst();
            } else {
                if (numeros.get(i) > maior){
                    maior = numeros.get(i);
                }
                if (numeros.get(i) < menor){
                    menor = numeros.get(i);
                }
            }
        }

        System.out.println("Maior número: " + maior);
        System.out.println("Menor número: " + menor);
    }
}
