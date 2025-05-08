
import java.io.*;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite a idade: ");
        int idade = sc.nextInt();
        Pessoa p1 = new Pessoa(nome, idade);

        // Serialização
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pessoa.dat"))){
            oos.writeObject(p1);
            System.out.println("Objeto Pessoa salvo com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o objeto: " + e.getMessage());
        }

        // Desserialização

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pessoa.dat"))){
            Pessoa pessoaLida = (Pessoa) ois.readObject();
            System.out.println("\nObjeto lido do arquivo");
            pessoaLida.exibirDados();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao Ler o objeto: " + e.getMessage());
        }

        sc.close();
    }
}
