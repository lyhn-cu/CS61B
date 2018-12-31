public class ArrayDeque<T> {

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public ArrayDeque(T x) {
        items = (T []) new Object[8];
        items[0] = x;
        size = 1;
        nextFirst = 7;
        nextLast = 1;
        size = 1;

    }

    public int size() {
        return size;
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        if (nextLast != 0) {
            System.arraycopy(items, (nextFirst + 1), a, 0, items.length - (nextFirst + 1));
            System.arraycopy(items, 0, a, items.length - (nextFirst + 1), nextLast);
        }
        else {
            //exception where nextFirst = size - 1; nextLast = 0; that no elements are copied when full.
            System.arraycopy(items, 0, a, 0, size);
        }
        items = a;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
            nextFirst = items.length - 1;
            nextLast = size;
            items[nextFirst] = item;
            nextFirst --;
            size ++;
        }
        else {
            items[nextFirst] = item;
            nextFirst = (nextFirst - 1 + items.length) % items.length;
            size ++;
        }
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
            nextFirst = items.length - 1;
            nextLast = size;
            items[nextLast] = item;
            nextLast ++;
            size ++;
        }
        else {
            items[nextLast] = item;
            nextLast = (nextLast + 1) % items.length;
            size ++;
        }
    }

    public boolean isEmpty() {
        if (size == 0) {return true;}
        else {return false;}
    }

    public void printDeque() {
        for (int k = 0; k < size; k++) {
            System.out.println(items[(nextFirst + 1 + k) % items.length]);
        }
    }

    public void half() {

        //half() after removed() so the array can not be full, no exception as in resize();

        T[] a = (T []) new Object[items.length/2];
        if (nextLast < nextFirst) {
            //when array is separated as two parts on the sides
            System.arraycopy(items, (nextFirst + 1), a, 0, items.length - (nextFirst + 1));
            System.arraycopy(items, 0, a, items.length - (nextFirst + 1), nextLast);
        }
        else {
            //array as a whole in between
            System.arraycopy(items, nextFirst + 1, a, 0, size);
        }
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    public T removeFirst() {
        nextFirst = (nextFirst + 1) % items.length;
        T removed = items[nextFirst];
        items[nextFirst] = null;
        if (size > 0) {size --;}
        if (items.length >= 16) {
            if (size / items.length < 0.25) {
                half();
            }
        }
        return removed;
    }

    public T removeLast() {
        nextLast = (nextLast - 1 + items.length) % items.length;
        T removed = items[nextLast];
        items[nextLast] = null;
        if (size > 0) {size --;}
        if (items.length >= 16) {
            if ( (size * 1.0 / items.length) < 0.25) {
                half();
            }
        }
        return removed;
    }

    public T get(int index) {
        return items[index];
    }


}
