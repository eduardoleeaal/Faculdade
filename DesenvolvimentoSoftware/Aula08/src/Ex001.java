import java.util.Scanner;

abstract class Veiculo {
    String marca;
    int ano;

    public void mostrarDados(){
        System.out.println("Marca: " + marca);
        System.out.println("Ano: " + ano);
    }
}

class Carro extends Veiculo {
    int portas;

    public void abrirPortas(){
        System.out.println("Abrindo todas as portas...");
    }

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        System.out.println("Este carro tem " + portas + " Portas");
    }
}

class Moto extends Veiculo {
    boolean temPartidaEletrica;

    public void empinar(){
        System.out.println("Empinando a moto!");
    }

    @Override
    public void mostrarDados(){
        super.mostrarDados();
        if (temPartidaEletrica) {
            System.out.println("A moto tem partida elétrica");
        } else {
            System.out.println("A moto não tem partida elétrica");
        }
    }

}

public class Ex001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Carro c1 = new Carro();
        Moto m1 = new Moto();

        System.out.print("Digite a marca do carro: ");
        c1.marca = sc.nextLine();
        System.out.print("Digite o ano: ");
        c1.ano = sc.nextInt();
        System.out.print("Digite o número de portas: ");
        c1.portas = sc.nextInt();

        c1.mostrarDados();

        sc.nextLine();
        System.out.println("\n------------------");

        System.out.print("Digite a marca da moto: ");
        m1.marca = sc.nextLine();
        System.out.print("Digite o ano: ");
        m1.ano = sc.nextInt();
        System.out.print("A moto tem partida elétrica? (true/false): ");
        m1.temPartidaEletrica = sc.nextBoolean();

        m1.mostrarDados();
    }
}
