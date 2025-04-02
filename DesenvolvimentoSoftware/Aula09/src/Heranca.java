abstract class Pessoa {
    protected String nome;
    protected int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentar(){
        System.out.printf("\nSou %s, tenho %d anos.", nome, idade);
    }
}
class Funcionario extends Pessoa {
    protected double salario;

    public Funcionario(String nome, int idade, double salario) {
        super(nome, idade);
        this.salario = salario;
    }

    @Override
    public void apresentar(){
        super.apresentar();
        System.out.println("\nSou um funcionário e ganho R$" + salario);
    }
}

class Gerente extends Funcionario {
    private final String setor;

    public Gerente(String nome, int idade, double salario, String setor) {
        super(nome, idade, salario);
        this.setor = setor;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("Atuo como gerente no setor de " + setor);
    }
}
public class Heranca{
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Marcos", 20, 2100);
        Gerente g1 = new Gerente("Joel", 32, 5000, "Vendas");

        f1.apresentar();
        g1.apresentar();
    }
}
