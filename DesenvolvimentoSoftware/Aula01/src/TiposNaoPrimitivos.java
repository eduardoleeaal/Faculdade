import java.util.ArrayList;

public class TiposNaoPrimitivos {
    public static void main(String[] args) {
        String texto = "Olá, mundo!";

        int[] numeros = {1, 2, 3, 4, 5};

        ArrayList<String> listaNomes = new ArrayList<>();
        listaNomes.add("Alice");
        listaNomes.add("Bob");
        listaNomes.add("Charlie");

        System.out.println("String: " + texto);

        System.out.print("Array de inteiros: ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }

        System.out.println("\nLista de nomes: " + listaNomes);
    }
}
