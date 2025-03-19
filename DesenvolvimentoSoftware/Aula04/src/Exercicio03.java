/*
String modelo
boolean ligado (inicia como false)
int velocidade (inicia em 0)
Criar métodos para:

ligar() → Define ligado = true
desligar() → Define ligado = false, mas só se a velocidade for 0
acelerar() → Aumenta a velocidade somente se o carro estiver ligado
No main(), permitir que o usuário ligue o carro e acelere.

Exemplo de Entrada e Saída:
Modelo do carro: Ferrari
O carro foi ligado!
Acelerando... Velocidade atual: 20 km/h
Acelerando... Velocidade atual: 40 km/h
O carro foi desligado!
* */

import java.util.Scanner;

class Carrao {
    private String modelo;
    private boolean status = false;
    int velocidade = 0;

    void ligar() {
        if (!this.status) {
            System.out.println("Ligando...");
            this.status = true;
        } else {
            System.out.println("O carro já está ligado!");
        }
    }

    void desligar() {
        if (velocidade != 0) {
            System.out.println("Não é possivel desligar o carro andando!");
        } else {
            System.out.println("Desligando");
            this.status = false;
        }
    }

    void acelerar() {
        if (this.status) {
            this.velocidade += 20;
            System.out.println("Acelerando... Velocidade atual: " + this.velocidade + " Km/h");
        } else {
            System.out.println("Não é possivel acelerar com o carro desligado!");
        }
    }

    void desacelerar() {
        if (this.status && this.velocidade > 0) {
            this.velocidade -= 20;
            System.out.println("Desacelerando... Velocidade atual: " + this.velocidade + " Km/h");
        } else if (!this.status) {
            System.out.println("O carro está desligado!");
        } else {
            System.out.println("O carro já está parado!");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Carrao carrao = new Carrao();

        System.out.print("Digite o modelo: ");
        carrao.setModelo(sc.nextLine());

        System.out.println("Modelo: " + carrao.getModelo());
        int escolha;
        do {
            System.out.print("Escolha uma opção: ");
            System.out.println("1- Ligar");
            System.out.println("2- Desligar");
            System.out.println("3- Acelerar");
            System.out.println("4- Desacelerar");
            escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    carrao.ligar();
                    break;
                case 2:
                    carrao.desligar();
                    break;
                case 3:
                    carrao.acelerar();
                    break;
                case 4:
                    carrao.desacelerar();
                    break;
                case 0:
                    System.out.println();
                    break;
                default:
                    System.out.println("Escolha incorreta");
                    break;
            }

        } while(escolha != 0);


        sc.close();
    }
}
