public class SortingDemo {
    public static void main(String[] args) {
        // Definir datasets de prueba
        int[][] datasets = {
            {8, 3, 6, 3, 9},           // A: mezclado con duplicados
            {5, 4, 3, 2, 1},           // B: orden inverso
            {1, 2, 3, 4, 5},           // C: ya ordenado
            {2, 2, 2, 2},              // D: todos duplicados
            {9, 1, 8, 2}               // E: mezclado
        };
        String[] datasetNames = {"A", "B", "C", "D", "E"};

        // Probar cada algoritmo

        testAlgorithm("Insertion Sort", datasets, datasetNames);
        testAlgorithm("Selection Sort", datasets, datasetNames);

        testAlgorithm("Bubble Sort", datasets, datasetNames);

        // Mostrar trazas detalladas para un dataset específico
        System.out.println("\n=== TRAZAS DETALLADAS ===");
        showDetailedTraces();
    }


    private static void testAlgorithm(String algorithmName, int[][] datasets, String[] names) {
        System.out.println("\n=== " + algorithmName + " ===");
        
        // Probar cada dataset
        for (int i = 0; i < datasets.length; i++) {
            int[] original = datasets[i].clone(); // Para preservar el dataset original en cada prueba
            int[] array = datasets[i].clone();
            
            System.out.print("Dataset " + names[i] + ": ");
            SortingUtils.printArray(original);
            
            // Aplicar el algoritmo correspondiente
            switch (algorithmName) {

                case "Insertion Sort":
                    InsertionSort.sort(array);
                    break;
                case "Selection Sort":
                    SelectionSort.sort(array);
                    break;

                case "Bubble Sort":
                    BubbleSort.sort(array);
                    break;
            }
            
            System.out.print("Ordenado: ");
            SortingUtils.printArray(array);
            System.out.println();
        }
    }

    private static void showDetailedTraces() {
        int[] testArray = {8, 3, 6, 3, 9};
        
        System.out.println("Array original: ");
        SortingUtils.printArray(testArray);
        
        System.out.println("\n--- Insertion Sort con trazas ---");
        InsertionSort.sort(testArray.clone(), true);
        
        System.out.println("\n--- Selection Sort con trazas ---");
        SelectionSort.sort(testArray.clone(), true);
        
        System.out.println("\n--- Bubble Sort con trazas ---");
        BubbleSort.sort(testArray.clone(), true);
    }


    
}
