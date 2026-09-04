package week_08_Brute_force_backtracking.BOJ_15649_N과_M_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, m;
    static boolean[] used;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        permutation(0);

        System.out.println(sb);
    }
    /**
     * 첫째 줄 : N과 M
     * 1부터 N까지 자연수 중에서 M개를 고른 수열을 사전순으로 출력
     * */

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        used = new boolean[n + 1];
        numbers = new int[m];
    }

    private static void permutation(int depth){

        if(depth == m) {
            for(int number : numbers) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
            return;
        }

        // i는 순열의 첫 순서를 정함
        // depth는 깊이
        for (int i = 1; i <= n; i++) {
            if(used[i]) continue;
            numbers[depth] = i;
            used[i] = true;
            permutation(depth + 1);
            used[i] = false;

        }

    }
}
