package BlackRedTree;

public class BlackRedTree <Key extends Comparable<Key>, Value>{
    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;




    private boolean isRed(Node n){
        return n.color == RED;
    }
    //左旋的原因是因为 在右节点有红色节点 应该左节点是红色节点
    private Node rotateleft(Node n){

        Node nright = n.right;
        Node nrightL = n.right.left;
        nright.color = n.color;
        n.color = RED;
        n.right = nrightL;
        nright.left = n;
        return nright;

    }
    //当有两个相连的红色节点 组成了四节点的集合 这样违反了规则 所以需要将其分割 成左右两个红节点的树
    //进而再继续进行颜色反转
    private Node rotateright(Node n){

        Node nleft = n.left;
        Node nleftRight = n.left.right;

        n.left.color = n.color;
        n.color = RED;

        n.left = nleftRight;
        nleft.right = n;

        return nleft;

    }

    private void flipColor(Node n){
        n.left.color = BLACK;
        n.right.color = BLACK;
        n.color = RED;

    }

    public void put(Key key, Value value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node n, Key key, Value value){

        if(n == null){
            N++;
            return new Node(key, value, null, null, RED);
        }

        int cmp = key.compareTo((Key)n.key);
        if(cmp < 0){
            n.left = put(n.left, key, value);
        }
        else if(cmp > 0){
            n.right = put(n.right, key, value);
        }
        else if(cmp == 0){
            n.value = value;
        }

        //接下来就是三种需要的情况
        //当节点右侧是红 左侧是黑
        if(n.left !=null && n.right != null) {
            if (n.left.color == BLACK && n.right.color == RED) {
                n = rotateleft(n);
            }

            if (n.left.left != null && n.left.color == RED && n.left.left.color == BLACK) {
                n = rotateright(n);
            }

            if (n.left.color == RED && n.right.color == BLACK) {
                flipColor(n);
            }
        }
        return n;
    }
    //制定Key 值的 Value
    private Value get(Key key){
        return get(root, key);
    }

    private Value get(Node n, Key key){
        if(n == null) {
            return null;
        }
        int cmp = key.compareTo((Key)n.key);
        if(cmp < 0){
           return get(n.left, key);
        }
        else if(cmp > 0){
            return get(n.right, key);
        }
        else {
            return (Value)n.value;
        }
    }

    public int size(){
        return N;
    }

    public static void main(String[] args) throws Exception {
        BlackRedTree<Integer, String> bt = new BlackRedTree<Integer, String>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
    }


}

