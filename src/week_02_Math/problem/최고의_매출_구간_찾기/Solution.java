package week_02_Math.problem.최고의_매출_구간_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] prefixSum;
    static int N, K;

    static int maxResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. N과 K 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1];

        // 2. 일일 매출 입력 받기

        st = new StringTokenizer(br.readLine());


        // prefix입력 받기
        for (int i = 1; i <= N; i++) {
            int current = Integer.parseInt(st.nextToken());
            prefixSum[i] = current + prefixSum[i - 1];
        }

        maxResult = prefixSum[K];


        for (int i = K+1; i <= N; i++) {
            maxResult = Math.max(maxResult, prefixSum[i] - prefixSum[i-K]);
        }



        System.out.println(maxResult);


    }
}
