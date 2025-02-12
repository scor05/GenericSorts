package genericsorts;

public class MergeSort<T extends Comparable<T>> implements IGenericSort<T> {
    /*
     * Complejidad temporal: T(n) = 2*T(n/2) + O(n), donde T es el tiempo de ejecución de mergeSort().
     * Notación O(n*log(n))
     */

    public T[] sort(T[] array) {
        // Casos base donde se tiene un array de un elemento, complejidad O(1)
        if (array == null || array.length < 2) {
            return array;
        }
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(T[] arr, int l, int r) {
        // Complejidad recursiva 2T(n/2), pues se parte el array en dos por cada mergeSort() y se vuelve a llamar.
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(T[] arr, int l, int m, int r) {
        // Complejidad temporal O(n), pues solo se están iterando por cada elemento de cada array y luego copiándose esos datos, lo cual es O(n).
        int n1 = m - l + 1;
        int n2 = r - m;

        @SuppressWarnings("unchecked")
        T[] L = (T[]) new Comparable[n1];

        @SuppressWarnings("unchecked")
        T[] R = (T[]) new Comparable[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
