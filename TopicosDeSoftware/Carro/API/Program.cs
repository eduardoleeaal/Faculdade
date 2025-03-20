using API.Models;

var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();


List<Carro> carros = new List<Carro>() {
    new Carro{ Id = 1, Name = "Ferrari"},
    new Carro{ Id = 2, Name = "Lamborghini"},
    new Carro{ Id = 3, Name = "Porsche"},
    new Carro{ Id = 4, Name = "Audi"}
};

// Exemplo de Endpoint
app.MapGet("/", () => "Hello World!");

// Endpoint listar carros
app.MapGet("/api/carros", () =>
{
    return Results.Ok(carros);
});

app.Run();
