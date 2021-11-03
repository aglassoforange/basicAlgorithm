package algorithmClass;

import java.util.Arrays;

public class Sort {

    //插入算法
    public static void insertSort(Comparable[] a){
        for(int i = 1; i < a.length; i++){
            for(int j = i; i > 0; j--){
                if(greater(a[j -  1], a[j])){
                    exch(a, j - 1, j);
                }else{
                    break;
                }
            }
        }
    }

    //shell sort
    public static void shellSort(Comparable[] a){
        int h = 1;
        while(h < a.length){
            h = 2*h + 1;
        }
        while(h >= 1){
            for(int i = h; i < a.length; i++)
            {
                for(int j = i; j > h; j -= h){
                    if(greater(a[j - h], a[j])){
                        exch(a, j - h, j);
                    }else{
                        break;
                    }
                }
            }
            h /=2;
        }
    }

    //merge sort
    public static void mergeSort(Comparable[] a){
        int begin = 0;
        int end = a.length - 1;
        mergeSort(a, begin, end);

    }

    public static void mergeSort(Comparable[] a, int low, int high){

        Comparable[] temp = new Comparable[a.length];

        int mid = low + (high - low)/2;

        if(high<= low){
            return;
        }
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);

        merge(a, temp, low, mid, high);

    }

    public static void merge(Comparable[] a, Comparable[] temp, int low, int mid, int high){
        int p1 = low;
        int p2 = low;
        int p3 = mid + 1;

        while(p2 <= mid && p3 <= high){
           if(greater(a[p2],a[p3])){
               temp[p1++] = a[p3++];
           } else{
               temp[p1++] = a[p2++];
           }
        }
        while(p2 <= mid){
            temp[p1++] = a[p2++];
        }
        while(p3 <= high){
            temp[p1++] = a[p3++];
        }
        for(int k = low; k <= high; k++){
            a[k] = temp[k];
        }
    }

    public static boolean greater(Comparable c1, Comparable c2){
        return c1.compareTo(c2) > 0;
    }

    public static void exch(Comparable[] a, int i, int j){
        Comparable temp  = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
       long start =  System.currentTimeMillis();
        Integer[] a = {1,1,4,3,5,2,8,5};
        mergeSort(a);
        long end = System.currentTimeMillis();

        System.out.println(Arrays.toString(a));
        System.out.println(end-start);
    }
}
