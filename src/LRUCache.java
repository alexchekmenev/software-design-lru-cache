import javafx.util.Pair;

import java.util.*;

/**
 * Implementation of popular caching technique
 */
public class LRUCache<K, V> {
    private HashMap<K, CacheIterator<Pair<K, V>>> hashMap = new HashMap<>();
    private int capacity;
    private CacheList<Pair<K, V>> list = new CacheList<>();

    /**
     * Constructs a new instance of the {@link LRUCache} class with given {@code capacity}
     * @param capacity capacity
     */
    public LRUCache(int capacity) {
        assert (capacity > 0);
        this.capacity = capacity;
    }

    /**
     * Returns the value of the given {@code key} (if exists in {@link LRUCache})
     * @param key key which value should be returned
     * @return value
     */
    public V get(K key) throws IllegalStateException {
        assert (key != null);
        if (hashMap.containsKey(key)) {
            CacheIterator<Pair<K, V>> iterator = hashMap.get(key);
            Pair<K, V> pair = iterator.getValue();
            list.removeByIterator(iterator);
            hashMap.put(key, list.pushFront(pair));
            return pair.getValue();
        }
        return null;
    }

    /**
     * Stores the given key-value pair into the {@link LRUCache}
     * @param key key
     * @param value value
     */
    public void put(K key, V value) {
        assert (key != null);
        if (hashMap.containsKey(key)) {
            CacheIterator<Pair<K, V>> iterator = hashMap.get(key);
            list.removeByIterator(iterator);
            hashMap.remove(key);
        } else {
            if (list.getSize() == capacity) {
                K tailKey = list.getTail().getValue().getKey();
                hashMap.remove(tailKey);
                list.removeByIterator(list.getTail());
            }
        }
        hashMap.put(key, list.pushFront(new Pair<>(key, value)));
    }

    public String toString() {
        return list.toString();
    }
}
