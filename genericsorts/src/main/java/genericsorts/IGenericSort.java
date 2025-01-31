package genericsorts;

public interface IGenericSort<T extends Comparable<T>> {
    public T[] sort(T[] array);
}
