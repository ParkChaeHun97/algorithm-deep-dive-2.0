package data_structure.problem.BOJ_1715_카드_정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 모든 원소를 처음부터 우선순위 큐에 넣음
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        System.out.print(solution(pq));
    }

    static int solution(PriorityQueue<Integer> pq) {
        int result = 0;

        // 큐에 묶음이 2개 이상 남아있을 때만 반복 (n == 1이면 자동으로 0 반환)
        while (pq.size() > 1) {
            int sum = pq.poll() + pq.poll();
            result += sum;
            pq.add(sum); // 합친 묶음을 다시 큐에 넣어야 다음 최소값과 비교 가능
        }

        return result;
    }
}