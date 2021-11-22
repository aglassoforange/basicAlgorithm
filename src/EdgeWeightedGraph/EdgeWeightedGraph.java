package EdgeWeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

public class EdgeWeightedGraph {
    //PointNUm
    private final int V;
    //edgeNum
    private int E;
    private Queue<Edge>[] adj;

    public EdgeWeightedGraph(int v){
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for(int i = 0; i < adj.length; i++){
            adj[i] = new LinkedList<Edge>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);

        adj[v].add(e);
        adj[w].add(e);

        E++;
    }
    public Queue<Edge> adj(int v){
        return adj[v];
    }

    public Queue<Edge> edges(){
        Queue<Edge> allEdge = new LinkedList<>();

        for(int v = 0; v < this.V; v++){
            for(Edge e:adj(v)){
                if(e.other(v) < v){
                    allEdge.add(e);
                }
            }
        }
        return allEdge;
    }


}
