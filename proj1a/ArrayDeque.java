public class ArrayDeque<T> {

    private int size;
    private T[] items;
    private int pointerStart;
    private int pointerEnd;


    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        pointerStart = 0;
        pointerEnd = 1;
    }

    /**
     * constant time
     * Adds an item of T T to the front of the deque.
     */
    private void resizing() {
        T[] bigOne = (T[]) new Object[items.length * 2];
        System.arraycopy(items, (pointerStart + 1), bigOne, 1, (items.length - pointerStart - 1));
        System.arraycopy(items, 0, bigOne, (items.length - pointerStart), (pointerStart));
        pointerStart = 0;
        pointerEnd = items.length;
        items = bigOne;
    }

    public void addFirst(T T) {
        if (pointerStart == pointerEnd) {
            resizing();
        }
        items[pointerStart] = T;
        pointerStart = (pointerStart + items.length - 1) % items.length;
        size += 1;

    }

    /**
     * constant time
     * Adds an item of T T to the back of the deque.
     */
    public void addLast(T T) {
        if (pointerStart == pointerEnd) {
            resizing();
        }
        items[pointerEnd] = T;
        pointerEnd = (pointerEnd + 1) % items.length;
        size += 1;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * constant time
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;

    }

    /**
     * Prints the items in the deque from first to last, separated by a space. Once all the items have been printed,
     * print out a new line.
     */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(pointerStart + 1 + i) % items.length] + " ");
        }
        System.out.println();
    }

    private void resizingShrink() {
        T[] smallOne = (T []) new Object[items.length/2];
        if (pointerStart <= pointerEnd){
            System.arraycopy(items,(pointerStart+1),smallOne,1,size);
        }
        else{
            System.arraycopy(items,(pointerStart+1),smallOne,1,(items.length-pointerStart-1));
            System.arraycopy(items,0,smallOne,(items.length-pointerStart),(pointerEnd));
        }
        pointerStart = 0;
        pointerEnd = size+1;
        items = smallOne;
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item exists, returns null.
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        pointerStart = (pointerStart + 1) % items.length;
        size -= 1;
        T temp = items[pointerStart];
        if (size < (items.length / 2) - 1) {
            resizingShrink();
        }
        return temp;

    }

    /**
     * Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    public T removeLast() {
        if (size == 0){
            return null;
        }
        pointerEnd = (pointerEnd + items.length - 1) % items.length;
        size -= 1;
        T temp = items[pointerEnd];
        if (size < (items.length / 2) - 1) {
            resizingShrink();
        }
        return temp;
    }

    /**
     * iteration
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item
     * exists, returns null. Must not alter the deque
     */
    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        return items[(pointerStart + 1 + index) % items.length];
    }


    /**
     * Creates a deep copy of other.
     * Creating a deep copy means that you create an entirely new LinkedListDeque, with the exact same items as other
     * . However, they should be different objects, i.e. if you change other, the new LinkedListDeque you created
     * should not change as well. (Edit 2/6/2018: A walkthrough that provides a solution for this copy constructor is
     * available at
     */
//    public ArrayDeque(ArrayDeque other) {
//        items = (T[]) new Object[other.items.length];
//        System.arraycopy(other.items, 0, items, 0, items.length);
//        size = other.size;
//        pointerStart = other.pointerStart;
//        pointerEnd = other.pointerEnd;
//    }

//    public static void main(String[] args) {
//
//        ArrayDeque yhr = new ArrayDeque();
//
//        yhr.addFirst(0);
//        yhr.addFirst(1);
//        yhr.addFirst(2);
//        System.out.println(yhr.removeFirst());
//        System.out.println(yhr.removeFirst());
//        yhr.printDeque();
//        yhr.removeLast();
//        yhr.printDeque();
//        yhr.removeLast();
//        yhr.removeLast();
//        yhr.removeLast();
//        yhr.removeLast();
//        yhr.removeLast();
//        yhr.removeLast();
//        yhr.removeLast();
//        yhr.removeLast();
//        System.out.println(yhr.get(2));
//    }
}




