package greedy.problem.BOJ_1931_회의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, start, end, count;
    static int[][] times;

    public static void main(String[] args) throws IOException {
        System.out.print(solution());
    }

    static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }


        // 종료시간이 빨라야 가장 많은 회의를 고를 수 있다.
        Arrays.sort(times, (a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // 0의 상태를 start와 end에 저장
        start = times[0][0];
        end = times[0][1];
        count++;


        // 1부터 n-1까지 반복
        for (int i = 1; i < n; i++) {
            // 현재 end 보다 start가 크거나 같으면?
            if (end <= times[i][0]) {
                // start = [i][0] end = [i][1]
                start = times[i][0];
                end = times[i][1];
                count++;
            }
        }

        return count;

    }
}
