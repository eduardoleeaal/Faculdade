public class TentativasExcedidasException extends Exception {
    public TentativasExcedidasException(int tentativas){
        super("Número máximo de Tentativas Excedido. Tentativa: " + tentativas);
    }
}
