package Tree;

public class Node<Key extends Comparable<Key>, Value> {
    public Node left;
    public Node right;
    public Key key;
    public Value value;

    public Node(Key key, Value value, Node left, Node right){
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
