
class Livro {
    private String titulo;
    private int paginas;
    private boolean disponivel;

    public Livro() {
    }

    public Livro(String titulo, int paginas, boolean disponivel) {
        this.titulo = titulo;
        this.paginas = paginas;
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

public class Exercicio {
    public static void main(String[] args) {
        Livro l1 = new Livro();

        l1.setTitulo("Senhor dos Anéis");
        l1.setPaginas(1220);
        l1.setDisponivel(true);

        System.out.printf("\nTítulo: %s", l1.getTitulo());
        System.out.printf("\nTotal de páginas: %d", l1.getPaginas());
        if (l1.isDisponivel())
            System.out.println("\nDisponível para empréstimo!");
        else
            System.out.println("\nIndisponível para empréstimo");

        Livro l2 = new Livro("Harry Potter", 900, false);

        System.out.printf("\nTítulo: %s", l2.getTitulo());
        System.out.printf("\nTotal de páginas: %d", l2.getPaginas());
        if (l2.isDisponivel())
            System.out.println("\nDisponível para empréstimo");
        else
            System.out.println("\nIndisponível para empréstimo");

    }
}

