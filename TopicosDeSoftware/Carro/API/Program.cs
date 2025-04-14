using API.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.OpenApi.Models;
using Swashbuckle.AspNetCore.Annotations;
using Microsoft.Extensions.DependencyInjection;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDbContext<AppDataContext>();

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(options =>
{
    options.EnableAnnotations(); // precisa do namespace Swashbuckle.AspNetCore.Annotations
    options.SwaggerDoc("v1", new OpenApiInfo
    {
        Title = "API Carros",
        Description = "API para gerenciamento de carros e modelos",
        Contact = new OpenApiContact
        {
            Name = "Eduardo Leal",
            Email = "eduardo.leeal@hotmail.com"
        },
        License = new OpenApiLicense
        {
            Name = "MIT",
            Url = new Uri("https://opensource.org/licenses/MIT")
        }
    });
});


var app = builder.Build();

app.UseSwagger();
app.UseSwaggerUI();

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

app.MapGet("/api/modelos", ([FromQuery] string name, [FromServices] AppDataContext ctx) =>
{
    IQueryable<Modelo> queryable = ctx.Modelos.AsNoTracking();

    var modelos = queryable
        .Where(m => EF.Functions.Like(m.Name.ToLower(), $"%{name.ToLower()}%"))
        .ToList();

    if (modelos == null || modelos.Count == 0)
    {
        return Results.NotFound();
    }
    return Results.Ok(modelos);
});

app.MapPost("/api/modelos", ([FromServices] AppDataContext ctx, [FromBody] Modelo modelo) =>
{
    ctx.Modelos.Add(modelo);
    ctx.SaveChanges();

    return Results.Created($"/api/modelos/{modelo.Id}", modelo);
});

app.MapGet("/api/modelos/{id}", ([FromRoute] int id, [FromServices] AppDataContext ctx) =>
{
    var modelo = ctx.Modelos.Find(id);
    if (modelo == null)
    {
        return Results.NotFound();
    }
    return Results.Ok(modelo);
});

app.Run();
