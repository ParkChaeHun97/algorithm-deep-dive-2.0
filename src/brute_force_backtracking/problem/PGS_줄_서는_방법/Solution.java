package brute_force_backtracking.problem.PGS_줄_서는_방법;


import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        boolean[] used = new boolean[n + 1];
        int[] numbers = new int[n];
        List<int[]> list = new ArrayList<>();

        // 시간 초과 방지를 위한 팩토리얼 배열
        // k 판단하는 용도
        // [1, 1, 2, 6]

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }


        long count = 0;
        backtracking(0, n, numbers, used, k, list, count, fact);
        return list.get(0);
    }

    public static long backtracking(int depth, int n, int[] numbers,
                                    boolean[] used, long k, List<int[]> list, long count, long[] fact) {
        if (depth == n) {
            count++;
            if (count == k) {
                list.add(numbers.clone()); // k번째 순열 딱 1개만 list에 추가
            }
            return count;
        }

        // 현재 depth에서 뒷자리가 만들 수 있는 경우의 수
        // 1로 시작할 때 -> 1 < 5
        // 2로 시작할 때 -> 4 < 5
        // 3로 시작할 때 -> 6 >= 5
        long remain = fact[n - 1 - depth];


        for (int i = 1; i <= n; i++) {
            if (used[i]) continue;

            // k번째까지 아직 멀었다면 재귀에 들어가지 않고 count만 더해서 건너뜀
            // 기댓값 3,1,2 부터 시작하기 위해 1,2는 건너뜀
            if (count + remain < k) {
                count += remain;
                continue;
            }

            used[i] = true;
            numbers[depth] = i;

            // 반환된 누적 count를 반드시 다시 받아서 갱신해야 함
            count = backtracking(depth + 1, n, numbers, used, k, list, count, fact);

            used[i] = false;

            // list에 정답 1개가 들어왔다면 더 이상 탐색하지 않고 즉시 종료
            if (!list.isEmpty()) return count;
        }

        //누적된 count를 반환해야 상위 호출에서 이어서 셀 수 있음
        return count;
    }
}
