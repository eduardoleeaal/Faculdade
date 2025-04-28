
/*
* Tipos de coleções
* List → ArrayList, LinkedList  → Lista Ordenada
* Set  → HashSet, TreeSet       → Conjunto (Não aceita elementos repetidos)
* Map  → HashMap, MapSet        → Pares chave-valor (ex: 'CPF': '111.222.333-44')
* */

import java.util.ArrayList;
import java.util.List;

public class ExemploLista {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Eduardo");
        nomes.add("João");
        nomes.add("Hugo");
        nomes.add("Gustavo");

        System.out.printf("Nome índice 1: %s\n", nomes.get(1));

        System.out.println("Todos os nomes: ");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("Tamanho da lista: " + nomes.size());
        System.out.println("Removido elemento João");
        nomes.remove("João");
        System.out.println(nomes);



    }
}
