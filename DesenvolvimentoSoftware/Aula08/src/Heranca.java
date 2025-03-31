abstract class Pessoa {
    // Classes abstratas apenas podem ser herdadas, não podem ser inicializadas no programa principal
    String nome;
    int idade;

    public Pessoa(int idade, String nome) {
        this.idade = idade;
        this.nome = nome;
    }

    void apresentar(){
        System.out.printf("\nOlá, meu nome é %s tenho %d anos de idade!", nome, idade);
    }
}

class Aluno extends Pessoa {
    String curso;

    public Aluno(int idade, String nome, String curso) {
        super(idade, nome);
        this.curso = curso;
    }

    @Override
    void apresentar(){
        super.apresentar();
        System.out.printf("\nSou aluno na faculdade de %s", curso);
    }
}

class Professor extends Pessoa {
    String disciplina;

    public Professor(int idade, String nome, String disciplina) {
        super(idade, nome);
        this.disciplina = disciplina;
    }

    @Override
    void apresentar() {
        super.apresentar();
        System.out.printf("\nSou professor de %s", disciplina);
    }
}

public class Heranca {
    public static void main(String[] args) {
        // Pessoa p1 = new Pessoa(20, "Leal");     CLASSES ABSTRATAS NÃO PODEM SER INICIALIZADAS
        Aluno a1 = new Aluno(20, "Eduardo", "ADS");
        Professor pr1 = new Professor(30, "Azeitona", "Física");

        // p1.apresentar();
        a1.apresentar();
        pr1.apresentar();
    }
}
