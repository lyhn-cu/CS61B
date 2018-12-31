public class LinkedListDeque<T> {

    public class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(T i, Node n) {
            item = i;
            next = n;
            prev = null;
        }

    }

    private Node sentinel;
    private Node last;
    public int size;



    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.next = sentinel;
        last = sentinel.next;
        sentinel.prev = last;
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, sentinel);
        last = sentinel.next;
        sentinel.prev = last;
        last.prev = sentinel;
        size = 1;
    }

    public int size() {
        return size;
    }

    public void addFirst(T item) {
        Node inserted = new Node(item, sentinel.next);
        inserted.prev = sentinel;
        sentinel.next = inserted;
        inserted.next.prev = inserted;
        size ++;
        if (size == 1) {
            last = inserted;
        }
    }

    public void addLast(T item) {
        Node inserted = new Node(item, sentinel);
        inserted.prev = last;
        last.next = inserted;
        sentinel.prev = inserted;
        last = inserted;
        size ++;
    }

    public boolean isEmpty() {
        if (size == 0) {return true;}
        else {return false;}
    }

    public void printDeque() {
        Node p = sentinel;
        int k = size;
        while(k != 0) {
            k--;
            p = p.next;
            System.out.println(p.item);
        }
    }

    public T removeFirst() {
        Node removed = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size --;
        return removed.item;
    }

    public T removeLast() {
        Node removed = last;
        last = last.prev;
        last.next = sentinel;
        sentinel.prev = last;
        size --;
        return removed.item;
    }

    public T get(int index) {
        Node p = sentinel;
        for (int i =0; i < index; i++) {
            p = p.next;
        }
        return p.next.item;
    }

    public Node getR(Node p, int index) {
        Node pp = p.next;
        int k = index;
        if (index == 0) {return pp;}
        else {return getR(pp, k-1);}
    }

    public T getRecursive(int index) {
        Node p = getR(sentinel, index);
        return p.item;
        }

}
