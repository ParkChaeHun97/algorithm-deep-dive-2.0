package week_06_data_structure_greedy.greedy.BOJ_11047_동전_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 동전 종류 N, 동전 가치 K
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];

        // 2. 동전 가치 A[i]가 오름차순으로 주어짐, A1 = 1이고 i >= 2인 경우 A[i]-1의 배수, 그리디 성립
        // 동전 종류 입력 받기, 큰 가치부터 받아야하니 거꾸로 입력 받기
        for (int i = N-1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int coinCount = 0;

        for (int i = 0; i < N; i++) {
            // 1. 돈이 0원이면 탈출
            if(K == 0) break;
            // 2. K가 동전의 가치 보다 크거나 같으면?
            if(K >= coins[i]) {
                // coninCount에 몇개로 나누었는지 더하기
                coinCount += K / coins[i];
                // K를 나누고 난 값을 저장
                K %= coins[i];
            }

        }

        System.out.print(coinCount);

    }
}
