import java.util.Arrays;

public class TestComplejidad {
    public static void main(String[] args) {
        int[] array = {5, 2, 8, 1, 9, 3};
        int objetivo = 8;
        
        // Test complejidad temporal
        
        System.out.println("=== COMPLEJIDAD TEMPORAL ===");

        long inicio = System.nanoTime();
        int resultadoLineal = ComplejidadTemporal.sumaLineal(array);
        long fin = System.nanoTime();
        System.out.println("Suma lineal O(n): " + resultadoLineal + " - Tiempo: " + (fin - inicio) + " ns");
        
        inicio = System.nanoTime();
        int resultadoBinario = ComplejidadTemporal.busquedaBinaria(
            Arrays.copyOf(array, array.length), objetivo);
        fin = System.nanoTime();
        System.out.println("Búsqueda binaria O(log n): " + resultadoBinario + " - Tiempo: " + (fin - inicio) + " ns");

        // Test eficiencia Fibonacci

        System.out.println("\n=== EFICIENCIA FIBONACCI ===");

        int n = 10;

        inicio = System.nanoTime();
        int fibIterativo = EficienciaAlgoritmos.Fibonacci.fibIterativo(n);
        fin = System.nanoTime();
        System.out.println("Fibonacci iterativo O(n): " + fibIterativo + " - Tiempo: " + (fin - inicio) + " ns");

        inicio = System.nanoTime();
        int fibMemo = EficienciaAlgoritmos.Fibonacci.fibMemoization(n);
        fin = System.nanoTime();
        System.out.println("Fibonacci memoization O(n): " + fibMemo + " - Tiempo: " + (fin - inicio) + " ns");

        // Solo para n pequeño por la complejidad exponencial

        if (n <= 10) {
            inicio = System.nanoTime();
            int fibExp = EficienciaAlgoritmos.Fibonacci.fibExponencial(n);
            fin = System.nanoTime();
            System.out.println("Fibonacci exponencial O(2n): " + fibExp + " - Tiempo: " + (fin - inicio) + " ns");
        }

        // Análisis de casos

        System.out.println("\n=== ANALISIS DE CASOS ===");
        EficienciaAlgoritmos.AnalisisCasos.algoritmoAdaptativo(array);
    }
}
