package week_07_Shortest_path_grouping.BOJ_1976_여행가자;

import java.io.*;
import java.util.*;

public class Solution {
    static int[][] matrix;
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int M;

    public static void main(String[] args) throws IOException {
        input();
        unionfind();
    }
    /**
     * 첫째 줄 도시의 개수 N
     * 둘째줄 여행계획에 속한 도시의 수 M
     * 다음 N개의 줄: N*N 형태의 인접행렬 i번째 줄 j번째 값이 1이면 도시가 연결
     * 마지막 줄 여행 계획에 포함된 M개의 도시 번호
     * */

    private static void input() throws IOException {
        int N = Integer.parseInt(br.readLine()); // 도시의 갯수
        M =Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수

        matrix = new int[N+1][N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int number = Integer.parseInt(st.nextToken());
                if(number == 1) {
                    union(i, j);
                }
            }
        }



    }

    private static void unionfind() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int find = find(number);

        for (int i = 1; i < M; i++) {
            int nextNumber = Integer.parseInt(st.nextToken());
            int nextFind = find(nextNumber);

            if(find != nextFind) {
                System.out.println("NO");
                return;
            }

            find = nextFind;
        }

        System.out.println("YES");
    }

    private static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }

    }
}
