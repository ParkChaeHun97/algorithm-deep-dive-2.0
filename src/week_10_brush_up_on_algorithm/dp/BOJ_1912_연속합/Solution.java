package week_10_brush_up_on_algorithm.dp.BOJ_1912_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 10
 * 10 -4 3 1 5 6 -35 12 21 -1
 * */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());

        if(n == 1){
            System.out.println(dp[1]);
            return;
        }
        int maxValue = dp[1];

        for (int i = 2; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if(dp[i-1] + num > num) {
                dp[i] = dp[i-1] + num;
            }else dp[i] = num;

            maxValue = Math.max(maxValue, dp[i]);
        }


        System.out.println(maxValue);

    }
}
