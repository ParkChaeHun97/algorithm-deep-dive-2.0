package dp.BOJ_11053_가장_긴_증가하는_부분_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[N];
        int len = 0;

        for(int i = 0; i < N; i++) {
            int pos = binarySearch(dp, 0, len, A[i]);
            dp[pos] = A[i];
            if(pos == len) len++;
        }

        System.out.println(len);
    }

    static int binarySearch(int[] dp, int left, int right, int number) {

        while (left < right) {
            int mid = (left + right) / 2;

            if(dp[mid] < number) {
                left = mid +1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
