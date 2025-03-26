public class ContaBancaria {
    private String nome;
    private int nConta;
    private double saldo;

    public ContaBancaria(String nome, int nConta) {
        this.nome = nome;
        this.nConta = nConta;
        this.saldo = 0.0;
    }

    public void deposito(double valor) {
        this.saldo += valor;
        System.out.printf("\nDeposito de R$%.2f Realizado com Sucesso!", valor);
    }

    public void saque(double valor) {
        if (valor > saldo) {
            System.out.println("\nSaldo Insuficiente!");
        } else {
            System.out.printf("\nSaque de R$%.2f Realizado com Sucesso!", valor);
            this.saldo -= valor;
        }
    }

    public void exibirConta() {
        System.out.println("\nNome: " + nome);
        System.out.println("Número da conta: " + nConta);
        System.out.println("Saldo: R$" + saldo);
    }


    public double getSaldo() {
        return saldo;
    }
}
