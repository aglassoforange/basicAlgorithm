package Heap;

import java.util.Arrays;

public class HeapSort<T> {
    public static void sort(Comparable[] array){
        makeHeap(array);
        int a = array.length - 1;
        while(a!=0) {
            exchange(array,a ,0);
            a--;
            sink(array, 0, a);
        }
    }

    public static void makeHeap(Comparable[] array)
    {
        for(int a = (array.length - 1)/2; a > 0; a--){
            sink(array, a, array.length - 1);
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] array, int a, int b){
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    //从a点到b点的 下降
    public static void sink(Comparable[] array, int a, int b){

        int n = a;
        while(2*n < b){
            int max = b;
            if(2*n+1 <= b){
                max = array[2*n].compareTo(array[2*n+1])> 0?2*n:2*n+1;
            }
            if(less(array[n],array[max])){
                exchange(array,n,max);
                n = max;
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
