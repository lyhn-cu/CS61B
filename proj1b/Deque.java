public interface Deque<T> {

    //specifications of subclasses' public methods
    //and 'public' is redundant for interface methods, can be omitted.

    //public int size();
    int size() ;

    void addFirst(T item);

    void addLast(T item);

    boolean isEmpty();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);

}
