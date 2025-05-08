import java.io.Serializable;
// A classe Pessoa implementa Serializable para poder ser gravada em arquivo
public class Pessoa implements Serializable {
    private String nome;
    private int idade;
    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void exibirDados(){
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }

}
