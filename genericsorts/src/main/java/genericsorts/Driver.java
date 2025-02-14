package genericsorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
public class Driver {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arraySizes = {10, 50, 100, 250, 500, 1000, 2000, 3000};
        HashMap<Integer[], Integer> randomArrays = new HashMap<>(); // HashMap con array[] al azar y su tamaño respectivo.
        for (int size : arraySizes) {
            Integer[] randomArray = new Integer[size];
            for (int i = 0; i < randomArray.length; i++){
                randomArray[i] = random.nextInt(5000) + 1;
            }
            randomArrays.put(randomArray, size);
        }

        HashMap<Integer[], Integer> randomSortedArrays = new HashMap<>(); // HashMap con array[] al azar y su tamaño respectivo.
        MergeSort<Integer> mergeSort = new MergeSort<>(); // Este sort es únicamente utilizado para tener las arrays ordenadas y probar el peor caso de los algorítmos
        for (Integer[] array : randomArrays.keySet()) {
            Integer[] sortedCopy = Arrays.copyOf(array, array.length);
            mergeSort.sort(array);
            randomSortedArrays.put(sortedCopy, randomArrays.get(array));
        }
        

        ArrayList<IGenericSort<Integer>> sorts = new ArrayList<>();
        sorts.add(new InsertionSort<Integer>());
        sorts.add(new MergeSort<Integer>());
        sorts.add(new RadixSort<Integer>(Integer::intValue));
        sorts.add(new QuickSort<Integer>());
        sorts.add(new CycleSort<Integer>());
        
        for (IGenericSort<Integer> sort : sorts) {
            System.out.println("\n" + "-".repeat(50));
            System.out.println(sort.getClass().getSimpleName());
            System.out.println("------------- Arrays no ordenados ----------------");
            for (Integer[] array : randomArrays.keySet()) {
                Integer[] arrayToSort = Arrays.copyOf(array, array.length);
                System.out.println("Tamaño del array: " + randomArrays.get(array));
                System.out.println("Tiempo transcurrido en milisegundos: " + profiler(new Runnable() {
                    @Override
                    public void run() {
                        sort.sort(arrayToSort);
                    }
                }));
            }

            System.out.println("------------- Arrays ya ordenados ----------------");
            for (Integer[] array : randomSortedArrays.keySet()) {
                Integer[] arrayToSort = Arrays.copyOf(array, array.length);
                System.out.println("Tamaño del array: " + randomSortedArrays.get(array));
                System.out.println("Tiempo transcurrido en milisegundos: " + profiler(new Runnable() {
                    @Override
                    public void run() {
                        sort.sort(arrayToSort);
                    }
                }));
            }
        }
    }   
    
    public static double profiler(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10,6); // retorna en milisegundos el tiempo
    }
}