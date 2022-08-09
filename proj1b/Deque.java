public interface Deque<T> {
    /** add an item of type T to the front of the deque */
    void addFirst(T item);
    /** add an item of type T to the back of the deque */
    void addLast(T item);
    /** return true if deque is empty, false otherwise */
    boolean isEmpty();
    /** return the number of items in the deque */
    int size();
    /** print the items in the deque from first to last, seperated by a space */
    void printDeque();
    /** remove and return the item at the front of the deque.
     * If no such item exists, return null
     */
    T removeFirst();
    /** remove and return the item at the back of the deque.
     * If no such item exists, return null
     */
    T removeLast();
    /** get the item at the given index, where 0 is the front, 1 is the next item, and so forth
     * If no such item exists, return null.
     * Must not alter the deque!
     */
    T get(int index);
}
