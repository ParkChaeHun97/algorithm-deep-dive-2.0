package week_05_two_pointer_sliding_window.tow_pointer.BOJ_1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int left = 0;
    static int right = 0;

    static int len = 0; // 부분합 길이를 측정할 길이
    static int result = Integer.MAX_VALUE; // 정답
    static int sum = 0; // S와 비교할 부분합, 크면 왼쪽이동 작으면 오른쪽 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // left가 length를 넘지 않는 선에서 끝나지 않음
        while(left < arr.length) {
            // 1. sum이 S를 넘지 않을 때
            if(sum < S && right < arr.length) {
                sum += arr[right];
                // - right를 ++
                right++;
                // len을 ++
                len++;
            }
            // 2. sum이 S보다 클 때
            else if (sum >= S) {
                result = Math.min(result, len);
                // sum 보다 클 때
                sum -= arr[left];

                // 같을 때와 공통된 부분
                // - left를 ++
                left++;
                // len을 --
                len--;
            }
            else {
                break;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);


    }

}
