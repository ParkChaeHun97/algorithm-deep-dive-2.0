package week_07_Shortest_path_grouping.Remind;

import java.util.*;

/**
 * 너비 우선 탐색.
 * Queue를 활용한다.
 * */
public class BFS_Remind {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];


        /**
         *    1
         *   / \
         *  2   3
         *  |   |
         *  4 - 5
         * */

        // 그래프 생성
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        bfs(1);


    }

    private static void bfs(int start) {
        // 1. 큐에 삽입한다.
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(start);
        // 2. 큐에 들어갈때 방문 처리
        visited[start] = true;
        System.out.println(start);

        // 2. 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 3. 큐에서 꺼낸다.
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    System.out.println(next);
                    queue.offer(next);
                }
            }

        }

    }

    // 양방향으로 생성
    private static void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

}
