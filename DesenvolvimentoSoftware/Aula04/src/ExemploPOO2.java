import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;

    public void dizerOla(){
        System.out.println("Olá! Meu nome é " + nome + " tenho " + idade + " anos.");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }
}


public class ExemploPOO2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pessoa pessoa = new Pessoa();

        System.out.print("Digite seu nome: ");
        pessoa.setNome(sc.nextLine());
        System.out.print("Digite sua idade: ");
        pessoa.setIdade(sc.nextInt());

        System.out.println("Pessoa: ");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());
        System.out.println();
        pessoa.dizerOla();

        sc.close();
    }
}
