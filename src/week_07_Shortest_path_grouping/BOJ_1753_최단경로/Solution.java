package week_07_Shortest_path_grouping.BOJ_1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * - 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로 최단 경로 구하기
 * - 모든 간선의 가중치는 10 이하의 자연수
 * */

import java.util.*;
import java.io.*;


public class Solution {
    static int V, E; // 정점의 개수 V, 간선의 개수 E
    static List<List<int[]>> graph;
    static int[] dist;
    static int K; // 시작 정점의 번호 k

    final static int INF = Integer.MAX_VALUE;



    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
        printResult();
    }

    /**
     * 첫째 줄 부터 V개의 줄에 걸쳐 i번째 줄 i번 정점으로 최단 경로의 경로값 출력
     * 자신은 0, 경로가 존재하지 않으면 INF를 출력
     * */
    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra() {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        Arrays.fill(dist, INF); // INF로 채우기
        dist[K] = 0; // 시작점은 0

        pq.offer(new int[]{K, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0]; // 현재 노드
            int d = cur[1]; // 현재 가중치

            if(d > dist[node]) continue; // 현재 가중치 > 원래 저장된 값

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int weight = edge[1];

                if(dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }

            }


        }

    }

    /**
     * 1. 정점의 개수 V 간선의 개수 E (1 <= V 20,000, 1 <= E 300,000) 모든 정점에는 1부터 V까지 번호가 매겨짐
     * 2. 시작 정점의 번호 K
     * 3. 셋째줄부터 E만큼 세개의 정수 u, v, w (u에서 v로 가는 가중치 w인 간선)
     * */
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. V, E 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 2. 시작 정점의 번호 K 입력 받기
        K = Integer.parseInt(br.readLine());

        // 그래프, dist 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) graph.add(new ArrayList<>());
        dist = new int[V + 1];

        // 3. 간선 입력 받기
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v, w});
        }

    }
}
