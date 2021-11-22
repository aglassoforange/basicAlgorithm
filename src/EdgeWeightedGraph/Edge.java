package EdgeWeightedGraph;

public class Edge implements Comparable<Edge> {

    private final int v;
    private final int w;
    private final double weight;

    public Edge(int v, int w, double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if(vertex == v){
            return w;
        }else{
            return v;
        }
    }

    @Override
    public int compareTo(Edge o) {
        int cmp;
        if(this.weight() > o.weight()){
            cmp = 1;
        }else if(this.weight() < o.weight()){
            cmp = -1;
        }else{
            cmp = 0;
        }
        return cmp;
    }
}
