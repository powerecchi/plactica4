import java.util.Arrays;
import java.util.HashMap;

public class EficienciaAlgoritmos {
    
    //Comparacion: Busqueda lineal vs binaria
    public static class Busquedas {

        //O(n) - Busqueda lineal(simple pero lenta para grandes datos)
        public static int busquedaLineal(int[] array, int objetivo) {
            for(int i = 0; i< array.length;i++){
                if(array[i] == objetivo) {
                    return i; 
                }
            }
            return -1;
        }

        //O(log n) - Busqueda binaria (rapida pero requiere array ordenado)

        public static int busquedaBinariaEficiente(int[] array, int objetivo) {
            Arrays.sort(array);//O(n log n) - costo inicial
            return busquedaBinaria(array, objetivo);
        }

        private static int busquedaBinaria(int[] array, int objetivo) {
            int izquierda = 0, derecha = array.length -1;
            while (izquierda <= derecha) {
                int medio = izquierda + (derecha - izquierda) / 2;
                if (array[medio] == objetivo) return medio;
                if (array[medio] < objetivo) izquierda = medio + 1;
                else derecha = medio -1;
            }
            return -1;
        }
    }

    //comparacion: diferentes enfoques para fibonacci

    public static class Fibonacci {

        //O(2n) - Muy eficiente

        public static int fibExponencial(int n) {
            if (n <= 1) return n;
            return fibExponencial(n - 1) + fibExponencial(n - 2);
        }

        // O(n) - Tiempo lineal, O(n) espacio
        public static int fibMemoization(int n) {
            int[] memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return fibMemoHelper(n, memo);
        }
        
        private static int fibMemoHelper(int n, int[] memo) {
            if (n <= 1) return n;
            if (memo[n] != -1) return memo[n];
            memo[n] = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
            return memo[n];
        }

        // O(n) - Tiempo lineal, O(1) espacio (óptimo)
        public static int fibIterativo(int n) {
            if (n <= 1) return n;

            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }
    }

    // Análisis de casos: Mejor, peor y promedio
    public static class AnalisisCasos {
        // Búsqueda en array no ordenado
        public static int busquedaConAnalisis(int[] array, int objetivo) {
            // Mejor caso: O(1) - elemento en primera posición
            // Peor caso: O(n) - elemento no existe o está al final
            // Caso promedio: O(n) - elemento en posición media
            for (int i = 0; i < array.length; i++) {
                if (array[i] == objetivo) {
                    return i;
                }
            }
            return -1;
        }
        // Algoritmo con diferentes complejidades según entrada
        public static void algoritmoAdaptativo(int[] array) {
            // Si el array está ordenado: O(log n)
            // Si no está ordenado: O(n log n)

            if (estaOrdenado(array)) {
                System.out.println("Array ordenado - usando búsqueda binaria");
                // O(log n)
            } else {
                System.out.println("Array no ordenado - ordenando primero");
                Arrays.sort(array); // O(n log n)
                // luego O(log n)
                }
            }
            
            private static boolean estaOrdenado(int[] array) {
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        return false;
                    }
                }
                return true;
            }
        }
}
