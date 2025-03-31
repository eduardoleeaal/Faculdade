import java.util.Scanner;

abstract class Funcionario {
    String nome;
    double salario;

    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Salário base: R$" + salario);
    }
}

class Gerente extends Funcionario{
    double bonus;

    public double calcularSalario(){
        return super.salario + bonus;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Salario total com Bônus: R$" + calcularSalario());
    }
}

class Assistente extends Funcionario {
    String turno;

    public String mostrarTurno(){
        return turno;
    }

    @Override
    public void exibirDados(){
        super.exibirDados();
        System.out.println("Turno de trabalho: " + mostrarTurno());
    }
}

public class Ex002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gerente g1 = new Gerente();
        Assistente a1 = new Assistente();

        System.out.println("===Cadastro de Gerente===");
        System.out.print("Nome: ");
        g1.nome = sc.nextLine();
        System.out.print("Salário base: R$");
        g1.salario = sc.nextDouble();
        System.out.print("Bônus: R$");
        g1.bonus = sc.nextDouble();

        g1.exibirDados();

        sc.nextLine();
        System.out.println("===Cadastro de Assistente===");
        System.out.print("Nome: ");
        a1.nome = sc.nextLine();
        System.out.print("Salário base: R$");
        a1.salario = sc.nextDouble();
        sc.nextLine();
        System.out.print("Turno:");
        a1.turno = sc.nextLine();

        a1.exibirDados();
    }
}
