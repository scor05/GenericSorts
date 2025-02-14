package genericsorts;

public class QuickSort<T extends Comparable<T>> implements IGenericSort<T> {
    /*
     * En el peor de los casos, Big O, el algoritmo tendrá una complejidad de O(n^2) debido a su recursión,
     * siendo así que el peor de los casos es cuando el pivote elegido es el mínimo o máximo cada vez 
     * que el algoritmo se parte, provocado porque la lista está ordenada.
     */
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        //Caso en el que el array es 0, O(1)
        quickSort(array, 0, array.length - 1);
        return array;
    }

    // Recursión hasta que toda la lista sea recorrida
    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    //Se parte la lista pdesde un pivote  
    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        //Se recorre este nuevo loop donde se generó el pivote
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
