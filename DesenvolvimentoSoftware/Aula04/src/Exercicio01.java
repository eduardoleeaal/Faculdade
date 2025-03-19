import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidade;

    void mostrar(){
        System.out.println("Produto: " + nome);
        System.out.println("Preço: R$" + preco);
        System.out.println("Quantidade: " + quantidade + " unidades");
    }
}

public class Exercicio01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Produto pd = new Produto();

        System.out.print("Digite o nome do produto: ");
        pd.nome = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        pd.preco = sc.nextDouble();
        System.out.print("Digite a quantidade em estoque: ");
        pd.quantidade = sc.nextInt();

        pd.mostrar();

        sc.close();
    }
}
