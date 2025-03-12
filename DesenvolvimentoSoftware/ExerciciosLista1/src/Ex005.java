import java.util.Scanner;

public class Ex005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                System.out.printf("Digite o número da posição %dx%d: ", i+1, j+1);
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matriz formatada: ");
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j ++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
