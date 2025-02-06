package Graph;

import UnionFound.UF_weighted;

import java.io.*;

public class GraphTraficFound {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("src/UnionFound/traffic_project.txt");
        FileReader in = new FileReader(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        //读取城市数目，初始化并查集
        int number = Integer.parseInt(reader.readLine());
        Graph graph = new Graph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
//循环读取已经修建好的道路，并调用union方法
        for(
                int i = 0;
                i<roadNumber;i++)

        {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            graph.addEdge(p ,q);
        }

        boolean[] marked = new boolean[graph.pointNum];
        graph.dfs(graph.adj, 9, marked);
        System.out.println(marked[10]);
    }
    public static void main(String[] args) {
        Graph g = new Graph(10);

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.adj(1);
        g.dfs();
        g.bfs();
    }
}
