package genericsorts;

public class CycleSort<T extends Comparable<T>>implements IGenericSort<T> {
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
             return array;
        }
    }
}
