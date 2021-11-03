package List;

public class TwoWayNode <T>{

    T data;
    TwoWayNode next;
    TwoWayNode before;

    public TwoWayNode(){
        this.data = null;
        this.next = null;
        this.before = null;
    }

    public TwoWayNode(T data, TwoWayNode next, TwoWayNode before){
        this.data = data;
        this.next = next;
        this.before = before;
    }

    public static void main(String[] args) {
            TwoWayNode<String> n1 = new TwoWayNode();
            TwoWayNode<String> n3 = new TwoWayNode();
            TwoWayNode<String> n2 = new TwoWayNode();

            n1.data = "a";
            n2.data = "b";
            n3.data = "c";

            n1.next = n2;
            n2.before = n1;
            n2.next = n3;
            n3.before = n2;

    }


}
