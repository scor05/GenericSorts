package genericsorts;

public class InsertionSort<T extends Comparable<T>> implements IGenericSort<T> {
     /*
     * Complejidad temporal: T(n) = (1 + 2n) + 3 + (1 + 2n)(1 + 4n)(1 + 4 + 1) + 2
     * Notación O(n^2)
     */

    public T[] sort(T[] arr) {
        // Casos base donde se tiene un array de un elemento, complejidad O(1)
        if (arr == null || arr.length < 2) {
            return arr;
        }
        insertionSort(arr);
        return arr;
    }

    public void insertionSort(T[] arr){
        int n = arr.length; // 2 instrucciones atómicas
        for (int i = 1; i < n; i++) { // (1 + 2n)
            T key = arr[i]; // 2
            int j = i - 1; // 1

            // arr[j].compareTo() -> 1 instrucción por arr[j]
            // 2 por compareTo()
            // 3 por comparación > 0
            while (j >= 0 && arr[j].compareTo(key) > 0) { // (1 + 2n)(1 + 4n)
                arr[j + 1] = arr[j]; // (1 + 2n)(1 + 4n)(4)
                j--; // (1 + 2n)(1 + 4n)(1)
            }
            arr[j + 1] = key; // 2
        }
    }
}
