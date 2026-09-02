package week_07_Shortest_path_grouping.BOJ_1197_최소_스패닝_트리;

import java.util.*;
import java.io.*;

public class Solution {
    static int[] parent;
    static List<int[]> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();

        System.out.println(mst());
    }

    /**
     * 첫째 줄, 정점 개수 V, 간선 개수 E
     * 다음 E개의 줄, 간선의 양끝 정점 A,B와 가중치 C
     * */
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // V E
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 배열 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); // 가중치

            edges.add(new int[]{a, b, c});
        }

    }

    private static int mst() {
        int weight = 0;

        edges.sort((a, b) -> a[2] - b[2]);

        for(int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int currentWeight = edge[2];

            if(find(a) != find(b)) {
                union(a, b);
                weight += currentWeight;
            }

        }

        return weight;
    }

    private static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) parent[a] = b;
    }
}
