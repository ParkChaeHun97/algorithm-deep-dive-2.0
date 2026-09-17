package week_10_brush_up_on_algorithm.union_find.BOJ_1717_집합의_표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 0 1 3
 * 1 1 7
 * 0 7 6
 * 1 7 1
 * 0 3 7
 * 0 4 2
 * 0 1 1
 * 1 1 1
 *
 * 0 a b로 주어짐
 * 0은 합집합
 * 1은 집합 인지 확인
 *
 * */
public class Solution {
    static int n, m;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] parent;

    public static void main(String[] args) throws IOException {
        input();
        System.out.print(sb);
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            unionFind(type, a, b);

        }

    }

    private static void unionFind(int type, int a, int b) {
        if(type == 0) {
            union(a, b);
        }else {
            sb.append(find(a) == find(b) ? "YES" : "NO");
            sb.append("\n");
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[a] = b;
        }

    }

    // 최상위 부모 찾기
    private static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }


}
