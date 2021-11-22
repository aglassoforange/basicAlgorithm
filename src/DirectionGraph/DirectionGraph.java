package DirectionGraph;

import java.util.ArrayList;

public class DirectionGraph {

    public int pointNum;
    public int edgeNum;
    public ArrayList<ArrayList<Integer>> adj;

    public DirectionGraph(int num){
        this.pointNum = num;
        edgeNum = 0;
        adj = new ArrayList<>();
        for(int a=0; a < num; a++){
            adj.add(new ArrayList<Integer>());
        }
    }

    //我们要添加一个从m 到v方向的 edge
    public void addEdge(int m, int v){
        ArrayList<Integer> list = adj.get(m);
        list.add(v);
        edgeNum++;

    }

    public ArrayList<Integer> adj(int m){
        return adj.get(m);
    }

    public DirectionGraph reverse(){
        DirectionGraph g = new DirectionGraph(pointNum);

        for(int a = 0; a<pointNum; a++){
            for(int num : g.adj.get(a)){
                g.adj.get(num).add(a);
            }
        }
        return g;
    }


}
