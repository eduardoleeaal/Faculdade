namespace API.Models;

public class Carro
{
    public int Id { get; set; }
    public string? Name { get; set; }
    public DateTime CriadoEm { get; set; }

    public int ModeloId { get; set; } // <- Adicione essa linha
    public Modelo? Modelo { get; set; } // <- Relacionamento de navegação

    public Carro()
    {
        this.CriadoEm = DateTime.Now;
    }
}
