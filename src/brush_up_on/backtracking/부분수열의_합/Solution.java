package brush_up_on.backtracking.부분수열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *크기가 양수인 부분수열 중에서 원소를 더한 값이 S가 도디는 경우의 수,
 *
 * 선택: depth번째 원소를 "넣는다 / 안 넣는다" 두 갈래를 항상 다 탐색한다.
 *       → 재귀 호출 2번 (for 없음)
 *       넣으면 dfs(depth + 1, sum + arr[depth]), 안 넣으면 dfs(depth + 1, sum)
 * 깊이: depth = 지금 보고 있는 원소의 인덱스 (arr[depth])
 *       (순열/조합과 달리 "고른 개수"가 아니야)
 * 종료: depth == N 이면 sum == S일 때 count를 올리고 return
 *       (합 확인은 끝까지 다 본 뒤에 한다)
 * 되돌림: 없음.
 *       sum을 인자로 넘기면 호출마다 새 값이 만들어져서 원복할 게 없음.
 * */

public class Solution {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        if(S == 0) {
            result--;
        }

        dfs(0, N, S, arr, 0);
        System.out.println(result);

    }

    public static void dfs(int depth, int n, int s, int[] arr, int sum) {

        if(depth == n) {
            if(sum  == s) result++;
            return;
        }

        dfs(depth + 1, n, s, arr, sum + arr[depth]);
        dfs(depth + 1, n, s, arr, sum);

    }
}

// 호출 인자에 +=를 쓰지 않는다.
// 인자를 만드는 동시에 지역변수 sum 자체를 바꿔버렸음
