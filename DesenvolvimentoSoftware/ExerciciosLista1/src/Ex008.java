import java.util.Scanner;

public class Ex008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String palavra = sc.nextLine();
        contarVogais(palavra);

        sc.close();
    }

    public static void contarVogais(String palavra){
        int vogais = 0;
        for (char letra : palavra.toCharArray()) {
            switch (letra) {
                case 'a', 'u', 'e', 'i', 'o':
                    vogais++;
                    break;
            }
        }
        System.out.printf("A palavra contém %d vogais.\n", vogais);
    }
}
