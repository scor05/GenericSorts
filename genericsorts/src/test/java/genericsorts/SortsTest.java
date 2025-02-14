package genericsorts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SortsTest {

    @Test
    public void shouldReturnMergeSortedArrays() {
        // Probar cinco casos: array vacía, array de un elemento, array ya ordenada, array desordenada y array de elementos repetidos
        Integer[] arrayUnordered = {5, 3, 1, 4, 2};
        Integer[] arrayOrdered = {1, 2, 3, 4, 5};
        Integer[] arrayRepeated = {1, 1, 2, 2, 3};
        Integer[] arrayEmpty = {};
        Integer[] arraySingle = {1};

        // Array desordenada y ordenada a la vez
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sortedUnorderedArray = mergeSort.sort(arrayUnordered);
        Integer[] sortedOrderedArray = mergeSort.sort(arrayOrdered);
        for (int i = 0; i < arrayUnordered.length; i++) {
            assertTrue(sortedUnorderedArray[i] == (i+1));
            assertTrue(sortedOrderedArray[i] == arrayOrdered[i]);
        }

        // Repetida
        Integer[] sortedRepeatedArray = mergeSort.sort(arrayRepeated);
        assertTrue(sortedRepeatedArray[0] == 1);
        assertTrue(sortedRepeatedArray[1] == 1);
        assertTrue(sortedRepeatedArray[2] == 2);
        assertTrue(sortedRepeatedArray[3] == 2);
        assertTrue(sortedRepeatedArray[4] == 3);

        // Array vacía y única
        Integer[] sortedEmptyArray = mergeSort.sort(arrayEmpty);
        Integer[] sortedSingleArray = mergeSort.sort(arraySingle);
        assertTrue(sortedEmptyArray.length == 0);
        assertTrue(sortedSingleArray.length == 1);
        assertTrue(sortedSingleArray[0] == 1);  
    }

    @Test
    public void shouldReturnInsertionSortedArrays() {
        Integer[] arrayUnordered = {5, 3, 1, 4, 2};
        Integer[] arrayOrdered = {1, 2, 3, 4, 5};
        Integer[] arrayRepeated = {1, 1, 2, 2, 3};
        Integer[] arrayEmpty = {};
        Integer[] arraySingle = {1};

        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] sortedUnorderedArray = insertionSort.sort(arrayUnordered);
        Integer[] sortedOrderedArray = insertionSort.sort(arrayOrdered);
        for (int i = 0; i < arrayUnordered.length; i++) {
            assertTrue(sortedUnorderedArray[i] == (i+1));
            assertTrue(sortedOrderedArray[i] == arrayOrdered[i]);
        }

        Integer[] sortedRepeatedArray = insertionSort.sort(arrayRepeated);
        assertTrue(sortedRepeatedArray[0] == 1);
        assertTrue(sortedRepeatedArray[1] == 1);
        assertTrue(sortedRepeatedArray[2] == 2);
        assertTrue(sortedRepeatedArray[3] == 2);
        assertTrue(sortedRepeatedArray[4] == 3);

        Integer[] sortedEmptyArray = insertionSort.sort(arrayEmpty);
        Integer[] sortedSingleArray = insertionSort.sort(arraySingle);
        assertTrue(sortedEmptyArray.length == 0);
        assertTrue(sortedSingleArray.length == 1);
        assertTrue(sortedSingleArray[0] == 1);  
    }

    @Test
    public void shouldReturnRadixSortedArray(){
        Integer[] arrayUnordered = {5, 3, 1, 4, 2};
        Integer[] arrayOrdered = {1, 2, 3, 4, 5};
        Integer[] arrayRepeated = {1, 1, 2, 2, 3};
        Integer[] arrayEmpty = {};
        Integer[] arraySingle = {1};

        RadixSort<Integer> radixSort = new RadixSort<>(Integer::intValue);
        Integer[] sortedUnorderedArray = radixSort.sort(arrayUnordered);
        Integer[] sortedOrderedArray = radixSort.sort(arrayOrdered);
        for (int i = 0; i < arrayUnordered.length; i++) {
            assertTrue(sortedUnorderedArray[i] == (i+1));
            assertTrue(sortedOrderedArray[i] == arrayOrdered[i]);
        }

        Integer[] sortedRepeatedArray = radixSort.sort(arrayRepeated);
        assertTrue(sortedRepeatedArray[0] == 1);
        assertTrue(sortedRepeatedArray[1] == 1);
        assertTrue(sortedRepeatedArray[2] == 2);
        assertTrue(sortedRepeatedArray[3] == 2);
        assertTrue(sortedRepeatedArray[4] == 3);

        Integer[] sortedEmptyArray = radixSort.sort(arrayEmpty);
        Integer[] sortedSingleArray = radixSort.sort(arraySingle);
        assertTrue(sortedEmptyArray.length == 0);
        assertTrue(sortedSingleArray.length == 1);
        assertTrue(sortedSingleArray[0] == 1);  
    }

    @Test 
    public void ShouldReturnCycleSortedArray(){
        Integer[] arrayUnordered = {5, 3, 1, 4, 2};
        Integer[] arrayOrdered = {1, 2, 3, 4, 5};
        Integer[] arrayRepeated = {1, 1, 2, 2, 3};
        Integer[] arrayEmpty = {};
        Integer[] arraySingle = {1};
        
        CycleSort<Integer> cyclesort = new CycleSort<>();
        Integer[] sortedUnorderedArray = cyclesort.sort(arrayUnordered);
        Integer[] sortedOrderedArray = cyclesort.sort(arrayOrdered);
        for (int i = 0; i < arrayUnordered.length; i++) {
            assertTrue(sortedUnorderedArray[i] == (i+1));
            assertTrue(sortedOrderedArray[i] == arrayOrdered[i]);
        }

        Integer[] sortedRepeatedArray = cyclesort.sort(arrayRepeated);
        assertTrue(sortedRepeatedArray[0] == 1);
        assertTrue(sortedRepeatedArray[1] == 1);
        assertTrue(sortedRepeatedArray[2] == 2);
        assertTrue(sortedRepeatedArray[3] == 2);
        assertTrue(sortedRepeatedArray[4] == 3);

        Integer[] sortedEmptyArray = cyclesort.sort(arrayEmpty);
        Integer[] sortedSingleArray = cyclesort.sort(arraySingle);
        assertTrue(sortedEmptyArray.length == 0);
        assertTrue(sortedSingleArray.length == 1);
        assertTrue(sortedSingleArray[0] == 1);  

    }

    @Test
    public void shouldReturnQuickSortedArray(){
        Integer[] arrayUnordered = {5, 3, 1, 4, 2};
        Integer[] arrayOrdered = {1, 2, 3, 4, 5};
        Integer[] arrayRepeated = {1, 1, 2, 2, 3};
        Integer[] arrayEmpty = {};
        Integer[] arraySingle = {1};
        
        QuickSort<Integer> quickSort = new QuickSort<>();
        Integer[] sortedUnorderedArray = quicksort.sort(arrayUnordered);
        Integer[] sortedOrderedArray = quicksort.sort(arrayOrdered);
        for (int i = 0; i < arrayUnordered.length; i++) {
            assertTrue(sortedUnorderedArray[i] == (i+1));
            assertTrue(sortedOrderedArray[i] == arrayOrdered[i]);
        }

        Integer[] sortedRepeatedArray = quicksort.sort(arrayRepeated);
        assertTrue(sortedRepeatedArray[0] == 1);
        assertTrue(sortedRepeatedArray[1] == 1);
        assertTrue(sortedRepeatedArray[2] == 2);
        assertTrue(sortedRepeatedArray[3] == 2);
        assertTrue(sortedRepeatedArray[4] == 3);

        Integer[] sortedEmptyArray = quicksort.sort(arrayEmpty);
        Integer[] sortedSingleArray = quicksort.sort(arraySingle);
        assertTrue(sortedEmptyArray.length == 0);
        assertTrue(sortedSingleArray.length == 1);
        assertTrue(sortedSingleArray[0] == 1);  

    }
}
