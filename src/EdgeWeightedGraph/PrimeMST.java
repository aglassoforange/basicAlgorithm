package EdgeWeightedGraph;

import Heap.IndexMinPriorityQueue;
import List.LinkedList;

import java.io.*;
import java.util.Queue;

public class PrimeMST {

    private Edge[] edgeTo; //顶点-最小生成树与定点的最短边
    private double[] distTo;//顶点-顶点与最小生成树最短边的权重
    private boolean[] marked;//顶点-顶点已经在树上了为TRUE
    private IndexMinPriorityQueue pq;//存放树中顶点与非树中定点之间的有效横切面
    public PrimeMST(EdgeWeightedGraph g){

        this.distTo = new double[g.V()];
        this.edgeTo = new Edge[g.V()];
        for(int i = 0; i < distTo.length; i++){
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        this.marked = new boolean[g.V()];
        this.pq = new IndexMinPriorityQueue<>(g.V());

        distTo[0] = 0.0;
        pq.insert(0,0.0);

        while(!pq.isEmpty()){
            visit(g,(int) pq.delMin());
        }

    }

    private void visit(EdgeWeightedGraph G, int v){

        marked[v] = true;
        for(Edge e : G.adj(v)){

            int w = e.other(v);

            if(marked[w]){
                continue;
            }
            if(e.weight() < distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.weight();

                if(pq.contains(w)){
                    pq.changeItem(w, e.weight());
                }else{
                    pq.insert(w,e.weight());
                }
            }
        }
    }

    public Queue<Edge> edges(){
        Queue<Edge> edges = (Queue<Edge>) new LinkedList<Edge>();

        for(int i = 0; i < marked.length; i++){
            if(edgeTo[i]!=null){
                edges.add(edgeTo[i]);
            }
        }
        return edges;

    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/DirectionGraph/test.txt");
        FileReader in = new FileReader(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        int number = Integer.parseInt(reader.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(number);
        //读取边的数目
        int edgeNumber = Integer.parseInt(reader.readLine());
        //循环读取每一条边，并调用addEdge方法
        for (int i = 0; i < edgeNumber; i++) {
            String line = reader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);
            double weight = Double.parseDouble(line.split(" ")[2]);
            G.addEdge(new Edge(v, w, weight));
        }
        //构建PrimMST对象
        PrimeMST mst = new PrimeMST(G);
        //获取最小生成树的边
        Queue<Edge> edges = mst.edges();
        //打印输出
        for (Edge edge : edges) {
            if (edge != null) {
                System.out.println(edge.either() + "-" + edge.other(edge.either()) + "::" +
                        edge.weight());
            }
        }

    }
}
