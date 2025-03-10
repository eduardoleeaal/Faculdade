import java.util.Scanner;

public class AjusteEntrada {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um número decimal: ");
        String entrada = sc.nextLine().replace(".", ",");

        double numero = Double.parseDouble(entrada);

        System.out.println("Número digitado: " + numero);

        sc.close();
    }
}
