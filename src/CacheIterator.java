/**
 * Created by creed on 26.11.16.
 */
public class CacheIterator<V> {

    private CacheIterator<V> prev = null;
    private CacheIterator<V> next = null;
    private V value;

    public CacheIterator( V value, CacheIterator<V> prev, CacheIterator<V> next) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public CacheIterator(V value) {
        this.value = value;
    }

    public CacheIterator<V> getPrev() {
        return prev;
    }

    public boolean hasPrev() {
        return prev != null;
    }

    public void setPrev(CacheIterator<V> prev) {
        this.prev = prev;
    }

    public CacheIterator<V> getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public void setNext(CacheIterator<V> next) {
        this.next = next;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
