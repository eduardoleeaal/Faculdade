import java.util.Scanner;
/*
1 - Consultar saldo
2 - Depositar
3 - Sacar
4 - Exibir dados da conta
5 - Sair
*/
public class Exercicio02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria c1 = new ContaBancaria("Eduardo", 10026);
        int resp;

        do {
            System.out.println("\n1 - Consultar Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Exibir dados da conta");
            System.out.println("5 - SAIR");
            System.out.print("-> ");
            resp = sc.nextInt();

            switch (resp){
                case 1:
                    System.out.println("\nSaldo Atual: R$" + c1.getSaldo());
                    break;
                case 2:
                    System.out.println("\nDigite o valor para depositar: ");
                    System.out.print("-> R$");
                    c1.deposito(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("\nDigite o valor para sacar: ");
                    System.out.print("-> R$");
                    c1.saque(sc.nextDouble());
                    break;
                case 4:
                    c1.exibirConta();
                    break;
                case 5:
                    System.out.println("\nSAINDO....");
                    break;
                default:
                    System.out.println("\nOpção incorreta!");
                    break;
            }
        } while (resp != 5);
    }
}


