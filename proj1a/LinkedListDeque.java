public class LinkedListDeque<type> {

    /** help function */
    public class Node{
        public type item;
        public Node next;
        public Node last;

        public Node(type i, Node n, Node m){
            item = i;
            last = n;
            next = m;
        }
    }

    private int size;
    public Node sentinelStart;
    public Node sentinelEnd;

    public LinkedListDeque(){
        size = 0;
        sentinelStart = new Node(null,null,null);
        sentinelEnd = new Node(null,sentinelStart,null);
        sentinelStart.next = sentinelEnd;
    }

    /** constant time
     * Adds an item of type T to the front of the deque.
     * */
    public void addFirst(type T){
        Node temp = new Node(T,sentinelStart,sentinelStart.next);
        sentinelStart.next.last = temp;
        sentinelStart.next = temp;
        size += 1;

    }

    /** constant time
     * Adds an item of type T to the back of the deque.
     * */
    public void addLast(type T){
        Node temp = new Node(T,sentinelEnd.last,sentinelEnd);
        sentinelEnd.last.next = temp;
        sentinelEnd.last = temp;
        size += 1;
    }

    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }

    /** constant time
     * Returns the number of items in the deque.
     * */
    public int size(){
        return size;

    }

    /** Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.*/
    public void printDeque(){
        Node temp = sentinelStart;
        if (temp.next != sentinelEnd){
            temp = temp.next;
            System.out.print(temp.item + " ");
        }
        System.out.println();
    }

    /** Removes and returns the item at the front of the deque. If no such item exists, returns null. */
    public type removeFirst(){
        if (size==0){
            return null;
        }
        type itemRemove = sentinelStart.next.item;
        sentinelStart.next = sentinelStart.next.next;
        sentinelStart.next.last = sentinelStart;
        size -= 1;
        return itemRemove;

    }

    /** Removes and returns the item at the back of the deque. If no such item exists, returns null. */
    public type removeLast(){
        if (size==0){
            return null;
        }
        type itemRemove = sentinelEnd.last.item;
        sentinelEnd.last = sentinelEnd.last.last;
        sentinelEnd.last.next = sentinelEnd;
        size -= 1;
        return itemRemove;
    }

    /** iteration
     * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque
     * */
    public type get(int index){
        if (index > size-1){
            return null;
        }
        Node temp = sentinelStart;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.item;
    }

    /** recursion
     * Same as get, but uses recursion.
     * */
    public type getRecursive(int index){
        if (index > size-1){
            return null;
        }
            return helper(sentinelStart,index);
    }

    private type helper(Node temp,int index){
        if (index == 0){
            return temp.next.item;
        }
        else{
            return helper(temp.next,index-1);
        }
    }

    /**
     * Creates a deep copy of other.
     * Creating a deep copy means that you create an entirely new LinkedListDeque, with the exact same items as other. However, they should be different objects, i.e. if you change other, the new LinkedListDeque you created should not change as well. (Edit 2/6/2018: A walkthrough that provides a solution for this copy constructor is available at
     * */
    public LinkedListDeque(LinkedListDeque other){
        LinkedListDeque newOne = new LinkedListDeque();
        Node copy = other.sentinelStart;
        while(copy.next!= other.sentinelEnd){
            copy = copy.next;
            newOne.addFirst(new Node(copy.item,null,null));
        }
        this.sentinelStart = newOne.sentinelStart;
        this.sentinelEnd = newOne.sentinelEnd;
        this.size = newOne.size();

    }





}
