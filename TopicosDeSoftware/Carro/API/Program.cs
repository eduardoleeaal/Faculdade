using API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDbContext<AppDataContext>();
var app = builder.Build();

// Exemplo de Endpoint
app.MapGet("/", () => "Hello World!");

// Endpoint listar carros
app.MapGet("/api/carros", ([FromServices] AppDataContext ctx) =>
{
    if (ctx.Carros.Any())
    {
        return Results.Ok(ctx.Carros.ToList());
    }
    return Results.NotFound();
});

app.MapPost("/api/carros", ([FromServices] AppDataContext ctx, [FromBody] Carro carro) =>
{
    ctx.Carros.Add(carro);
    ctx.SaveChanges();

    return Results.Created("", carro);
});



app.MapGet("/api/carros/{id}", ([FromRoute] int id, [FromServices] AppDataContext ctx) => {

    Carro? carro = ctx.Carros.Find(id);

    if (carro != null) {
        return Results.Ok(carro);
    }
    
    return Results.NotFound();
});

app.MapPut("/api/carros/{id}", ([FromRoute] int id,
                                [FromBody] Carro carro,
                                [FromServices] AppDataContext ctx) => {

    Carro? entidade = ctx.Carros.Find(id);

    if (entidade != null)
    {
        entidade.Name = carro.Name;
        ctx.Carros.Update(entidade);
        ctx.SaveChanges();
        return Results.Ok(carro);
    }
    return Results.NotFound();

});
app.MapDelete("/api/carros/{id}", ([FromRoute] int id,[FromServices] AppDataContext ctx) => {

    Carro? carro = ctx.Carros.Find(id);

    if(carro == null) {
        return Results.NotFound();
    }
    ctx.Carros.Remove(carro);
    ctx.SaveChanges();
    return Results.NoContent();

});

app.Run();
