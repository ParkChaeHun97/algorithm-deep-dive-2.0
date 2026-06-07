package week_01_BFS_DFS.problem.BOJ_1389_케빈_베이컨의_6단계_법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, M; // N은 노드의 수, M은 간선의 수
    static int[] dist, sumArray; // 각 노드마다 합을 저장
    static List<ArrayList<Integer>> adj = new ArrayList<>(); // 인접 리스트
    static int minIdx; // 모든 친구를 이을때 가장 작은 가중치를 저장할 노드 시작점
    static int minValue; // 모든 친구를 이을때 가장 작은 값을 저장
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 노드 시작점부터 가중치의 합을 더할 값을 저장할 sumArray
        sumArray = new int[N+1];

        // 인접 리스트 할당
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        // 간선 할당
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - '0';
            int b = st.nextToken().charAt(0) - '0';
            eddEdge(a,b);
        }

        //
        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1]; // 노드 시작점 부터 가중치를 저장할 dist
            Arrays.fill(dist,-1); // -1로 채움
            bfs(i); // bfs
            int sum = distSum(dist); // dist에 저장될 가중치를 모두 더하고
            sumArray[i] = sum; // 더한 값을 시작 노드 인덱스에 넣는다.
        }

        minValue = 9999999;

        // 가장 작은 idx 찾기
        for (int i = 1; i <= N; i++) {
            if(sumArray[i] < minValue) {
                minValue = sumArray[i];
                minIdx = i;
            }
        }

        System.out.println(minIdx);

    }



    static void eddEdge(int a, int b) {
        adj.get(a).add(b);
        adj.get(b).add(a);
    }

    static int distSum(int[] dist) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }
        return sum;
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            // 1. 리스트에서 뽑아내기
            List<Integer> nowAdj = adj.get(now);

            // 깊이가 깊어질 수록 가중치는 늘어나는데 어떻게 적용할 것인가?
            for (int next : nowAdj) {
                if(dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }

        }
    }
}
