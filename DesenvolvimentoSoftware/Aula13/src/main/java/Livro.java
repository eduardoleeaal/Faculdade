/*
Cada Livro deve ter:
título (String)
autor (String)
ISBN (String) → deve ser único (usar Set para validar duplicidade)
disponibilidade (boolean)
* */
public class Livro implements Emprestavel{
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean disponibilidade;

    
    @Override
    public void emprestar() {

    }

    @Override
    public void devolver() {

    }
}
