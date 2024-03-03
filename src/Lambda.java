import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 12: Explicación de una expresión lambda
        //Una expresión lambda es una función anónima que puede ser utilizada como argumento para otra función. Se compone de parámetros, una flecha (->) y un cuerpo. Se utiliza para crear instancias de interfaces funcionales (interfaces que contienen un único método abstracto).

        // Ejercicio 13: Función integral
        System.out.println("\nEjercicio 13: Función integral:");
        double resultIntegral = integral(0, 1, 0.001, x -> x * x);
        System.out.println("Resultado de la integral: " + resultIntegral);

        // Ejercicio 14: Generación de streams
        System.out.println("\nEjercicio 14: Generación de streams:");
        generarStreams();

        // Ejercicio 15: Expresiones lambda y streams para ejercicio 2
        System.out.println("\nEjercicio 15: Expresiones lambda y streams para ejercicio 2:");

        // 1. La suma 0 + 1 + 2 + ... + n
        System.out.println("Suma de 0 hasta 5: " + sumaN(5));

        // 2. El factorial de un número
        System.out.println("Factorial de 5: " + factorial(5));

        // 3. La potencia n-ésima de un número natural
        System.out.println("Potencia de 2 elevado a 3: " + potencia(2, 3));

        // 4. La suma de los elementos de una lista de números
        List<Integer> listaNumeros = List.of(1, 2, 3, 4, 5);
        System.out.println("Suma de lista: " + sumaLista(listaNumeros));

        // 5. La media aritmética de una lista de números
        System.out.println("Media de lista: " + mediaLista(listaNumeros));

        // 6. La desviación típica de una lista de números
        System.out.println("Desviación típica de lista: " + desviacionTipica(listaNumeros));

        // 7. La suma de los primeros números pares hasta n asumiendo n ≥ 2
        System.out.println("Suma de primeros números pares hasta 6: " + sumaPares(6));

        // 8. La suma de los elementos pares de una lista de enteros
        System.out.println("Suma de elementos pares de lista: " + sumaParesLista(listaNumeros));

        // 9. Obtener lista de números pares de una lista inicial
        List<Integer> listaPares = obtenerListaPares(listaNumeros);
        System.out.println("Lista de números pares: " + listaPares);

        // 10. La lista de los primeros números pares hasta n asumiendo n ≥ 2
        List<Integer> listaNumerosPares = listaPares(6);
        System.out.println("Lista de primeros números pares hasta 6: " + listaNumerosPares);

        // 11. Producto escalar de dos listas de números
        List<Integer> lista1 = List.of(1, 2, 3);
        List<Integer> lista2 = List.of(2, 4, 6);
        System.out.println("Producto escalar de listas: " + productoEscalar(lista1, lista2));

        // 12. El elemento n-ésimo de la sucesión de Fibonacci
        System.out.println("Elemento 6 de Fibonacci: " + fibonacci(6));
    }

    // 1. La suma 0 + 1 + 2 + ... + n
    public static int sumaN(int n) {
        return IntStream.rangeClosed(0, n).sum();
    }

    // 2. El factorial de un número
    public static long factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    // 3. La potencia n-ésima de un número natural
    public static double potencia(double base, int exponente) {
        return exponente == 0 ? 1 : base * potencia(base, exponente - 1);
    }

    // 4. La suma de los elementos de una lista de números
    public static int sumaLista(List<Integer> lista) {
        return lista.isEmpty() ? 0 : lista.get(0) + sumaLista(lista.subList(1, lista.size()));
    }

    // 5. La media aritmética de una lista de números
    public static double mediaLista(List<Integer> lista) {
        return (double) sumaLista(lista) / lista.size();
    }

    // 6. La desviación típica de una lista de números
    public static double desviacionTipica(List<Integer> lista) {
        double media = mediaLista(lista);
        double sumatoria = lista.stream()
                                .mapToDouble(num -> Math.pow(num - media, 2))
                                .sum();
        return Math.sqrt(sumatoria / lista.size());
    }

    // 7. La suma de los primeros números pares hasta n asumiendo n ≥ 2
    public static int sumaPares(int n) {
        return IntStream.rangeClosed(2, n)
                        .filter(num -> num % 2 == 0)
                        .sum();
    }

    // 8. La suma de los elementos pares de una lista de enteros
    public static int sumaParesLista(List<Integer> lista) {
        return lista.stream()
                    .filter(num -> num % 2 == 0)
                    .mapToInt(Integer::intValue)
                    .sum();
    }

    // 9. Dada una lista de números naturales mayores o iguales que 2, obtiene otra lista con los números pares
    public static List<Integer> obtenerListaPares(List<Integer> lista) {
        return lista.stream()
                    .filter(num -> num % 2 == 0)
                    .collect(Collectors.toList());
    }

    // 10. La lista de los primeros números pares hasta n asumiendo n ≥ 2
    public static List<Integer> listaPares(int n) {
        return IntStream.rangeClosed(2, n)
                        .filter(num -> num % 2 == 0)
                        .boxed()
                        .collect(Collectors.toList());
    }

    // 11. Producto escalar de dos listas de números no vacías y del mismo tamaño
    public static int productoEscalar(List<Integer> lista1, List<Integer> lista2) {
        return IntStream.range(0, lista1.size())
                        .map(i -> lista1.get(i) * lista2.get(i))
                        .sum();
    }

    // 12. El elemento n-ésimo de la sucesión de Fibonacci
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

        // Ejercicio 16: Utilización de expresiones lambda y streams en ejercicio 13
        System.out.println("\nEjercicio 16: Utilización de expresiones lambda y streams en ejercicio 13:");
        double resultIntegralStream = integralStream(0, 1, 0.001, x -> x * x);
        System.out.println("Resultado de la integral con stream: " + resultIntegralStream);

        // Ejercicio 17: Clase Persona y Clase Personas
        System.out.println("\nEjercicio 17: Clase Persona y Clase Personas:");
        Personas personas = new Personas();
        personas.annadirPersona(new Persona("Juan", LocalDate.of(1990, 5, 15)));
        personas.annadirPersona(new Persona("Maria", LocalDate.of(1985, 8, 20)));
        personas.annadirPersona(new Persona("Pedro", LocalDate.of(2000, 3, 10)));

        System.out.println("Persona más joven: " + personas.elMasJoven().getNombre());
        System.out.println("Suma de edades: " + personas.calcularSumaEdades());
        System.out.println("Edad mínima: " + personas.calcularEdadMinima());
        System.out.println("Media de edad: " + personas.calcularMediaDeEdad());
    }

    // Ejercicio 12: Explicación de una expresión lambda
    public static void explicarExpresionLambda() {
        System.out.println("Una expresión lambda es una función anónima que puede ser utilizada como argumento " +
                "para otra función. Se compone de parámetros, una flecha (->) y un cuerpo. Se utiliza para " +
                "crear instancias de interfaces funcionales (interfaces que contienen un único método abstracto).");
    }

    // Ejercicio 13: Función integral
    public static double integral(double a, double b, double h, Function<Double, Double> funcion) {
        double result = 0;
        for (double x = a; x < b; x += h) {
            result += funcion.apply(x) * h;
        }
        return result;
    }

    // Ejercicio 14: Generación de streams
    public static void generarStreams() {
        // 1. Stream de números mediante el método estático of de IntStream
        IntStream stream1 = IntStream.of(1, 2, 3, 4, 5);
        stream1.forEach(System.out::println);

        // 2. Stream de números mediante el método estático range de IntStream
        IntStream stream2 = IntStream.range(1, 6);
        stream2.forEach(System.out::println);

        // 3. Stream de números mediante el método estático iterate de IntStream
        IntStream stream3 = IntStream.iterate(1, n -> n + 1).limit(5);
        stream3.forEach(System.out::println);

        // 4. Stream de números aleatorios utilizando el método doubles de Random
        Random random = new Random();
        random.doubles(5).forEach(System.out::println);
    }

    // Ejercicio 16: Utilización de expresiones lambda y streams en ejercicio 13
    public static double integralStream(double a, double b, double h, Function<Double, Double> funcion) {
        return IntStream.iterate(0, n -> n + h)
                        .limit((long) ((b - a) / h))
                        .mapToDouble(n -> funcion.apply(a + n * h) * h)
                        .sum();
    }

    // Ejercicio 17: Clase Persona y Clase Personas
    static class Persona {
        private String nombre;
        private LocalDate fechaDeNacimiento;

        public Persona(String nombre, LocalDate fechaDeNacimiento) {
            this.nombre = nombre;
            this.fechaDeNacimiento = fechaDeNacimiento;
        }

        public long calcularEdad() {
            return LocalDate.now().getYear() - fechaDeNacimiento.getYear();
        }

        public String getNombre() {
            return nombre;
        }

        public LocalDate getFechaDeNacimiento() {
            return fechaDeNacimiento;
        }
    }

    static class Personas {
        private List<Persona> personas;

        public Personas() {
            personas = new ArrayList<>();
        }

        public void annadirPersona(Persona persona) {
            personas.add(persona);
        }

        public Persona elMasJoven() {
            return personas.stream()
                          .min(Comparator.comparing(Persona::getFechaDeNacimiento))
                          .orElse(null);
        }

        public long calcularSumaEdades() {
            return personas.stream()
                          .mapToLong(Persona::calcularEdad)
                          .sum();
        }

        public long calcularEdadMinima() {
            return personas.stream()
                          .mapToLong(Persona::calcularEdad)
                          .min()
                          .orElse(0);
        }

        public double calcularMediaDeEdad() {
            return personas.stream()
                          .mapToLong(Persona::calcularEdad)
                          .average()
                          .orElse(0);
        }
    }
}

