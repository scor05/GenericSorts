package genericsorts;

public class CycleSort<T extends Comparable<T>> implements IGenericSort<T> {
    @Override
    public T[] sort(T[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        
        int n = array.length;
        //Se it
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            T item = array[cycleStart];
            int pos = cycleStart;
            
            for (int i = cycleStart + 1; i < n; i++) {
                if (array[i].compareTo(item) < 0) {
                    pos++;
                }
            }
            
            if (pos == cycleStart) {
                continue;
            }
            
            while (item.equals(array[pos])) {
                pos++;
            }
            
            T temp = array[pos];
            array[pos] = item;
            item = temp;
            
            while (pos != cycleStart) {
                pos = cycleStart;
                
                for (int i = cycleStart + 1; i < n; i++) {
                    if (array[i].compareTo(item) < 0) {
                        pos++;
                    }
                }
                
                while (item.equals(array[pos])) {
                    pos++;
                }
                
                temp = array[pos];
                array[pos] = item;
                item = temp;
            }
        }
        return array;
    }
}
