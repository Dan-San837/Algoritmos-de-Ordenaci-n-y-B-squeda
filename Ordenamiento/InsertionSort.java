
import java.util.Arrays;


public final class InsertionSort {

    /**
     * Este método  llama a la versión con traza, apagándola.
     * @param a Arreglo a ordenar.
     */
    public static void sort(int[] a) {
        sort(a, false);
    }

    /**
     *  Algoritmo, con la lógica de traza.
     * @param a  Arreglo a ordenar.
     * @param trace 'true' para imprimir el paso a paso.
     */
    public static void sort(int[] a, boolean trace) {

        // --- 1. MANEJO DE CASOS BORDE ---
        // Requisito: "maneja casos borde" [cite: 60]
        if (a == null || a.length <= 1) {
            if (trace) System.out.println("Arreglo nulo o de tamaño <= 1. No se necesita ordenar.");
            return; // Salimos del método; no hay nada que ordenar.
        }

        if (trace) {
            System.out.println("--- INICIO INSERTION SORT ---");
            System.out.println("Arreglo inicial: " + Arrays.toString(a));
        }

        // --- 2. LÓGICA DEL ALGORITMO ---

        // Empezamos en 'i = 1' (el segundo elemento).
        // La idea es que la parte [0...i-1] es la sub-lista "ya ordenada".
        // El bucle 'i' avanza haciendo crecer la parte ordenada.
        for (int i = 1; i < a.length; i++) {

            // 'elementoAInsertar' es la "carta" que tomamos de la parte
            // no ordenada para insertarla en la parte ordenada.
            int elementoAInsertar = a[i];

            // 'j' es el índice que usaremos para comparar hacia atras
            // dentro de la parte ordenada se empezara en la ultima posicion de esa parte ordenada
            // es decir (i-1)
            int j = i - 1;

            if (trace) {
                System.out.println("\n--- Pasada " + i + " (Insertando " + elementoAInsertar + ") ---");
            }

            // --- 3. BUCLE DE DESPLAZAMIENTO ---
            // Mientras 'j' no se salga del arreglo (j >= 0) Y
            // el elemento ordenado a[j] sea MAYOR que el que queremos insertar...
            while (j >= 0 && a[j] > elementoAInsertar) {

                // significa que elementoAInsertar debe ir antes.
                // Así que movemos el elemento grande (a[j]) una posición
                // a la derecha (a[j+1]) para hacerle espacio.

                // Requisito: "Trazas: imprimir posiciones movidas" [cite: 52]
                if (trace) {
                    System.out.println("   Moviendo " + a[j] + " de pos [" + j + "] a [" + (j + 1) + "]");
                }
                a[j + 1] = a[j]; // El desplazamiento
                j--; // Retrocedemos 'j' para seguir comparando hacia la izquierda.
            }

            // --- 4. Insercion inicial
            // El bucle 'while' terminó. Esto puede pasar por dos razones:
            // 1. 'j' se hizo -1 (Se llega al inicio del arreglo).
            // 2. Encontramos un a[j] que es MENOR o IGUAL.
            // En ambos casos la posición [j + 1] es el hueco
            // correcto donde debemos insertar nuestro elemento.
            a[j + 1] = elementoAInsertar;


            if (trace) {
                System.out.println("   Arreglo actual: " + Arrays.toString(a));
            }
        }

        if (trace) {
            System.out.println("\n--- FIN INSERTION SORT ---");
            System.out.println("Arreglo final: " + Arrays.toString(a));
        }
    }


}