package genericsorts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SortsTest {

    @Test
    public void shouldReturnMergeSortedArray() {
        Integer[] array = {5, 3, 1, 4, 2};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sortedArray = mergeSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertTrue(sortedArray[i] == (i+1));
        }
    }

    @Test
    public void shouldReturnInsertionSortedArray() {
        Integer[] array = {5, 4, 1, 2, 3};
        InsertionSort<Integer> insertionSort = new InsertionSort<>();
        Integer[] sortedArray = insertionSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertTrue(sortedArray[i] == (i+1));
        }
    }

    @Test
    public void shouldReturnRadixSortedArray(){
        Integer[] array = {4, 5, 1, 3, 2};
        RadixSort<Integer> radixSort = new RadixSort<>(Integer::intValue);
        Integer[] sortedArray = radixSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertTrue(sortedArray[i] == (i+1));
        }
    }
}
