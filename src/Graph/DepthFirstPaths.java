package Graph;

import Graph.Graph;

import java.util.ArrayList;
import java.util.Stack;


public class DepthFirstPaths {

    private boolean[] marked;
    private int s;
    private int[] edgeTo;
    //用dfs marked
    public DepthFirstPaths(Graph G, int s){

        this.s = s;
        this.edgeTo = new int[G.pointNum];
        marked = new boolean[G.pointNum];

    }
    //根据邻接表 和 节点 找到该节点的所有相邻点
    private void dfs(Graph G, int v){
        marked[v] = true;

        ArrayList<Integer> list = G.adj.get(v);
        for(Integer num : list){

        }

    }

//    //判断s 和 w 有没有在一条路径上
//    public boolean hasPathTo(int w){}
//
//    //找出s到w的所有路径 用stack 是因为根据edgeTo 是反方向的 所以
//    //先进后出 这样正好是正序的方向
//    public Stack<Integer> pathTo(int w){}

}
