import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    //定点数量
    int pointNum;
    //边的数量
    int edgeNum;
    //临接表
    ArrayList<ArrayList<Integer>> adj;

    public Graph(int a){

        pointNum = a;
        edgeNum = 0;
        adj = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < a; i++ ){
            adj.add(new ArrayList<>());
        }

    }
    public void addEdge(int a, int b){
        ArrayList<Integer> l1 = adj.get(a);
        l1.add(b);

        ArrayList<Integer> l2 = adj.get(b);
        l2.add(a);

        edgeNum++;
    }

    public ArrayList<Integer> adj(int v){
        return adj.get(v);
    }

    public static void main(String[] args) {
        Graph g = new Graph(10);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.adj(1);
        g.dfs();
        g.bfs();


    }

    //图的广度有限遍历
    public void bfs(){
        LinkedList<Integer> q = new LinkedList<Integer>();
        boolean[] marked = new boolean[pointNum];
        bfs(adj, 0, marked, q);
    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, int a, boolean[] marked, LinkedList<Integer> q){

        marked[a] = true;
        System.out.println(a);

        q.add(a);

        while(!q.isEmpty()){
            int nnum = q.removeFirst();
            for(int nnnum : adj.get(nnum)){
            if(!marked[nnnum]){
            bfs(adj, nnnum, marked, q);
            }
            }
        }
    }



    //图的深度有限遍历
    public void dfs(){

        boolean[] marked = new boolean[pointNum];

        dfs(adj, 0, marked);
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int a, boolean[] marked){

        marked[a] = true;
        System.out.println(a);
        ArrayList<Integer> list = adj.get(a);
        for(Integer num : list){
            if(marked[num]!= true) {
                dfs(adj, num, marked);
            }
        }

    }




}
