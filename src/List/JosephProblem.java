package List;

public class JosephProblem {
    public static Node<Integer> createCircle(int num){
        int length = 1;
        Node<Integer> node = new Node(1,null);
        Node<Integer> start = node;
        while(length < num){
            length++;
            Node<Integer> nNode = new Node(length,null);
            node.next = nNode;
            node = node.next;

        }
        node.next = start;
        return start;
    }
    public static void josephSolution(Node start, int num){
        int count = 1;
        Node node = start;
        Node before = null;
        while(node!=node.next){
            if(count == num){
                before.next = node.next;
                System.out.println(node.item+" ");
                count = 1;
                node = node.next;
            }else{
                before = node;
                node = node.next;
                count++;
            }
        }
        System.out.println(node.item);
    }

    public static void main(String[] args) {
        Node s = createCircle(41);
        josephSolution(s,3);
    }
}
