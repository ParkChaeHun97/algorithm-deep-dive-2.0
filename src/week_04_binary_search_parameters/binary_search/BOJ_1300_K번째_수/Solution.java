package week_04_binary_search_parameters.binary_search.BOJ_1300_K번째_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        long left = 1;
        long right = (long) N * N;

        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid/i, N);
            }

            if(count >= K) {
                answer = mid;
                right = mid -1;
            }else {
                left = mid + 1;
            }

        }

        System.out.println(answer);



    }
}
