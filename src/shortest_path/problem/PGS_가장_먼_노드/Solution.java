package shortest_path.problem.PGS_가장_먼_노드;

// 1번에서 시작해서 최단 경로 누적하기
// 최단 경로 중 가장 먼 경로 갯수 세기
// 1. dist에 최단 경로를 저장
// 2. 최단 경로를 저장하면서 가장 큰 수 를 저장 -> maxDist

import java.util.*;

class Solution {
    final static int INF = 1_000_000_00;

    public int solution(int n, int[][] edge) {

        List<List<Node>> graph = new ArrayList<>();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

        // 1. 노드 갯수 + 1 만큼 생성
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 그래프 생성
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];

            graph.get(a).add(new Node(b, 1));
            graph.get(b).add(new Node(a, 1));
        }

        // 3. 다익스트라
        dijstra(1, dist, graph);

        // 4. 최대값 찾기
        int maxDist = 0;
        int count = 0;

        for(int i = 1; i<dist.length; i++) {
            // dist가 INF면 스킵
            if(dist[i] == INF) continue;

            // 가중치가 maxDist보다 크면?
            if(dist[i] > maxDist) {
                maxDist = dist[i]; // maxDist 갱신
                count = 1; // 1로 초기화
            }else if(dist[i] == maxDist) {
                count++;
            }

        }

        return count;
    }

    public static void dijstra(int start, int[] dist, List<List<Node>> graph) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node c = pq.poll();
            int cNum = c.num;
            int cDist = c.dist;

            if(dist[cNum] < cDist) continue;

            for(Node node : graph.get(cNum)) {
                int next = node.num;
                int nDist = node.dist;

                // 현재 저장된 가중치 보다 지금 가중치 + 다음 가중치가 더 작으면 갱신
                if(dist[next] > dist[cNum] + nDist) {
                    dist[next] = dist[cNum] + nDist;
                    pq.add(new Node(next, dist[next]));
                }

            }



        }



    }

}

class Node implements Comparable<Node> {
    int num;
    int dist;

    public Node(int num, int dist) {
        this.num = num;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist; // 거리 기준 오름차순 정렬
    }
}