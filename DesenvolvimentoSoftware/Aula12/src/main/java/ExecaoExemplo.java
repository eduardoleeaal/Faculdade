import java.util.InputMismatchException;
import java.util.Scanner;

public class ExecaoExemplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite um número inteiro: ");
            int numero = sc.nextInt();
            int divisao = 100/numero;
            System.out.printf("\n100 Divididos por %d = %d", numero, divisao);
        } catch (InputMismatchException e) {
            System.out.println("Formato de entrada incorreto");
        } catch (ArithmeticException e) {
            System.out.println("Divisão por zero não é permitido");
        } catch (NumberFormatException e) {
            System.out.println("Valor digitado não pode ser convertido para número");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Execução finalizada");
            sc.close();
        }
    }
}
