package week_04_binary_search_parameters.parametics_search.BOJ_2805_나무_자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;  // 나무의 갯수 N
    static long M; // 필요한 나무 길이 M
    static int[] trees; // 나무 배열
    static long treeSum = 0; // // 나무를 자른 결과
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. N과 M 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. 배열 초기화
        trees = new int[N];

        // 3. N만큼 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees); // 정렬

        // parametics search
        int left = 0;
        int right = trees[N-1];
        int mid = 0; // 정답이 될 중앙 값

        while (left <= right) {
            mid = (left + right) / 2;


            for (int i = 0; i < N; i++) {
                treeSum += Math.max((trees[i] - mid), 0);
            }

            // treeSum이 M보다 초과한 경우는 높이를 높여본다.
            if(treeSum >= M) {
                answer = mid; // 정답 후보 저장
                left = mid + 1; // 최대 높이로 필요한 나무를 탐색하기 위해 높이를 높여 보기
            }else if(treeSum <= M) { // M 보다 작으면 높이를 낮춰 본다.
                right = mid - 1;
            }

            treeSum = 0;

        }

        System.out.println(answer);

    }
}
