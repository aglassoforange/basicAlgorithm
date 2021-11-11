package Heap;

public class IndexMinPriorityQueue<T extends Comparable<T>> {
    public T[] items;//索引-物品
    private int[] position;//索引-排位
    private int[]index;//排位-索引
    private int N;

    //构造函数
    public IndexMinPriorityQueue(int capacity){
        items = (T[]) new Comparable[capacity];
        position = new int[capacity];
        index = new int[capacity];
        N = 0;
        for(int a = 0; a < capacity; a++){
            index[a] = -1;
            position[a] = -1;
        }
    }

    //提供位置 比较物品的大小
    private boolean less(int a, int b){
        return items[index[a]].compareTo(items[index[b]])< 0;
    }
    //提供的是位置
    //改变的是索引-排位 排位-索引的值
    private void exch(int a, int b){

        int temp = index[a];
        index[a] = index[b];
        index[b] = temp;

        //修改index 上面的值
        position[index[a]] = a;
        position[index[b]] = b;

    }
    //删除最小元素
    public T delMin(){
        //看一下min 是用index 还是用position
        T min = items[index[1]];
        //删除 item 中的值
        items[index[1]] = null;
        exch(1,N);

        //进行更改
        position[index[N]] = -1;
        index[N] = -1;
        N--;
        //将新上的往下沉
        sink(1);
        return min;
    }
    //提供索引 物品
    //更改三个列表
    public void insert(int a, T t){
        if(contains(a)){
            throw new RuntimeException("it is already an element");
        }
        items[a] = t;
        ++N;
        position[a] = N;
        index[N] = a;//一开始忘记了 将index 也更新了
        swim(N);
    }
    //传入的是位置的值
    //有position的值 根据less 来进行比较 最终结果 用exch 来换
    public void swim(int k){

        while(k/2 > 0){
            if(less(k,k/2)){
                exch(k, k/2);
                k = k/2;
            }else{
                break;
            }
        }
    }
    //swim 一样 只不过是上浮
    public void sink(int k){

        while(2*k<=N){
            int min = 2*k;
            if(2*k+1<=N){
                min = less(2*k+1, 2*k)?2*k + 1: 2*k;
            }
            if(!less(k,min)){
                exch(k, min);
                k = min;
            }else{
                return;
            }
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N==0;
    }
    //这里的是指按照堆排序之后的元素
    public boolean contains(int k){
        return index[k] != -1;
    }
    //返回 最小的元素的索引
    public int minindex(){
        return index[1];
    }
    //删除排名在第i个的元素
    public void delete(int i){
        //delete 应该是快速查找 排名后某个位置上的数字
        exch(index[i], N);

        items[index[N]] = null;

        index[position[N]] = -1;

        position[N] = -1;

        N--;

        sink(i);
        swim(i);
    }

    public void changeItem(int k, T item ){
        items[k] = item;

        //找到k 在index 中的位置
        int pos = position[k];

        sink(pos);

    }
    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        IndexMinPriorityQueue<String> indexMinPQ = new IndexMinPriorityQueue<String>(20);
//插入
        for (int i = 0; i < arr.length; i++) {
            indexMinPQ.insert(i+1,arr[i]);
        }

        ////测试修改
        indexMinPQ.changeItem(7,"Z");

        Comparable[] list = indexMinPQ.items;

        for(int a = 1; a < indexMinPQ.N; a++){
            int ind = indexMinPQ.index[a];
            System.out.println(list[ind]);
        }
//        while(!indexMinPQ.isEmpty()){
//            String minIndex = indexMinPQ.delMin();
//            System.out.print(minIndex+",");
//        }
    }
}
