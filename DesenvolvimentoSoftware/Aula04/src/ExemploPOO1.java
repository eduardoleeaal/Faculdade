class Carro {
    private String marca;
    private String modelo;
    private int ano;

    Carro(String marca, String modelo, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void buzinar(){
        System.out.println("Beep Beep");
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }
}

public class ExemploPOO1 {
    public static void main(String[] args) {
        Carro carro = new Carro("Volkswagen", "Gol", 1998);
        carro.buzinar();
        System.out.println(carro.toString());

    }
}
