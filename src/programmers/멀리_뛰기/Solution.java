package programmers.멀리_뛰기;

class Solution {
    public long solution(int n) {

        int[] dp = new int[2000+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i = 4; i <= 2000; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }



        return dp[n];
    }

}