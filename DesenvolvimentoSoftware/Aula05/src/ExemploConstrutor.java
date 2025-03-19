class CarroDois {
    String modelo;
    int ano;

    public CarroDois(int ano, String modelo) {
        this.ano = ano;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "CarroDois{" +
                "modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }
}

public class ExemploConstrutor {
    public static void main(String[] args) {
        CarroDois carro = new CarroDois(2022, "Civic");
        System.out.println(carro.toString());
    }
}
