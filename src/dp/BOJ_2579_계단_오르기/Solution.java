package dp.BOJ_2579_계단_오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 계단 갯수
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];


        // 1. 계단마다 점수 입력 받기
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // 2. early return
        if(n == 1) {
            System.out.println(score[1]);
            return;
        }

        if(n == 2) {
            System.out.println(score[1] + score[2]);
            return;
        }

        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = dp[1] + score[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + score[i-1]) + score[i];
        }

        System.out.println(dp[n]);


    }
}
