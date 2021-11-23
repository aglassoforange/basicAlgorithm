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
    //先找一个基准值，首尾各一个各一个指针
    //左指针找比基准值大的， 而右指针找比基准值小的
    //交换左指针 右指针元素
    //重复以上操作知道左指针大于右指针
    public static void QuickSort( Comparable[] a){
            int lo = 0;
            int hi = a.length - 1;

            QuickSort(a, lo, hi);

    }

    public static void QuickSort(Comparable[] a, int lo, int hi){

        if(hi <= lo){
            return;
        }

        int mid = partition(a, lo, hi);
        QuickSort(a, lo, mid - 1);
        QuickSort(a, mid + 1, hi);

    }

    public static int partition(Comparable[] a, int lo, int hi){

        Comparable key = a[lo];

        int left = lo;
        int right = hi+1;
        //一直运行直到 两个指针在中间相遇
        while(true){
            //从左往右遍历 找到第一个左指针上比key 大的
            while(greater(key, a[++left])){
                if(left == hi){
                    break;
                }
            }
            //从右往左 找到第一个右指针上的比key 小的
            while(greater(a[--right],key)){
                if(right == lo){
                    break;
                }
            }
            //当左指针和右指针相遇了 就将key 和其互换
            if(right <= left){

               break;
            }else{
                exch(a, right, left);
            }
            //当两个指针没有相遇 互换left 和 right 并继续

        }
        exch(a,lo,right);
        return right;

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
        Integer[] a = {6,1,2,7,9,3,4,5,8};
        QuickSort(a);

        System.out.println(Arrays.toString(a));
    }
}
