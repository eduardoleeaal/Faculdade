using Microsoft.EntityFrameworkCore;
using GerenciamentoProdutosApi.Data;
using GerenciamentoProdutosApi.Models;
using Microsoft.AspNetCore.Mvc;

var builder = WebApplication.CreateBuilder(args);

// Configura o DbContext com SQLite
builder.Services.AddDbContext<AppDbContext>(options =>
    options.UseSqlite("Data Source=produtos.db"));

var app = builder.Build();

// Endpoint raiz de teste
app.MapGet("/", () => "Hello World!");

// Endpoints de Produtos
//app.MapGet("/produtos", async (AppDbContext db) =>
//    await db.Produtos.Include(p => p.Categoria).ToListAsync());

app.MapGet("/produtos", ([FromServices] AppDbContext ctx) =>
{
    if (ctx.Produtos.Any())
    {
        return Results.Ok(ctx.Produtos.ToList());
    }
    return Results.NotFound();
});


// app.MapGet("/produtos/{id}", async (int id, AppDbContext db) =>
// {
//     var produto = await db.Produtos
//         .Include(p => p.Categoria)
//         .FirstOrDefaultAsync(p => p.Id == id);
//     return produto is not null ? Results.Ok(produto) : Results.NotFound();
// });

app.MapGet("/produtos/{id}", ([FromRoute] int id, [FromServices] AppDbContext ctx) => {

    Produto? produto = ctx.Produtos.Find(id);

    if (produto != null) {
        return Results.Ok(produto);
    }
    
    return Results.NotFound();
});



app.MapPost("/produtos", async (Produto produto, AppDbContext db) =>
{
    db.Produtos.Add(produto);
    await db.SaveChangesAsync();
    return Results.Created($"/produtos/{produto.Id}", produto);
});

app.MapPut("/produtos/{id}", async (int id, Produto input, AppDbContext db) =>
{
    var produto = await db.Produtos.FindAsync(id);
    if (produto is null) return Results.NotFound();

    produto.Nome = input.Nome;
    produto.Preco = input.Preco;
    produto.CategoriaId = input.CategoriaId;

    await db.SaveChangesAsync();
    return Results.Ok(produto);
});

app.MapDelete("/produtos/{id}", async (int id, AppDbContext db) =>
{
    var produto = await db.Produtos.FindAsync(id);
    if (produto is null) return Results.NotFound();

    db.Produtos.Remove(produto);
    await db.SaveChangesAsync();
    return Results.NoContent();
});

// Endpoints de Categorias
app.MapGet("/categorias", async (AppDbContext db) =>
    await db.Categorias.ToListAsync());

app.MapGet("/categorias/{id}", async (int id, AppDbContext db) =>
{
    var categoria = await db.Categorias.FindAsync(id);
    return categoria is not null ? Results.Ok(categoria) : Results.NotFound();
});

app.Run();