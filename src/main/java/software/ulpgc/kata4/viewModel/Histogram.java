package software.ulpgc.kata4.viewModel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histogram<T> implements Iterable<T> {
    private final Map<T, Integer> map;

    public Histogram() {
        map = new HashMap<>();
    }
    
    public int count(T bin){
        return map.getOrDefault(bin, 0);
    }
    
    public void put(T bin){
        map.put(bin, count(bin) + 1);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }
}
