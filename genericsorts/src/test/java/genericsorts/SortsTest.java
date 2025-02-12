package genericsorts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SortsTest {

    @Test
    public void shouldReturnMergeSortedArray() {
        Integer[] array = {5, 3, 1, 4, 2};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        Integer[] sortedArray = mergeSort.sort(array);
        assertTrue(sortedArray[0] == 1);
        assertTrue(sortedArray[1] == 2);
        assertTrue(sortedArray[2] == 3);
        assertTrue(sortedArray[3] == 4);
        assertTrue(sortedArray[4] == 5);
    }
}
