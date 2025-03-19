import java.util.Scanner;

class Aluno {
    String nome;
    double nota1;
    double nota2;



    void verificar() {
        double media = (nota1 + nota2) / 2.0;
        System.out.print("\nAluno: " + nome);
        System.out.print("\nMédia: " + media);
        System.out.print("\nSituação: ");
        if (media >= 7) {
            System.out.println("Aprovado");
        } else {
            System.out.println("Reprovado");
        }
    }
}

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Aluno aln = new Aluno();

        System.out.print("Digite o nome do aluno: ");
        aln.nome = sc.nextLine();
        System.out.print("Digite a primeira nota: ");
        aln.nota1 = sc.nextDouble();
        System.out.print("Digite a segunda nota: ");
        aln.nota2 = sc.nextDouble();

        aln.verificar();

        sc.close();
    }
}
