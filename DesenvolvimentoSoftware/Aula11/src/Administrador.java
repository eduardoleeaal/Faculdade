public class Administrador implements Autenticavel {
    private String nome;

    public Administrador(String nome) {
        this.nome = nome;
    }

    @Override
    public void autenticar(String usuario, String senha) {
        // Simulação de login fixo:
        if (usuario.equals("admin") && senha.equals("admin")){
            System.out.println("ADMIN AUTENTICADO!");
        } else {
            System.out.println("LOGIN OU SENHA INCORRETO");
        }
    }
}
