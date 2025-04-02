import java.util.Scanner;

abstract class Transporte {
    protected String linha;
    protected String motorista;
    protected int qntPassageiros;

    public Transporte(String linha, int qntPassageiros, String motorista) {
        this.linha = linha;
        this.qntPassageiros = qntPassageiros;
        this.motorista = motorista;
    }

    public void iniciarViagem(){
        System.out.println("Viagem iniciada.");
    }

    public void encerrarViagem(){
        System.out.println("Viagem encerrada.");
    }

    public void mostrarDados(){
        System.out.println("Linha: " + linha);
        System.out.println("Quantidade de Passageiros: " + qntPassageiros);
        System.out.println("Motorista: " + motorista);
    }
}

class Onibus extends Transporte {
    private final String tipo;

    public Onibus(String linha, int qntPassageiros, String motorista, String tipo) {
        super(linha, qntPassageiros, motorista);
        this.tipo = tipo;
    }

    public void abrirPortas(){
        System.out.println("Portas abrindo.");
    }

    public void fecharPortas(){
        System.out.println("Portas fechando.");
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Tipo: " + tipo);
    }
}

class Metro extends Transporte {
    private final int nVagoes;

    public Metro(String linha, int qntPassageiros, String motorista, int nVagoes) {
        super(linha, qntPassageiros, motorista);
        this.nVagoes = nVagoes;
    }

    public void embarcarPassageiros(int qntPassageiros){
        this.qntPassageiros += qntPassageiros;
        System.out.println(qntPassageiros + " Foram embarcados.");
    }

    public void desembarcarPassageiros(int qntPassageiros) {
        this.qntPassageiros -= qntPassageiros;
        System.out.println(qntPassageiros + " Desembarcaram");
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Quantidade de vagões: " + nVagoes);
    }
}

public class Ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt;
        Onibus on1 = null;
        Metro mt1 = null;

        do {
            System.out.println("1 - Cadastrar Ônibus");
            System.out.println("2 - Cadastrar metro");
            System.out.println("3 - Iniciar viagem");
            System.out.println("4 - Exibir dados do veiculo");
            System.out.println("5 - Encerrar viagem");
            System.out.println("6 - Sair");
            opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    System.out.print("Digite a linha do ônibus: ");
                    String linha = sc.nextLine();
                    System.out.print("Digite a quantidade de Passageiros: ");
                    int qntP = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o nome do motorista: ");
                    String motori = sc.nextLine();
                    System.out.print("Digite o tipo (articulado / micro-ônibus):");
                    String tipo = sc.nextLine();
                    on1 = new Onibus(linha, qntP, motori, tipo);
                    System.out.println("ÔNIBUS CADASTRADO!");
                    break;
                case 2:
                    System.out.print("Digite a linha do metro: ");
                    String linhaM = sc.nextLine();
                    System.out.print("Digite a quantidade de Passageiros: ");
                    int qntPa = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o nome do motorista: ");
                    String motoris = sc.nextLine();
                    System.out.print("Digite a quantidade de vagões:");
                    int qntV = sc.nextInt();
                    mt1 = new Metro(linhaM, qntPa, motoris, qntV);
                    System.out.println("METRÔ CADASTRADO!");
                    break;
                case 3:
                    if (on1 == null || mt1 == null) {
                        System.out.println("Você precisa cadastrar um ônibus e um metrô antes de iniciar a viagem.");
                    } else {
                        mt1.iniciarViagem();
                        on1.iniciarViagem();
                    }
                    break;
                case 4:
                    if (on1 == null || mt1 == null) {
                        System.out.println("Você precisa cadastrar um ônibus e um metrô antes de Exibir os dados.");
                    } else {
                        System.out.println("DADOS ÔNIBUS: ");
                        on1.mostrarDados();

                        System.out.println("DADOS METRÔ: ");
                        mt1.mostrarDados();
                    }
                    break;
                case 5:
                    if (on1 == null || mt1 == null) {
                        System.out.println("Você precisa cadastrar um ônibus e um metrô antes de encerrar a viagem.");
                    } else {
                        mt1.encerrarViagem();
                        on1.encerrarViagem();
                    }
                    break;
                case 6:
                    System.out.println("SAINDO...");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA.");
                    break;
            }
        } while (opt != 6);
    }
}
