public class LinkedListDeque<T> implements Deque<T> {
    /** record the size of deque */
    private int size=0;

    /** represent the node of LinkedListDeque */
    private class Node {
        public Node font=null, rear=null;
        public T item;

        public Node(T i, Node f, Node r) {
            item = i;
            font = f;
            rear = r;
        }

        public T get(int index) {
            if (index == 0)
                return item;
            else
                return rear.get(index-1);
        }
    }

    /** a sentinel node */
    private Node sentinel=new Node(null, null, null);

    /** create an empty linked list deque */
    public LinkedListDeque(){
        sentinel.font = sentinel;
        sentinel.rear = sentinel;
    }

    /** add an item of type T to the front of the deque */
    @Override
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.rear);
        sentinel.rear.font = newNode;
        sentinel.rear = newNode;
        size ++;
    }

    /** add an item of type T to the back of the deque */
    @Override
    public void addLast(T item) {
        Node newNode=new Node(item, sentinel.font, sentinel);
        sentinel.font.rear = newNode;
        sentinel.font = newNode;
        size ++;
    }

    /** return true if deque is empty, false otherwise */
    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    /** return the number of items in the deque */
    @Override
    public int size() {
        return size;
    }

    /** print the items in the deque from first to last, separated by a space */
    @Override
    public void printDeque() {
        Node point = sentinel.rear;
        while (point != sentinel) {
            System.out.print(point.item + " ");
            point = point.rear;
        }
    }

    /** removes and return the item at the font of the deque.
     * If no such item exists, return null */
    @Override
    public T removeFirst() {
        T item = sentinel.rear.item;
        sentinel.rear.rear.font = sentinel;
        sentinel.rear = sentinel.rear.rear;
        if (size != 0)
            size --;
        return item;
    }

    /** remove and return the item at the back of the deque.
     *  If no such item exists, return null */
    @Override
    public T removeLast() {
        T item = sentinel.font.item;
        sentinel.font.font.rear = sentinel;
        sentinel.font = sentinel.font.font;
        if (size != 0)
            size --;
        return item;
    }

    /** gets the item at the given index, where 0 is the front, 1 is the next item, and so forth
     * If no such item exists, return null */
    @Override
    public T get(int index) {
        Node point = sentinel;
        for (int i = 0; i <= index; i ++)
            point = point.rear;
        return point.item;
    }

    /** Same as get--
     * gets the item at the given index, where 0 is the front, 1 is the next item, and so forth
     * If no such item exists, return null
     * --but use recursion
     */
    public T getRecursive(int index) {
        return sentinel.rear.get(index);
    }
}
