import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        Map<String, Double> alunosNota = new HashMap<>();
        alunosNota.put("Eduardo", 6.5);
        alunosNota.put("Ana", 6.0);
        alunosNota.put("Luiz", 9.1);
        alunosNota.put("Bruno", 5.1);

        System.out.println(alunosNota);

        for (String nome : alunosNota.keySet()) {
            Double nota = alunosNota.get(nome);
            System.out.println("\nNome: " + nome + "\nMédia: " + nota);
            System.out.println(nota >= 6.0 ? "Aprovado" : "Reprovado");
        }

        System.out.println(alunosNota.containsKey("Eduardo") ? "\nEduardo está na lista" : "\nEduardo não está na lista");

        alunosNota.remove("Bruno");

        System.out.println(alunosNota.size());
    }
}
