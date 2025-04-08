import java.util.ArrayList;
import java.util.Scanner;

class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }
    public void apresentar(){
        System.out.println("Olá, sou uma pessoa genérica.");
    }
}

class Aluno extends Pessoa {
    public Aluno(String nome){
        super(nome);
    }

    @Override
    public void apresentar() {
        System.out.println("Olá, sou o aluno " + nome + ".");
    }
}

class Professor extends Pessoa {
    public Professor (String nome){
        super(nome);
    }

    @Override
    public void apresentar(){
        System.out.println("Olá, sou o professor " + nome + ".");
    }
}
public class SistemaPessoas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        int opcao;
        do {
            System.out.println("=====MENU=====");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Exibir apresentações");
            System.out.println("4 - Sair");
            System.out.println("5 - Mostrar total de alunos e professores");
            System.out.print("-> ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("\nDigite o nome do aluno: ");
                    String nomeAluno = sc.nextLine();
                    pessoas.add(new Aluno(nomeAluno));
                    System.out.println("Aluno cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("\nDigite o nome do professor: ");
                    String nomeProfessor = sc.nextLine();
                    pessoas.add(new Professor(nomeProfessor));
                    System.out.println("Professor cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("\n=== APRESENTAÇÕES ===");
                    for(Pessoa pessoa: pessoas){
                        pessoa.apresentar();
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o programa!");
                    break;
                case 5:
                    int totalAlunos = 0;
                    int totalProfessores = 0;
                    for (Pessoa p: pessoas){
                        if (p instanceof Aluno){
                            totalAlunos += 1;
                        } else if (p instanceof Professor){
                            totalProfessores += 1;
                        }
                    }
                    System.out.println("Número de alunos: " + totalAlunos);
                    System.out.println("Número de Professores: " + totalProfessores);
                    System.out.println("TOTAL: " + pessoas.size());
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!");
                    break;
            }
        } while(opcao != 4);

        sc.close();
    }
}
