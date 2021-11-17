package UnionFound;

import java.io.*;
import java.util.Objects;

public class RoadToBeBuild {
    public static void main(String[] args) throws IOException {

        File file = new File("src/UnionFound/traffic_project.txt");
        FileReader in = new FileReader(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        //读取城市数目，初始化并查集
        int number = Integer.parseInt(reader.readLine());
        UF_weighted uf = new UF_weighted(number);
//读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
//循环读取已经修建好的道路，并调用union方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            uf.union(p,q);
        }
//获取剩余的分组数量
        int groupNumber = uf.count();
//计算出还需要修建的道路
        System.out.println("还需要修建"+(groupNumber-1)+"道路，城市才能相通");

    }
}
