package genericsorts;

import java.util.Arrays;
import java.util.function.Function;

public class RadixSort<T extends Comparable<T>> implements IGenericSort<T> {
    /*
     * NOTA: La variación de RadixSort utilizada es LSD (Least Significant Digit).
     * Este sort únicamente funciona con enteros, por lo que se tiene que convertir de T a Integer.
     * Complejidad temporal: T(n) = 
     * Notación 
     */

    private Function<T, Integer> keyExtractor;

    public RadixSort(Function<T, Integer> keyExtractor) {
        this.keyExtractor = keyExtractor;
    }

    public T[] sort(T[] arr) {
        
        if (arr == null || arr.length == 0) {
            return arr;
        }

        int n = arr.length;
        int[] numericArr = Arrays.stream(arr)
                                .mapToInt(keyExtractor::apply)
                                .toArray();

        radixSort(numericArr, n);

        
        return Arrays.stream(numericArr)
                    .mapToObj(num -> Arrays.stream(arr)
                    .filter(e -> keyExtractor.apply(e).equals(num))
                    .findFirst()
                    .orElse(null))
                    .toArray(size -> Arrays.copyOf(arr, size));
    }

    private void radixSort(int[] arr, int n) {
        int max = getMax(arr, n);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    public int getMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public void countSort(int[] arr, int n, int exp) {
        int output[] = new int[n]; 
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++){
            count[(arr[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }
}
