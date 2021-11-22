package Graph;

import java.io.*;
import java.util.Stack;


//这个是教程上的方法 但是错误的 使用edgeTO 因为在某些情况下它
public class DepthFirstPaths2 {

        //索引代表顶点，值表示当前顶点是否已经被搜索
        private boolean[] marked;
        //起点
        private int s;
        //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
        private int[] edgeTo;
        //构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
        public DepthFirstPaths2(Graph G, int s){
//创建一个和图的顶点数一样大小的布尔数组
            marked = new boolean[G.pointNum];
//创建一个和图顶点数一样大小的整型数组
            edgeTo = new int[G.pointNum];
//初始化顶点
            this.s=s;
//搜索G图中起点为s的所有路径
            dfs(G,s);
        }
        //使用深度优先搜索找出G图中v顶点的所有相邻顶点
        private void dfs(Graph G, int v){
//把当前顶点标记为已搜索
            marked[v]=true;
//遍历v顶点的邻接表，得到每一个顶点w
            for (Integer w : G.adj(v)){

                if (!marked[w]){
                    edgeTo[w]=v;
                    dfs(G,w);
                }
            }
        }
        //判断w顶点与s顶点是否存在路径
        public boolean hasPathTo(int v){
            return marked[v];
        }
        //找出从起点s到顶点v的路径(就是该路径经过的顶点)
        public Stack<Integer> pathTo(int v){
//当前v顶点与s顶点不连通，所以直接返回null，没有路径
            if (!hasPathTo(v)){
                return null;
            }
//创建路劲中经过的顶点的容器
            Stack<Integer> path = new Stack<Integer>();
            for (int x = v;x!=s;x=edgeTo[x]){
//把当前顶点放入容器
                path.push(x);
            }
//把起点s放入容器
            path.push(s);
            return path;
        }

    public static void main(String[] args) throws IOException {

        File file = new File("src/DepthPathError.txt");
        FileReader in = new FileReader(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        Graph G = new Graph(number);
//读取城市的连通道路
        int roadNumber = Integer.parseInt(reader.readLine());
//循环读取道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
        }
//根据图G和顶点0路径查找对象
        DepthFirstPaths2 paths = new DepthFirstPaths2(G, 4);
//调用查找对象的pathTo(4)方法得到路径

        System.out.println(paths.hasPathTo(0));
     //   Stack<Integer> path = paths.pathTo(5);
//遍历打印
//        StringBuilder sb = new StringBuilder();
//        for (Integer v : path) {
//            sb.append(v+"-");
//        }
//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(sb);
    }



    }


