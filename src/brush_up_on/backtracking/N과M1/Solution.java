package brush_up_on.backtracking.N과M1;

/**
 * 1. 제약 -> 복잡도
 *
 * 2. 명사 메모
 *
 * 3. 동사 메모(태그)
 *
 * 4. 알고리즘 선택
 *
 * 5. 손코딩
 *
 * 7. 주석 및 코드
 *
 * 8. 코드 재읽기
 *
 * 9. 검증
 *
 * 10. 막혔을 때(가설 세우기)
 * */

/**
 * 1 ~ N 중 중복없이 M개를 골라 나열하는 수열
 * 3 3이면
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 3 1 2
 *
 * 선택 : 1~N 중 아직 쓰지 않은 숫자를 고른다.
 * 깊이 : depth는 지금까지 몇 개를 골랐는지,
 * 종료 조건 : 고른 M개를 한 줄로 출력하고 return 한다.
 * 되롤릴 상태 : 마지막으로 사용한 숫자의 사용상태를 원복한다.
 * */

public class Solution {


    public static void main(String[] args) {
        int n = 4;
        int m = 2;

        // 사용 여부
        boolean[] used = new boolean[n + 1];
        // 배열
        int[] arr = new int[m];

        permutation(0, m, n, used, arr);


    }

    public static void permutation(int depth, int m, int n, boolean[] used, int[] arr) {

        if(depth == m) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }


        for(int i=1; i<=n; i++) { // 1 ~ n 기준으로 사용
            if(used[i]) continue; // 이미 사용한 숫자는 넘긴다.
            used[i]  = true;
            arr[depth] = i;
            permutation(depth + 1, m, n, used, arr);
            used[i] = false;

        }


    }



}
