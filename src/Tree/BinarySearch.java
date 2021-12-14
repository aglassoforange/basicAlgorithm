package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearch <Key extends Comparable<Key>, Value > {

    private Node root;
    private int N;

    public void put(Key key, Value value){
        this.root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value){

        if(x == null){
            N++;
            return new Node(key,value,null,null);
        }
        int gap = key.compareTo((Key)(x.key));
        if(gap > 0){
           x.right = put(x.right, key, value);
        }else if(gap < 0){
            x.left = put(x.left, key, value);
        }else if(gap == 0){
            x.value = value;
        }
        return x;
    }

    public Value get(Key key){
        return get(root, key);
    }

    private Value get(Node x, Key key){
        if(x == null){
            return null;
        }

        int gap = key.compareTo((Key)x.key);
        if(gap > 0){
            return get(x.right, key);
        }else if(gap < 0){
            return get(x.left, key);
        }else{
            return (Value)x.value;
        }

    }


    public void  delete(Key key){
        root = delete(root, key);
    }

    //找到右子树中最小的节点？交换时可能相等?->二叉树中不允许一样的值
    //返回删除的之后的子节点 与之前的节点相连
    private Node delete(Node x, Key key){
        if(x == null){
            return null;
        }

        int gap = key.compareTo((Key)x.key);
        if(gap > 0){
            x.right = delete(x.right, key);
        }else if(gap < 0){
            x.left =  delete(x.left, key);
        }else{
            if(x.right == null){
                N--;
                return x.left;
            }
            if(x.left == null){
                N--;
                return x.right;
            }
            //取要删的端点的右端点的最左断点
            //将其放置在删除位置
            //左为原左边
            //右为原右边
            Node minNode = x.right;
            while(minNode.left != null){
                minNode = minNode.left;
            }

            Node n = x.right;
            //将原来的最小node 给删除
            while(n.left !=null){
                if(n.left.left == null){
                    n.left = null;
                }else{
                    n=n.left;
                }
            }

            minNode.left = x.left;
            if(minNode.equals(x.right) != true){
                minNode.right = x.right;
            }
            x = minNode;
            N--;
        }

        return x;
    }

    public int size(){
        return this.N;
    }

    public Value findMin(){
         return (Value)findMin(root).value;
    }

    private Node findMin(Node node){

        if(node == null){
            return null;
        }
        //这个没有用递归
//        Node leftNode = node;
//        while(leftNode.left != null){
//            leftNode = leftNode.left;
//        }
//        return leftNode;

        //递归的用法
        if(node.left!=null){
            return findMin(node.left);
        }else{
            return node;
        }
    }
    //前中后序遍历
    public Queue<Key> preErgodic(){
        Queue<Key> queue = new LinkedList<>();
        preErgodic(root, queue);
        return queue;
    }

    public void preErgodic(Node node, Queue<Key> queue){

        if(node == null){
            return;
        }
        preErgodic(node.left, queue);
        preErgodic(node.right, queue);
        queue.add((Key)node.key);
    }

    //层序便利 广度优先遍历

    public Queue<Key> layerErgodic(){
        Queue<Key> result = new LinkedList<Key>();
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(root);
        while(queue.size()!= 0){

          Node node = queue.removeFirst();

          result.add((Key)node.key);
          if(node.left != null){
              queue.add(node.left);
          }
          if(node.right != null){
              queue.add(node.right);
          }

        }
        return result;
    }


    //寻找树的最高层数
    public int findDepth(){
        return findDepth(root);
    }
    public int findDepth(Node node){
        if(node == null){
            return 0;
        }
        int max = 0;
        int maxL = 0;
        int maxR = 0;
        if(node.left != null){
            maxL = findDepth(node.left);
        }
        if(node.right != null){
            maxR = findDepth(node.right);
        }
        max = maxL > maxR?maxL+1:maxR+1;
        return max;
    }

    public static void main(String[] args) {
//       BinarySearch<Integer, String> binarytree = new BinarySearch<>();
//
//       binarytree.put(5,"a");
//        binarytree.put(2,"b");
//        binarytree.put(3,"c");
//        binarytree.put(4,"d");
//        System.out.println(binarytree.size());
//        System.out.println(binarytree.get(2));
//        binarytree.delete(2);
//        System.out.println(binarytree.size());
//        System.out.println(binarytree.get(2));
//
//        binarytree.put1(2,"b1");
//        binarytree.put1(3,"c1");
//        binarytree.put1(4,"d1");
//        binarytree.put1(1,"a1");
//        System.out.println(binarytree.size());
//        System.out.println(binarytree.get1(2));
//        binarytree.delete1(2);
//        System.out.println(binarytree.size());
//        System.out.println(binarytree.get1(2));
//
//        System.out.println(binarytree.findMin());


        BinarySearch<String, String> tree = new BinarySearch<>();

        tree.put("1","5");
        tree.put("2","2");
        tree.put("3","1");
        tree.put("4","3");
        tree.put("5","4");
        tree.put("6","6");

       Queue<String> keys = tree.layerErgodic();
       for(String key:keys){
           String value = tree.get(key);
           System.out.println(key+" ");
       }
        System.out.println(tree.findDepth());
    }

}
