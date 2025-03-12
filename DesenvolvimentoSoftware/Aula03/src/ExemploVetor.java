import java.util.ArrayList;

public class ExemploVetor {
    public static void main(String[] args) {

        int[] numeros = {10, 20, 30, 40, 50};
        ArrayList<Integer> num = new ArrayList<>();

        num.add(11);
        num.add(22);
        num.add(33);
        num.add(44);
        num.add(55);

        for(int n: num){
            System.out.println(numeros[1]);
        }

        for(int no: numeros){
            System.out.println(no);
        }


    }
}
