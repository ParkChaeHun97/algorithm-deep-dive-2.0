package dp.problem.PGS_피보나치_수;


// dp[i] = dp[i-1] + dp[i-2];

import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(n, memo);
    }

    public int dp(int n, int[] memo) {
        if(n <= 1) return n;
        if(memo[n] != -1) return memo[n];
        memo[n] = (dp(n-1, memo) + dp(n-2, memo)) % 1234567;
        return memo[n];

    }
}
