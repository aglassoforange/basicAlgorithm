package Heap;

//在优先队列当中元素被赋予了优先级，将优先级最高级的先出。用的就是堆的方式去实现的
public class priorityQueue<T extends Comparable<T>> {

    private T items[];

    private int N;

    public priorityQueue(int capacity){
        this.items = (T[]) new Comparable[capacity];
    }

    //比较数组内两个元素的大小
    private boolean less(int a, int b){
        return items[a].compareTo(items[b]) < 0;
    }

    //交换数组内两个元素大小
    private void exchange(int a, int b){
        T temp = items[a];
        items[a] = items[b];
        items[b] = temp;
    }
    //消除最大的 这里就是第一个 所以将第一个和最后一个交换位置 然后删除
    public T delMax(){
        exchange(1, N);
        T max = items[N];
        items[N] = null;
        N--;
        sink(1);
        return max;
    }
    //加入一个元素 按照他的大小来排序
    public void insert(T item){
        items[++N]=item;
        swim(N);
    }
    //一个元素拼命的往上游
    private void swim(int a){
        while(a/2>0){
            if(less(a/2, a)){
                exchange(a/2, a);
                a = a/2;
            }else{
                return;
            }
        }
    }
    //一个元素比下面元素小的时候，由下面两个子节点中的一个较大的节点接替他的位置
    private void sink(int a){
        while(2*a <= N){
            int max = 2*a ;
            if(2*a + 1 <= N){
                max = less(2*a + 1, 2*a)? 2*a:2*a + 1;
            }
            if(less(a , max)){
                exchange(a, max);
                a = max;
            }else{
                return;
            }
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};

        priorityQueue maxpq = new priorityQueue(20);
        for (String s : arr) {
            maxpq.insert(s);
        }
        System.out.println(maxpq.size());
        String del;
        while(!maxpq.isEmpty()){
            del = (String)maxpq.delMax();
            System.out.print(del+",");
        }
    }

}
