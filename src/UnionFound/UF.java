package UnionFound;

import java.util.Scanner;

public class UF {
    private int[] eleAndGroup;
    private int count; //元素-分组

    public UF(int count) {
        this.count = count;
        eleAndGroup = new int[count];
        for (int a = 0; a < count; a++) {
            eleAndGroup[a] = a;
        }
    }


    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return eleAndGroup[p] == eleAndGroup[q];
    }

    //查找元素P 在那个分组
    public int find(int p) {
        return eleAndGroup[p];
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }
        int group1 = eleAndGroup[p];
        int group2 = eleAndGroup[q];
        for (int a = 0; a < eleAndGroup.length; a++) {
            if (eleAndGroup[a] == group2) {
                eleAndGroup[a] = group1;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数:");
        int N = sc.nextInt();
        UF uf = new UF(N);
        while (true) {
            System.out.println("请录入您要合并的第一个点:");
            int p = sc.nextInt();
            System.out.println("请录入您要合并的第二个点:");
            int q = sc.nextInt();
            //判断p和q是否在同一个组
            if (uf.connected(p, q)) {
                System.out.println("结点：" + p + "结点" + q + "已经在同一个组");
                continue;
            }
            uf.union(p, q);
            System.out.println("总共还有" + uf.count() + "个分组");
        }
    }
}