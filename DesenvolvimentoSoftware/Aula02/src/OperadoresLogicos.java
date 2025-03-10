import java.util.Scanner;

public class OperadoresLogicos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite true ou false para A: ");
        boolean a = sc.nextBoolean();

        System.out.println("Digite true ou false para B: ");
        boolean b = sc.nextBoolean();

        boolean and = a && b;
        boolean or = a || b;
        boolean notA = !a;
        boolean notB = !b;

        System.out.println("AND: " + and);
        System.out.println("OR: " + or);
        System.out.println("NOT A: " + notA);
        System.out.println("NOT B: " + notB);

    }
}
