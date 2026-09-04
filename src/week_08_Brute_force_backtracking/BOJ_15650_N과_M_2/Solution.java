package week_08_Brute_force_backtracking.BOJ_15650_N과_M_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n,m;
    static int[] numbers;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        permutation(0, 1);
        System.out.println(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n + 1];
        numbers = new int[m];
    }

    private static void permutation(int depth, int start) {
        if(depth == m) {
            for(int num : numbers) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if(used[i]) continue;
            used[i] = true;
            numbers[depth] = i;
            permutation(depth + 1, i + 1);
            used[i] = false;
        }
    }

}
