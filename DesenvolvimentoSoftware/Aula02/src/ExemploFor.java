public class ExemploFor {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++){
            System.out.println("i: " + i);
        }

        int[] lista = {1, 2, 3, 4, 5};
        for(int num : lista){
            System.out.println("Num: " + num);
        }

    }
}
