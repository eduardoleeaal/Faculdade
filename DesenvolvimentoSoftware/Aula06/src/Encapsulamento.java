
class Pessoa {
    String nome;
    int idade;
}

public class Encapsulamento {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.nome = "Eduardo";
        p.idade = 21;
        if (p.idade >= 0) {
            System.out.printf("\n%s, tem %d anos", p.nome, p.idade);
        } else {
            System.out.println("Idade inválida");
        }

        p.idade = -5;

        System.out.printf("\n%s, tem %d anos", p.nome, p.idade);

    }
}
