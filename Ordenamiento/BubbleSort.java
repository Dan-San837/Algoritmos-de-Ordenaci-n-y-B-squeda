public final class BubbleSort {
    public static void sort(int[] a) {
        sort(a, false);
    }
     public static void sort(int[] a, boolean trace) {
        // Casos bordes: si el arreglo es null o tiene 0-1 elementos, ya está "ordenado"
        if (a == null || a.length <= 1) {
            return;
        }
        
        int n = a.length;
        boolean swapped; // Bandera para la optimización de corte temprano
        int passCount = 0; // Contador de pasadas para análisis de eficiencia
        int swapCount = 0; // Contador de intercambios para comparar algoritmos
        

        // Bucle externo: controla cuántas pasadas completas se necesitan
        // (en el peor caso, n-1 pasadas para ordenar n elementos)
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reiniciamos la bandera al inicio de cada pasada
            passCount++; // Contamos esta pasada
            
            if (trace) {
                System.out.print("Pasada " + passCount + ": ");
            }
            

            // Bucle interno: compara elementos adyacentes en el subarreglo no ordenado
            // n-i-1 porque después de i pasadas, los últimos i elementos ya están en su posición final
            for (int j = 0; j < n - i - 1; j++) {
                // Si están en orden incorrecto, los intercambiamos
                if (a[j] > a[j + 1]) {
                    SortingUtils.swap(a, j, j + 1);
                    swapped = true; // Marcamos que hubo al menos un intercambio
                    swapCount++; // Contamos este intercambio
                    
                    if (trace) {
                        System.out.print("intercambiado " + a[j + 1] + " ↔ " + a[j] + " ");
                    }
                }
            }
            
            if (trace) {
                System.out.print("→ ");
                printArray(a);
            }
            
            // OPTIMIZACIÓN CLAVE: Si no hubo intercambios en esta pasada,
            // el arreglo ya está ordenado y podemos terminar anticipadamente
            // Esto mejora significativamente el caso mejor (arreglo ya ordenado)
            if (!swapped) {
                if (trace) {
                    System.out.println("Corte temprano - arreglo ya ordenado");
                }
                break; // Salimos del bucle externo
            }
        }
        
        // Estadísticas finales para análisis comparativo
        if (trace) {
            System.out.println("Total de pasadas: " + passCount);
            System.out.println("Total de intercambios: " + swapCount);
        }
    }
    
    private static void printArray(int[] a) {
        SortingUtils.printArray(a);
    }
}
