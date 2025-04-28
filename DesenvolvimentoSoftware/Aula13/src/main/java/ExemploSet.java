import java.util.HashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>();

        cores.add("Amarelo");
        cores.add("Vermelho");
        cores.add("Verde");
        cores.add("Azul");

        cores.add("Amarelo"); // Não adiciona pq repete

        for(String cor : cores){
            System.out.println(cor);
        }

        if (cores.contains("Verde")){
            System.out.println("Achei a cor verde");
        }

        cores.remove("Amarelo");

        System.out.println("Tamanho: " + cores.size());

        System.out.println(cores);
    }
}
