package List.Stack;

import List.Node;

import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node<T> head;
    private int N;

    public Stack(){
         head = new Node();
    }

    public boolean isEmpty(){
        return this.N == 0;
    }
    public int size(){
        return this.N;
    }
    public T pop(){
        Node temp = head.next;
        head.next = head.next.next;
        this.N--;
        return (T)temp;
    }
    public void push(T t){
        Node nNode = new Node(t, null);
        if(N != 0){
        Node temp = head.next;
        head.next = nNode;
        nNode.next = temp;
        }else{
            head.next = nNode;
        }
        this.N++;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        for(String s:stack){
            System.out.println(s);
        }
        System.out.println("--------------------------");
        stack.pop();

        for(String s:stack){
            System.out.println(s);
        }
        System.out.println("--------------------------");

    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator<T>{
        private Node temp = head;
        @Override
        public boolean hasNext() {
            return temp.next != null;
        }
        @Override
        public T next() {
            Node node = temp.next;
            temp = temp.next;
            return (T)node.item;
        }
    }
}
