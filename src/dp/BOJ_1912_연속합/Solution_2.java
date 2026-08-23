package dp.BOJ_1912_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int currentValue = Integer.parseInt(st.nextToken());
        int maxValue = currentValue;

        // 배열이 굳이 필요있을까? st로 처리
        for (int i = 1; i < n; i++) {
            int nextValue = Integer.parseInt(st.nextToken());
            currentValue = Math.max(nextValue, currentValue + nextValue);
            maxValue = Math.max(maxValue, currentValue);
        }

        System.out.println(maxValue);

    }
}
