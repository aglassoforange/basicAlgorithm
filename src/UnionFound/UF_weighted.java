package UnionFound;

import java.util.Scanner;

//在UF 的基础上 简化了插入的时间复杂度
//在这个基础上 在插入时候 判断 节点长度 然后进行 将小树插在大树上
public class UF_weighted {

    int count; //每个集的数量
    int[] ele; //元素-其父节点元素
    int[] size;

    public UF_weighted(int N){
        count = N;
        ele = new int[N];
        size = new int[N];

        for(int a = 0; a<N; a++){
            size[a] = 1;
            ele[a] = a;
        }

    }
    //返回集的个数
    public int count(){
        return count;
    }

    //看a 和 b 元素是否是相连的
    public boolean connected(int a, int b){
        return find(a) == find(b);
    }
    //查找 元素在那个集
    public int find(int a){
        int q = ele[a];

        while(true){
            if(q >= ele.length){
                break;
            }
            if(ele[q] == q){
                return q;
            }else{
               q = ele[q];
            }
        }
        return -1;
    }

    //合并元素
    public void union(int a, int b){

        int groupa = find(a);
        int groupb = find(b);

        if(groupb == groupa){
            return;
        }
        //如果a为大树 b将合并于a
        if(size[a] >= size[b]){
            ele[b] = a;
            size[a]+=size[b];
        }else{
            ele[a] = b;
            size[b]+=size[a];
        }
        count --;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入元素个数");
        int N = sc.nextInt();
        var uf = new UF_weighted(N);
        while(true){
            System.out.println("请输入第一个");
            int a = sc.nextInt();
            System.out.println("输入第二个");
            int b = sc.nextInt();
            if(uf.connected(a,b)){
                System.out.println("两个元素已经在一组中");
            }
            uf.union(a,b);
        }
    }
}
