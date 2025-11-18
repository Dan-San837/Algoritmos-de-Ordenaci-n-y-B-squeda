import java.util.Arrays;

public final class SelectionSort {

    public static void sort(int[] a) {
        sort(a, false);
    }

    public static void sort(int[] a, boolean trace) {
        if (a == null || a.length <= 1) {
            if (trace) System.out.println("Arreglo nulo o de tamaño <= 1. No se necesita ordenar.");
            return;
        }

        int swapCount = 0;

        if (trace) {
            System.out.println("--- INICIO SELECTION SORT ---");
            // Usamos Arrays.toString() para la traza interna
            System.out.println("Arreglo inicial: " + Arrays.toString(a));
        }

        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            if (trace) {
                System.out.println("\n--- Pasada " + (i + 1) + " ---");
                System.out.println("   Mínimo encontrado: " + a[minIndex] + " (en pos [" + minIndex + "])");
            }

            if (minIndex != i) {
                if (trace) {
                    System.out.println("   Intercambiando pos [" + i + "] (" + a[i] + ") con pos [" + minIndex + "] (" + a[minIndex] + ")");
                }

                // Se hace un cambio en el arreglo
                // Ahora usamos el método swap de la clase de utilidades
                SortingUtils.swap(a, i, minIndex);
                swapCount++;

            } else {
                if (trace) {
                    System.out.println("   El mínimo ya está en su lugar. No hay swap.");
                }
            }

            if (trace) {
                // Usamos Arrays.toString() para la traza interna
                System.out.println("   Arreglo actual: " + Arrays.toString(a));
            }
        }

        if (trace) {
            System.out.println("\n--- FIN SELECTION SORT ---");
            // Usamos Arrays.toString() para la traza interna
            System.out.println("Arreglo final: " + Arrays.toString(a));
            System.out.println("TOTAL DE INTERCAMBIOS (SWAPS) REALIZADOS: " + swapCount);
        }
    }


}