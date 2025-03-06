namespace Aula2;

public class Aluno
{
    public int Id { get; }
    public string Name { get; set; }

    // Construtor
    public Aluno()
    {
        // Gerar numero inteiro aleatorio
        Random random = new Random();
        Id = random.Next(1, 1000);
    }
}