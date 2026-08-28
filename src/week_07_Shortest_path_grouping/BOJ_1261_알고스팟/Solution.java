package week_07_Shortest_path_grouping.BOJ_1261_알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    static int[][] matrix;
    static int[][] dist;
    static int N, M;

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {-1, 1, 0, 0};
    final static int INF = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        input();

        for (int[] row : dist) Arrays.fill(row, INF);
        dist[0][0] = 0;

        bfs(0, 0);
        printResult();
    }

    private static void printResult() {
        System.out.println(dist[N-1][M-1]);
    }

    /**
     * 1. 첫째 줄 M(가로), N(세로) 공백으로 구분
     * 2. 다음 N개의 줄 각 줄마다 M개의 숫자(0 또는 1) 공백 없이 붙어서 주어짐,
     * */
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];
        dist = new int[N][M];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }




    }

    private static void bfs(int x, int y) {
        Deque<int[]> deque = new ArrayDeque();
        deque.addFirst(new int[]{x, y, dist[x][y]});


        while (!deque.isEmpty()) {
            int[] cr = deque.pollFirst();

            int cx = cr[0];
            int cy = cr[1];
            int d = cr[2]; // 현재 가중치

            if(d > dist[cx][cy]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int weight; // 다음 가중치

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    weight = matrix[nx][ny];
                    if(d + weight < dist[nx][ny]) { // 현재 가중치 + 다음 가중치 < 원래 가중치
                        dist[nx][ny] = d + weight;
                        if(weight == 0) deque.addFirst(new int[] {nx, ny, dist[nx][ny]});
                        else deque.addLast(new int[] {nx, ny, dist[nx][ny]});
                    }
                }
            }

        }

    }
}
