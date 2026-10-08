package brush_up_on.backtracking.N과M2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1부터 N까지 자연수중 중복 없이 M개를 고른 수열 중, 오름차순인 것 모두 출력
 *
 *  선택 : 이번 자리에는 직전에 고른 숫자보다 큰 숫자만 고른다.
 *      -> start부터 N까지 중 i를 고르고, 다음 호출에는 start = i + 1로 넘긴다.
 *  깊이 : depth  = 지금까지 고른 개수 = 이번에 채울 자리의 인덱스(arr[depth] =  i)
 *  종료 조건 : depth == m 이면 arr를 한줄로 출력하고 return 한다.
 *  되돌릴 상태 : 없음. 앞 숫자는 start가 막아주니까 user가 필요 없고, arr[depth]는 다음 반복에서 덮어 써진다.
 *
 *
 *  */
public class Solution {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        combination(0, 1, arr, n, m);

        System.out.print(sb.toString());
    }

    public static void combination (int depth, int start, int[] arr, int n, int m) {
        if(depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }


        for(int i = start; i <= n; i++) { // 1번부터 n까지 선택
            arr[depth] = i; //
            combination(depth + 1, i + 1, arr, n, m);
        }
    }
}
