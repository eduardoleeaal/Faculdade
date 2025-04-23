public class Usuario implements Autenticavel {
    private final String nome;
    private int tentativas;

    public Usuario(String nome) {
        this.nome = nome;
        this.tentativas = 0;
    }

    @Override
    public void autenticar(String login, String senha) throws TentativasExcedidasException {
        if (login.equals("admin") && senha.equals("123")){
            System.out.println("Usuário: " + nome);
            System.out.println("Login Ok");
            tentativas = 0;
        } else {
            tentativas++;
            if (tentativas >= 3) {
                throw new TentativasExcedidasException(tentativas);
            } else {
                System.out.println("Login ou senha incorretos. Tentativa " + tentativas);
            }
        }
    }

}
