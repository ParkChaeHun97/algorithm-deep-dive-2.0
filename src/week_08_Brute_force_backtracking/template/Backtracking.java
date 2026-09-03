package week_08_Brute_force_backtracking.template;

import java.util.Arrays;

public class Backtracking {
    static boolean[] used;
    static int[] result;

    static void permutation(int[] nums, int depth, int n) {
        if (depth == n) {
            // 순열 하나 완성됨 처리
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i]) continue; // 이미 쓴 숫자는 스킵
            used[i] = true;
            result[depth] = nums[i];
            permutation(nums, depth + 1, n); // 다음 자리 채우러 재귀
            used[i] = false; // 백트래킹: 되돌아올 때 사용 취소
        }
    }
}
