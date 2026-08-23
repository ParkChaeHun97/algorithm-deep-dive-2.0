package dp.BOJ_1912_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp[0] = Integer.parseInt(st.nextToken());
        int maxValue = dp[0];

        // 배열이 굳이 필요있을까? st로 처리
        for (int i = 1; i < n; i++) {
            int nextValue = Integer.parseInt(st.nextToken());
            dp[i] =  Math.max(nextValue, dp[i-1] + nextValue);
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(maxValue);

    }
}
