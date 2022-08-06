public class ArrayDeque<T> {
    private int start=0, end=0;
    private int size = 8;
    T[] items = (T[])new Object[8];

    public ArrayDeque() {}
    private int getNext(int index) {
        return (index + 1) % size;
    }

    private int getPrev(int index) {
        return (index - 1 + size) % size;
    }

    private void resizeLarger() {
        T[] newItems = (T[]) new Object[size * 2];
        size = size * 2;
        int i;
        for (i = 0; start != end; i ++){
            newItems[i] = items[start];
            start = getNext(start);
        }
        start = 0;
        end = i;
        items = newItems;
    }

    private void resizeSmaller() {
        if (size == 8)
            return;
        T[] newItems = (T[]) new Object[size / 2];
        size = size / 2;
        int i;
        for (i = 0; start != end; i ++){
            newItems[i] = items[start];
            start = getNext(start);
        }
        start = 0;
        end = i;
        items = newItems;
    }

    public void addFirst(T item) {
        start = getPrev(start);
        items[start] = item;
        if (size() == size)
            resizeLarger();
    }

    public void addLast(T item) {
        items[end] = item;
        end = getNext(end);
        if (size() == size)
            resizeLarger();
    }

    public boolean isEmpty() {
        return start == end;
    }

    public int size() {
        return (end - start + size) % size;
    }

    public void printDeque() {
        int point=start;
        while(point != end) {
            System.out.print(items[point] + " ");
            point = getNext(point);
        }
    }

    public T removeFirst() {
        if(size() == 0)
            return null;
        T item = items[start];
        items[start] = null;
        start = getNext(start);
        if (size() * 1.0 / size <= 0.26) {
            resizeSmaller();
        }
        return item;
    }

    public T removeLast() {
        if(size() == 0)
            return null;
        end = getPrev(end);
        T item = items[end];
        items[end] = null;
        if (size() * 1.0 / size <= 0.26) {
            resizeSmaller();
        }
        return item;
    }

    public T get(int index) {
        if(index >= size())
            return null;
        int point = start;
        for(int i = 0; i <= index; i ++)
            point = getNext(point);
        return items[point];
    }

}
