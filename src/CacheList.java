/**
 * Created by creed on 26.11.16.
 */
public class CacheList<V> {
    private int size;
    private CacheIterator<V> head = null;
    private CacheIterator<V> tail = null;

    public CacheIterator<V> pushFront(V value) {
        if (size == 0) {
            head = new CacheIterator<V>(value);
            tail = head;
        } else {
            CacheIterator<V> newHead = new CacheIterator<V>(value);
            newHead.setNext(head);
            head.setPrev(newHead);
            head = newHead;
        }
        size++;
        return head;
    }

    public void removeByIterator(CacheIterator<V> iterator) {
        if (iterator == null) {
            throw new IllegalStateException("Iterator is null");
        }
        size--;
        CacheIterator<V> prev = iterator.getPrev();
        CacheIterator<V> next = iterator.getNext();
        if (prev != null) {
            prev.setNext(next);
        } else {
            head = next;
        }
        if (next != null) {
            next.setPrev(prev);
        } else {
            tail = prev;
        }
    }

    public int getSize() {
        return size;
    }

    public CacheIterator<V> getHead() {
        return head;
    }

    public CacheIterator<V> getTail() {
        return tail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("CacheList{ ");
        CacheIterator<V> iter = head;
        while(iter != null) {
            builder.append(iter.getValue().toString());
            if (iter.hasNext()) {
                builder.append(" , ");
            }
            iter = iter.getNext();
        }
        builder.append(" }");
        return builder.toString();
    }
}
