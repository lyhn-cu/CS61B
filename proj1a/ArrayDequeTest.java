public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> lld1 = new ArrayDeque<String>();
        lld1.addFirst("a");
        lld1.addFirst("b");
        lld1.addFirst("c");
        lld1.addFirst("e");
        lld1.addFirst("f");
        lld1.addFirst("g");
        lld1.addFirst("h");
        lld1.addFirst("i");
        lld1.addFirst("j");
        lld1.addFirst("k");
        lld1.addFirst("l");
        lld1.addFirst("m");
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.removeLast();
        lld1.printDeque();
        /*
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.printDeque();
        */
    }
}
