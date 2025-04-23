public interface Autenticavel {
    void autenticar(String login, String senha) throws TentativasExcedidasException;
}
