import java.util.ArrayList;
import java.util.Scanner;

abstract class Veiculo {
    protected int id;
    protected String marca;
    protected int ano;

    public Veiculo(int id, int ano, String marca) {
        this.id = id;
        this.ano = ano;
        this.marca = marca;
    }

    abstract public void exibirDados();
}

class Onibus extends Veiculo {
    private final String tipo;
    private final int capacidadePassageiros;

    public Onibus(int id, int ano, String marca, String tipo, int capacidadePassageiros){
        super(id, ano, marca);
        this.tipo = tipo;
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public void abrirPortas(){
        System.out.println("Portas abrindo...");
    }

    public void fecharPortas(){
        System.out.println("Portas fechando...");
    }

    @Override
    public void exibirDados() {
        System.out.println("\nÔnibus:");
        System.out.println("ID: " + id);
        System.out.println("ANO: " + ano);
        System.out.println("MARCA: " + marca);
        System.out.println("CAPACIDADE MAX: " + capacidadePassageiros);
        System.out.println("TIPO: " + tipo);
    }
}

class Metro extends Veiculo {
    private final int numeroVagoes;
    private final boolean temArCondicionado;

    public Metro(int id, int ano, String marca, int numeroVagoes, boolean temArCondicionado) {
        super(id, ano, marca);
        this.numeroVagoes = numeroVagoes;
        this.temArCondicionado = temArCondicionado;
    }

    public void embarcarPassageiros(int qnt) {
        System.out.println(qnt + " Passageiros foram embarcados");
    }

    public void desembarcarPassageiros(int qnt) {
        System.out.println(qnt + " Passageiros foram desembarcados");
    }

    @Override
    public void exibirDados() {
        System.out.println("\nMetrô:");
        System.out.println("ID: " + id);
        System.out.println("ANO: " + ano);
        System.out.println("MARCA: " + marca);
        System.out.println("Número de vagões: " + numeroVagoes);
        if (temArCondicionado) {
            System.out.println("Com Ar-Condicionado");
        } else {
            System.out.println("Sem Ar-Condicionado");
        }
    }
}

class Garagem {
    ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo v) {
        veiculos.add(v);
        System.out.println("Veículo adicionado\n");
    }

    public void listarTodos(){
        for (Veiculo v: veiculos){
            v.exibirDados();
            System.out.println();
        }
    }

    public void listarPorTipo(){
        System.out.println("\n=== ÔNIBUS ===");
        for (Veiculo v: veiculos){
            if (v instanceof Onibus){
                v.exibirDados();
            }
        }
        System.out.println("\n=== Metrô ===");
        for (Veiculo v: veiculos){
            if (v instanceof Metro){
                v.exibirDados();
            }
        }
    }

    public void contarVeiculos(){
        int qntOnibus = 0;
        int qntMetros = 0;

        for (Veiculo v: veiculos){
            if (v instanceof Onibus){
                qntOnibus++;
            } else if (v instanceof Metro) {
                qntMetros++;
            }
        }
        System.out.println("Quantidade de ônibus: " + qntOnibus);
        System.out.println("Quantidade de metrôs: " + qntMetros);
        System.out.println("Quantidade total: " + (qntMetros + qntOnibus));
    }

}

public class SistemaTransporteApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Garagem garage = new Garagem();
        int opt, id, ano, capacidadeMax, nVagoes;
        String marca, tipo;

        do {
            System.out.println("1 - Cadastrar ônibus");
            System.out.println("2 - Cadastrar metrô");
            System.out.println("3 - Listar todos os veículos");
            System.out.println("4 - Listar veículos por tipo");
            System.out.println("5 - Executar ação");
            System.out.println("6 - Mostrar quantidade de veiculos");
            System.out.println("7 - SAIR");
            System.out.print("--> ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt){
                case 1:
                    System.out.println("CADASTRO ÔNIBUS: ");
                    System.out.print("Digite o id: ");
                    id = sc.nextInt();
                    System.out.print("Digite o ano: ");
                    ano = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite a marca: ");
                    marca = sc.nextLine();
                    System.out.print("Digite o tipo: ");
                    tipo = sc.nextLine();
                    System.out.print("Digite a capacidade máxima: ");
                    capacidadeMax = sc.nextInt();
                    sc.nextLine();

                    garage.adicionarVeiculo(new Onibus(id, ano, marca, tipo, capacidadeMax));
                    break;
                case 2:
                    System.out.println("CADASTRO METRÔ: ");
                    System.out.print("Digite o id: ");
                    id = sc.nextInt();
                    System.out.print("Digite o ano: ");
                    ano = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite a marca: ");
                    marca = sc.nextLine();
                    System.out.print("Número de vagões: ");
                    nVagoes = sc.nextInt();
                    sc.nextInt();
                    System.out.println("Tem ar-condicionado (true/false): ");
                    boolean temAr = sc.nextBoolean();
                    garage.adicionarVeiculo(new Metro(id, ano, marca, nVagoes, temAr));
                    break;
                case 3:
                    garage.listarTodos();
                    break;
                case 4:
                    garage.listarPorTipo();
                    break;
                case 5:
                    int escolha;

                    for (Veiculo v: garage.veiculos){
                        if (v instanceof Onibus){
                            System.out.println("AÇÕES DISPONIVEIS PARA ÔNIBUS: ");
                            System.out.println("3 - Abrir portas");
                            System.out.println("4 - Fechar portas");
                            System.out.print("--> ");
                            escolha = sc.nextInt();
                            switch (escolha){
                                case 1:
                                    ((Onibus) v).abrirPortas();
                                    break;
                                case 2:
                                    ((Onibus) v).fecharPortas();
                                    break;
                                default:
                                    System.out.println("Escolha incorreta!");
                                    break;
                            }
                        } else if (v instanceof Metro){
                            System.out.println("AÇÕES DISPONIVEIS PARA METRÔ: ");
                            System.out.println("1 - Embarcar");
                            System.out.println("2 - Desembarcar");
                            System.out.print("--> ");
                            escolha = sc.nextInt();

                            switch (escolha){
                                case 1:
                                    System.out.print("Quantidade de passageiros embarque: ");
                                    int qntPassEm = sc.nextInt();
                                    ((Metro) v).embarcarPassageiros(qntPassEm);
                                    break;
                                case 2:
                                    System.out.print("Quantidade de passageiros desembarque: ");
                                    int qntPassDesem = sc.nextInt();
                                    ((Metro) v).desembarcarPassageiros(qntPassDesem);
                                    break;
                                default:
                                    System.out.println("Escolha incorreta!");
                                    break;
                            }
                        }
                    }
                    break;
                case 6:
                    garage.contarVeiculos();
                    break;
                case 7:
                    System.out.println("SAINDO...");
                    break;
                default:
                    System.out.println("Escolha incorreta!");
                    break;

            }

        } while (opt != 7);



        sc.close();
    }
}
