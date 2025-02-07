package genericsorts;

import java.util.ArrayList;
import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        Random random = new Random();
        int arraySize = random.nextInt(3000-10+1) + 10;
        Integer[] randomArray = new Integer[arraySize]; // Array de números aleatorios para probar los algorítmos
        for (int i = 0; i < randomArray.length; i++){
            randomArray[i] = random.nextInt(3000);
        }
        /**
         * Clave de posiciones de sortedArrays:
         * 0: Quicksort
         * 1: Mergesort
         * 2: Insertionsort
         * 3: Radixsort
         * 4: Cyclesort
         */
        ArrayList<Integer[]> sortedArrays = new ArrayList<>();
        MergeSort<Integer> mergeSort = new MergeSort<>();
        // InsertionSort<Integer> insertionSort = new InsertionSort<>();
        QuickSort<Integer> quickSort = new QuickSort<>();
        RadixSort<Integer> radixSort = new RadixSort<>();
        //CycleSort<Integer> cycleSort = new CycleSort<>();
        sortedArrays.add(mergeSort.sort(randomArray));
        // sortedArrays.add(insertionSort.sort(randomArray));
        sortedArrays.add(quickSort.sort(randomArray));
        sortedArrays.add(radixSort.sort(randomArray));
        // sortedArrays.add(cycleSort.sort(randomArray));
        System.out.println("Las arrays ordenadas por cada una de los algorítmos son:");
        String[] sortNames = {"Quicksort", "Mergesort", "Insertionsort", "Radixsort", "Cyclesort"};
        for (int i = 0; i < sortNames.length; i++){
            System.out.println(sortNames[i] + ":");
            for (int j = 0; j < sortedArrays.get(i).length; j++){
                System.out.print(sortedArrays.get(i)[j] + " ");
            }
            System.out.println("-".repeat(50));
        }
        System.out.println("Tamaño del array: " + arraySize);
    }
}


