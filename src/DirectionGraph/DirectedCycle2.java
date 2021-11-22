package DirectionGraph;

import java.io.*;

public class DirectedCycle2 {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private boolean[] onStack;
    //创建一个检测环对象，检测图G中是否有环
    public DirectedCycle2(DirectionGraph G){
//创建一个和图的顶点数一样大小的marked数组
        marked = new boolean[G.pointNum];
//创建一个和图的顶点数一样大小的onStack数组
        onStack = new boolean[G.pointNum];
//默认没有环
        this.hasCycle=false;
//遍历搜索图中的每一个顶点
        for (int v = 0; v <G.pointNum; v++) {
//如果当前顶点没有搜索过，则搜索
            if (!marked[v]){
                dfs(G,v);
            }
        }
    }
    //基于深度优先搜索，检测图G中是否有环
    private void dfs(DirectionGraph G, int v){
//把当前顶点标记为已搜索
        marked[v]=true;
//让当前顶点进栈
        onStack[v]=true;
//遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)){
//如果当前顶点w没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if (!marked[w]){
                dfs(G,w);
            }
//如果顶点w已经被搜索过，则查看顶点w是否在栈中，如果在，则证明图中有环，修改hasCycle标记，结束循环
            if (onStack[w]){
                hasCycle=true;
                return;
            }
        }
//当前顶点已经搜索完毕，让当前顶点出栈
        onStack[v]=false;
    }
    //判断w顶点与s顶点是否相通
    public boolean hasCycle(){
        return hasCycle;
    }

//测试代码

    public static void main(String[] args) throws Exception {
//创建输入流
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
        DirectedCycle2 cycle = new DirectedCycle2(G);
//输出图中是否有环
        System.out.println(cycle.hasCycle());
    }

}