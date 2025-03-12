import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ExemploLista {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("Eduardo");
        nomes.add("Ana");
        nomes.add("Leonardo");
        nomes.add("Diana");
        nomes.add("Bruno");

        System.out.println("Lista de nomes: ");
        for (String nome: nomes){
            System.out.println(nome);
        }

    }
}
