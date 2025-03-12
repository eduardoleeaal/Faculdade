public class ExemplosMetodos {
    public static void main(String[] args) {
        int resultadoSoma = somar(10, 5);
        double resultadoMultiplicacao = multiplicar(4.5, 2);

        System.out.println("Soma: " + resultadoSoma);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);
    }

    public static int somar(int a, int b){
        return a + b;
    }

    public static double multiplicar(double a, double b){
        return a * b;
    }
}
