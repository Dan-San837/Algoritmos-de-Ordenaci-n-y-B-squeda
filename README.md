# Algoritmos de Ordenación y Búsqueda

## Descripción
Implementar y comparar tres algoritmos de ordenación in-place sobre
arreglos pequeños, y validar su funcionamiento con trazas y casos de
prueba reproducibles.
## Estructura del Proyecto

```bash
  ed.u2.sorting/
├── BubbleSort.java      # Ordenamiento por burbuja 
├── SelectionSort.java   # Ordenamiento por selección
├── InsertionSort.java   # Ordenamiento por inserción
├── SortingUtils.java    # Utilidades comunes
└── SortingDemo.java     # Clase demo para pruebas
```
## Decisiones de Diseño
### Arquitectura
- **Paquete único** ```ed.u2.sorting``` para organización modular
- **Clases finales** para evitar herencia no intencionada
- **Métodos estáticos** siguiendo el patrón de utilidad

## Características Implementadas
- **In-place**: Modifican el arreglo original (eficiencia en memoria)
- **Sobrecarga con trazas**: Opción detallada para aprendizaje
- **Manejo de casos bordes**: Robustez ante entradas especiales

## Algoritmos Implementados
### Bubble Sort (BubbleSort.java)
- Estrategia: Comparaciones e intercambios de elementos adyacentes
- Optimización: Corte temprano si no hay intercambios

### Selection Sort (SelectionSort.java)
- Estrategia: Selecciona el mínimo y lo coloca en posición
- Característica: Número mínimo de intercambios (O(n))


### Insertion Sort (InsertionSort.java)
- Estrategia: Construye secuencia ordenada insertando elementos
- Eficiente: Para datos parcialmente ordenados


## Casos Borde Considerados
```bash
A = [8, 3, 6, 3, 9]    // Mixto con duplicados
B = [5, 4, 3, 2, 1]    // Orden inverso (peor caso)
C = [1, 2, 3, 4, 5]    // Ya ordenado (mejor caso)
D = [2, 2, 2, 2]       // Todos iguales
E = [9, 1, 8, 2]       // Mixto sin duplicados
```
### Manejo de Casos Especiales
- **Arreglo null**: Retorno inmediato sin error
- **Tamaño 0-1**: Considerado ya ordenado
- **Elementos duplicados**: Mantienen orden relativo (estabilidad)
- **Arreglo ya ordenado**: Optimizaciones aplicables

## Comparación de Recuentos de Movimientos/Intercambios
|Algoritmo|Intercambios (Swaps)|Movimientos Internos|Caso Óptimo|Caso Pésimo|
|----------------|--------------------------------|-----------------------------------|--------------------|--------------------|
|**Bubble Sort**|Alto (múltiples por elemento)|Muy alto|0 swaps (ya ordenado)|O(n²) swaps|
|**Selection Sort**|Mínimo (exactamente n-1)|Moderado|n-1 swaps|n-1 swaps|
|**Insertion Sort**|Variable|Alto (desplazamientos)|O(n) movimientos|O(n²) movimientos|

**Nota**: Selection Sort realiza exactamente n-1 intercambios sin importar la entrada, mientras que Bubble Sort puede realizar desde 0 hasta O(n²) intercambios.

## Cuándo Usar Cada Algoritmo - Guía Práctica
|Criterio|Bubble Sort|Selection Sort|Insertion Sort|
|------------|------------------|----------------------|---------------------|
|**Datos pequeños (n < 50)**|⚠️ Aceptable|✅ Bueno|✅ Excelente|
|**Datos casi ordenados**|✅ Excelente (corte temprano)|❌ Pobre|✅ Óptimo|
|**Minimizar intercambios**|❌ Pobre|✅ Excelente|✅ Bueno|
|**Legibilidad de trazas**|✅ Muy claro (pasadas visibles)|✅ Claro (selecciones evidentes)|⚠️ Moderado|
|**Estabilidad**|✅ Estable|❌ Inestable|✅ Estable|
|**Uso educativo**|✅ Ideal para empezar|✅ Bueno para entender selección|✅ Bueno para entender inserción|

