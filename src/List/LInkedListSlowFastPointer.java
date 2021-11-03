package List;

public class LInkedListSlowFastPointer {

    public static Node<Integer> circleEntry(Node n){
        Node fast = n;
        Node slow = n;
        Node entry = null;
        while(fast != null && fast.next != null){
            if(entry != null){
                entry= entry.next;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow && entry == null){
                entry = n;
            }
            if(entry == slow){
                return entry;
            }
        }

        return null;
    }



    public static void main(String[] args) {
        Node n1 = JosephProblem.createCircle(4);
        Node n5 = new Node(5,null);
        Node n6 = new Node(6,null);
        n5.next = n6;
        n6.next = n1;
        System.out.println(circleEntry(n5).item);
    }

}
