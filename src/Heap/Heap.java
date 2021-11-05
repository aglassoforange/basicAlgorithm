package Heap;

public class Heap<T extends Comparable<T>> {

    public T[] items;
    public int N;

    public Heap(int capacity){
        this.items = (T[])new Comparable[capacity];
    }

    public boolean less(int a, int b){
        int gap = this.items[a].compareTo(this.items[b]);
        if(gap > 0){
            return false;
        }
        return true;
    }

    public void exchange(int a, int b){
       T temp =  this.items[a];
       this.items[a] = this.items[b];
       this.items[b] = temp;
    }

    public void insert(T item){
        N++;
        this.items[N]=item;
        swim(items);

    }

    public void swim(T[] items){
        int n = N;
        while(n/2 > 0){
            if(less(n/2, n)){
                exchange(n/2, n);
                n = n/2;
            }else{
                return;
            }
        }
    }

    public T deleteMax(){
        exchange(1,N);
        T max = items[N];
        this.items[N] = null;
        sink(items);
        N--;
        return max;
    }

    public void sink(T[] items){
        int n = 1;
        while(2*n < N){
            int max = 2*n;
            if(2*n+1 < N){
                max = items[2*n].compareTo(items[2*n+1])> 0?2*n:2*n+1;
            }
            if(less(n,max)){
                exchange(n,max);
                n = max;
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Heap<String> heap = new Heap<String>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");
        String del;
        while((del=heap.deleteMax())!=null){
            System.out.print(del+",");
        }
    }



}
