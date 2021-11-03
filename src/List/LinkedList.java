package List;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private int N;

    public LinkedList() {
        this.head = new Node();
        this.N = 0;
    }

    public void clear() {
        this.head.next = null;
        this.N = 0;
    }

    public int length() {
        return this.N;
    }

    public boolean isEmpty() {
        return this.N == 0;
    }

    public T get(int i) {
        Node curr = this.head.next;
        for (int a = 0; a <= i; a++) {
            curr = curr.next;
        }
        return (T) curr.item;
    }

    public void insert(T t) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(t, null);
        this.N++;
    }

    public void insert(int i, T t) {
        Node node = head;
        for (int a = 0; a <= i - 1; a++) {
            node = node.next;
        }
        Node temp = node.next;
        node.next = new Node(t, temp);
        N++;
    }

    public T remove(int i) {
        Node node = head;
        for (int a = 0; a <= i - 1; a++) {
            node = node.next;
        }
        Node temp = node.next;
        node.next = node.next.next;
        N--;
        return (T) temp.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int i = 0; n.next != null; i++) {
            n = n.next;
            if (n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.insert(0, "张三");
        list.insert(1, "李四");
        list.insert(2, "王五");
        list.insert(3, "赵六");


        for (String s : list ) {
            System.out.println(s);
        }
        System.out.println("------------------");
        list.reverse1();
        for (String s : list ) {
            System.out.println(s);
        }
    }

    public void reverse(){
        Node curr = head;
        if(isEmpty()){
            return;
        }
        reverse(curr.next);
    }

    public Node reverse(Node T){
        if(T.next == null) {
            this.head.next = T;
            return T;
        }
        Node nodeN = reverse(T.next);
        nodeN.next = T;
        T.next = null;
        return T;
    }
    public void reverse1(){
        Node curr = head;
        if(isEmpty()){
            return;
        }
        reverse1(curr.next);
    }
    public Node reverse1(Node T){
        if(T.next == null){
            this.head.next = T;
            return T;
        }
        Node newNode = reverse1(T.next);
        newNode.next = T;
        T.next = null;
        return T;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node n = head;

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }




}
