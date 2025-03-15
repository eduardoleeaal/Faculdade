namespace Aula2;

class Program
{
    static void Main(string[] args)
    {
        /*
        Console.WriteLine("Hello, World!");

        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++)
        {
            var input = Console.ReadLine();
            numeros[i] = int.Parse(input);
        }

        foreach (var num in numeros)
        {
            Console.WriteLine(num);
        };
        */
        
        /*Aluno aluno = new Aluno();
        // aluno.Id = 1;
        aluno.Name = "Aluno";
        Console.WriteLine($"Id: {aluno.Id}, Name: {aluno.Name}");
        // CalcularImc();
        var pessoa = (nome:"Maria", peso:68.8, altura:1.65);
        CalcularImc(pessoa);*/
        ////////////////////////////////////////////////
        // Ex001();
        // Ex002();
        // Ex003();
    }

    /*public static void CalcularImc()
    {
        var pessoa = (nome: "Maria", peso: 68.8, altura: 1.65);
        var imc = pessoa.peso / (Math.Pow(pessoa.altura, 2));
        Console.WriteLine($"{pessoa.nome} tem um IMC de: {imc:F2}");
    }*/

    /*public static void CalcularImc((string nome, double peso, double altura) pessoa)
    {
        var imc = pessoa.peso / (Math.Pow(pessoa.altura, 2));
        Console.WriteLine($"{pessoa.nome} tem um IMC de: {imc:F2}");
    }*/
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Exercícios
    
    // Exercício 1
    /*private static void Ex001()
    {
        var input = Console.ReadLine();
        var num = int.Parse(input);

        if (num > 10)
        {
            Console.WriteLine("Numero maior que 10!");
        } else
        {
            Console.WriteLine("Numero menor ou igual a 10!");
        }
    }*/
    
    // Exercício 2
    /*private static void Ex002()
    {
        var input = Console.ReadLine();
        var num = double.Parse(input);
        
        var farenheit = (9 * num + 160) / 5;
        Console.WriteLine($"{num}ºC : {farenheit}ºF");
    }*/

    // Exercicio 3

    /*private static void Ex003()
    {
        double[] notas = new double[5];
        int[] pesos = new int[5];
        int somaPesos = 0;
        double media = 0;

        for (int i = 0; i < notas.Length; i++)
        {
            Console.Write($"Digite o valor da nota {i+1}: ");
            var input = Console.ReadLine();
            notas[i] = double.Parse(input);

            Console.Write($"Digite o peso da nota {i+1}: ");
            input = Console.ReadLine();
            pesos[i] = int.Parse(input);
            somaPesos += pesos[i];
        }

        for (int i = 0; i < notas.Length; i++)
        {
            media += notas[i] * pesos[i];
        }

        media /= somaPesos;
        Console.WriteLine($"Média ponderada: {media}");

    }*/

    
}