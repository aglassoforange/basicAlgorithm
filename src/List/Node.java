package List;

    public class Node<T>{

        public T item;
        public Node next;

        public Node(){
            this.item = null;
            this.next = null;
        }

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

