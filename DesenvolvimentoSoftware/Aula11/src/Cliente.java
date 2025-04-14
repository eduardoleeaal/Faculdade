public class Cliente implements Autenticavel{
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public void autenticar(String usuario, String senha) {
        // Usuário e senha fixos

        if (usuario.equals("cliente") && senha.equals("cliente")){
            System.out.println("USUÁRIO CLIENTE AUTENTICADO!");
        } else {
            System.out.println("Login ou Senha Incorreto");
        }
    }
}
