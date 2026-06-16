package week_02_Math.problem.BOJ_10986_나머지_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 누적합 배열 만들기
        long[] prefixSum = new long[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(st.nextToken());
        }

        // 2. 나머지 누적합 구하기
        int[] remainder = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            remainder[i] = (int) ((prefixSum[i] % M + M) % M);
        }

        long result = 0;

        // 3. 단독으로 나머지가 0 인것들 구하기
        for (int i = 1; i <= N; i++) {
            if(remainder[i] == 0) {
                result++;
            }
        }

        // 4. 나머지가 같은 애들 세어주기, idx가 값으로 치환됨
        long[] cnt = new long[M];
        for (int i = 1; i <= N; i++) {
            cnt[remainder[i]]++;
        }

        // nC2 대신 3개 있으면 2+1, 4개 있으면 3+2+1 더하기
        for (int i = 0; i < M; i++) {
            for (long j = 1; j < cnt[i]; j++) {
                result += j;
            }
        }

        System.out.println(result);
    }
}
