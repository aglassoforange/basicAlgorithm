package DirectionGraph;

import java.io.*;
import java.util.ArrayList;

public class DirectedCycle {

    private boolean[] marked;
    private boolean hasCycle;
    private boolean[] onStack;//核心数据结构
    //当前查找是否回到了原点 用来当作评判是否有环的一个基准


    DirectedCycle(DirectionGraph G){
        marked = new boolean[G.pointNum];
        onStack = new boolean[G.pointNum];
        hasCycle = false;
        for(int a= 0; a < G.pointNum; a++){
            dfs(G, a);
        }
    }

    private void dfs(DirectionGraph G, int v){
       marked[v] = true;
       onStack[v] = true;

       ArrayList<Integer> list = G.adj.get(v);
       for(Integer num : list){
           if(!marked[num]){
               dfs(G, num);
           }
           if(onStack[num]==true){
               hasCycle = true;
               return;
           }
       }
       onStack[v] = false;
    }

    public boolean hasCycle(){return hasCycle;}

    public static void main(String[] args) throws IOException {
        File file = new File("src/DirectionGraph/test.txt");
        FileReader in = new FileReader(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));



//读取顶点个数，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        DirectionGraph G = new DirectionGraph(number);
//读取边的个数
        int roadNumber = Integer.parseInt(reader.readLine());
//读取边，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p,q);
        }
//创建测试检测环对象
        DirectedCycle cycle = new DirectedCycle(G);
//输出图中是否有环
        System.out.println(cycle.hasCycle());
    }

}
