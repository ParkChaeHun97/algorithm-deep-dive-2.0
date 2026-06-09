package week_02_Math.problem.BOJ_11659_구간_합_구하기_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] prefixSum;

    static StringBuilder sb = new StringBuilder();

    static int N, M; // 수의 갯수 N, 구간 합을 구해야하는 횟수 M

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int current = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + current;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(prefixSum(a, b)).append("\n");
        }

        System.out.println(sb);


    }


    static int prefixSum(int a, int b) {
        return prefixSum[b] - prefixSum[a-1];
    }


}
