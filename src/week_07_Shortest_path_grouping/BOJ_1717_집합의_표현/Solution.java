package week_07_Shortest_path_grouping.BOJ_1717_집합의_표현;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  0부터 시작해서 초기의 n개의 집합에서 합집한 연산과 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산을 수행
 * */
public class Solution {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        init(N);
        unionFind(M);
        System.out.println(sb);

    }

    /**
     * 첫째 줄 n과 m, m은 연산의 갯수
     * 다음 m 개의 줄에 0 a b 는 집합을 합치기, 1 a b는 a와 b가 집합인지 확인
     * */
    private static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    private static void init(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 0이면 합집합
     * 1이면 확인
     * */
    private static void unionFind (int m) throws IOException {
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int number = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(number == 0) {
                union(a, b);
            }

            if(number == 1) {
                int c = find(a);
                int d = find(b);
                sb.append(c == d ? "YES" : "NO").append("\n");
            }

        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }
    }

    private static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

}
