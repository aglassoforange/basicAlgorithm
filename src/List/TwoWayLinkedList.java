package List;

import java.util.Iterator;

public class TwoWayLinkedList<T> implements Iterable<T> {

    TwoWayNode head;
    TwoWayNode tail;
    int N;

    public TwoWayLinkedList() {
        this.head = new TwoWayNode();
        this.tail = new TwoWayNode();
        this.head.next = this.tail;
        this.tail.before = this.head;
        this.N = 0;
    }



    public void clear() {
        this.head.next = null;
        this.tail.before = null;
        this.N = 0;
    }

    public int length() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public T get(int i) {
        TwoWayNode curr = this.head.next;
        for (int a = 0; a <= i; a++) {
            curr = curr.next;
        }
        return (T) curr.data;
    }

    public void insert(T t) {
        TwoWayNode node = tail;
        TwoWayNode newNode = new TwoWayNode(t, tail ,tail.before);
        node.before.next = newNode;
        node.before = newNode;
        this.N++;
    }

    public void insert(int i, T t) {
        TwoWayNode temp = head.next;
        TwoWayNode newNode = new TwoWayNode(t, temp.next, temp);
        for (int a = 0; a <= i - 1; a++) {
            temp = temp.next;
        }
        temp.next.before = newNode;
        temp.next = newNode;
        N++;
    }

    public T remove(int i) {
        TwoWayNode node = this.head.next;
        for (int a = 0; a <= i - 1; a++) {
            node = node.next;
        }
        TwoWayNode temp = node.next.next;
        node.next = temp;
        temp.before = node;
        N--;
        return (T) temp.data;
    }

    public int indexOf(T t) {
        TwoWayNode n = this.head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.data.equals(t)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        TwoWayLinkedList<String> list = new TwoWayLinkedList();
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");

        for(String s : list){
            System.out.println(s);
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private TwoWayNode n = head;
        @Override
        public boolean hasNext() {
            return (n.next != null && n.next.data != null);
        }

        @Override
        public T next() {
            n = n.next;
            return (T)n.data;
        }
    }
}
