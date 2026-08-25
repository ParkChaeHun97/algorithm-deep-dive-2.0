package week_07_Shortest_path_grouping.Remind;

import java.util.*;
import java.io.*;

public class BOJ_2606_바이러스 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0; // 바이러스에 감염된 컴퓨터의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerNumber = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int edgeNumber = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수


        visited = new boolean[computerNumber + 1];

        for (int i = 0; i <= computerNumber; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 잇기
        StringTokenizer st;
        for (int i = 0; i < edgeNumber; i++) {
            st = new StringTokenizer(br.readLine());
            addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // bfs
        bfs(1);

        System.out.println(count);

    }

    private static void bfs(int start) {
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    count++;
                    queue.offer(next);
                }
            }
        }

    }

    // 단방향일 경우 2 1이 입력되면 감염시킬 수 없음
    // 양방향 연결
    private static void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
