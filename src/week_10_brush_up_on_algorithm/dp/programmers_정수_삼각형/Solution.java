package week_10_brush_up_on_algorithm.dp.programmers_정수_삼각형;


class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}));
    }


    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n + 1][n + 1];
        // 초기값 설정

        dp[1][1] = triangle[0][0];

        // 높이가 1이면?
        if(n == 1) {
            return dp[1][1];
        }

        // idx는 1차이
        dp[2][1] = dp[1][1] + triangle[2-1][1-1];
        dp[2][2] = dp[1][1] + triangle[2-1][2-1];

        for(int i = 3; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                    // left 왼쪽 갱신 dp[3][1] = dp[2][1] + t[2][0](3,1)
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j] + triangle[i-1][j-1]);
                    // 그 오른쪽 갱신 dp[3][2] = dp[2][1] + t[2][1]
                    dp[i][j + 1] = dp[i-1][j] + triangle[i-1][j];


            }
        }

        int maxValue = dp[n][1];
        for (int i = 2; i <= n; i++){
            maxValue = Math.max(maxValue, dp[n][i]);
        }

        return maxValue;
    }
}