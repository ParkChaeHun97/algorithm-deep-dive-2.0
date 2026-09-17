package week_10_brush_up_on_algorithm.union_find.BOJ_1197_최소_스패닝_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3 3
 * 1 2 1
 * 2 3 2
 * 1 3 3
 *
 *
 * */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        MST mst = new MST(new Graph(V,E));

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            mst.getGraph().addArray(i, a, b, weight);
        }

        mst.parentInit();
        mst.sortGraph();
        mst.setWeight();

        System.out.println(mst.getWeight());

    }
}

class UnionFind{

    public static void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        if(a != b) parent[a] = b;
    }

    public static int find(int[] parent, int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent, parent[a]);
    }

}

class MST {
    private Graph graph;
    private int[] parent;
    private int weight;

    public MST (Graph graph) {
        this.graph = graph;
        parent = new int[graph.getV() + 1];
    }

    // 그래프 연결
    public void setWeight() {
        for (int i = 0; i < this.graph.getArr().length; i++) {
            int[] node = this.graph.getArr()[i];
            int a = node[0];
            int b = node[1];
            int weight = node[2];

            // 서로 연결되어있지 않으면 weight 더하기
            if(UnionFind.find(this.parent,a)  != UnionFind.find(this.parent, b)) {
                this.weight += weight;
                UnionFind.union(parent, a, b);
            }
        }

    }

    public void parentInit() {
        for (int i = 0; i < this.parent.length; i++) {
            this.parent[i] = i;
        }
    }

    public Graph getGraph() {
        return this.graph;
    }

    public int getWeight() {
        return weight;
    }

    public void sortGraph() {
        Arrays.sort(this.graph.getArr(), (a, b) -> a[2] - b[2]);
    }



}


class Graph {

    private int[][] arr;
    private int V, E;

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        this.arr = new int[E][3];
    }

    public int[][] getArr() {
        return this.arr;
    }

    public int getV() {
        return this.V;
    }

    public int getE() {
        return E;
    }

    public int[] addArray(int i, int a, int b, int weight) {
        return arr[i] = new int[] {a, b, weight};
    }

}
