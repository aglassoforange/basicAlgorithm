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

    public add(Key key, Value value){
        if (key.compareTo(this.key) < 0){
            if (this.left == null){
                this.left = new Node(key, value, null, null, true);
            } else {
                this.left.add(key, value);
            }
        } else if (key.compareTo(this.key) > 0){
            if (this.right == null){
                this.right = new Node(key, value, null, null, true);
            } else {
                this.right.add(key, value);
            }
        } else {
            this.value = value;
        }
    }


}
