package week_07_Shortest_path_grouping.BOJ_13549_숨바꼭질_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Solution {
    static int N, K;
    static int dist[];
    final static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        input();

        Dijkstra(N);

        System.out.println(dist[K]);
    }

    /**
     * 첫째 줄 N과 K
     * */

    private static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        Arrays.fill(dist, INF);
    }

    /**
     * 1. X + 1 은 가중치 1
     * 2. X - 1 은 가중치 1
     * 3. X x 2 는 가중치 0
     *
     * */

    private static void Dijkstra(int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[start] = 0; // 시작점은 0
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {

            int[] cr = queue.poll();
            int node = cr[0];
            int d = cr[1];


            if (d > dist[node]) continue;

            // 3가지 분류중 가장 작은 값을 dist에 넣는다

            if(node + 1 <= 100000) {
                // X + 1 dist에 1 추가
                if (d + 1 < dist[node + 1]) {
                    dist[node + 1] = d + 1;
                    queue.offer(new int[]{node + 1, d + 1});
                }
            }

            if(node - 1 >= 0) {
                // x - 1 dist에
                if (d + 1 < dist[node - 1]) {
                    dist[node - 1] = d + 1;
                    queue.offer(new int[]{node - 1, d + 1});
                }
            }

            if(node * 2 <= 100000) {
                // x * 2 dist에 0
                if( d + 0 < dist[node * 2]) {
                    dist[node * 2] = d + 0;
                    queue.offer(new int[]{node * 2, d + 0});
                }
            }

        }





    }


}

