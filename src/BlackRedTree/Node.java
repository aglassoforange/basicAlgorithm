package BlackRedTree;

public class Node <Key extends Comparable<Key>, Value>{

    public Key key;
    public Value value;
    public Node left;
    public Node right;
    public boolean color;

    public Node(Key key, Value value, Node left, Node right, boolean color){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
    }



}
