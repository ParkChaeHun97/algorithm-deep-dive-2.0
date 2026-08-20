package week_06_data_structure_greedy.data_structure.BOJ_11286_절댓값_힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if(Math.abs(a) - Math.abs(b) != 0) return Math.abs(a) - Math.abs(b);
            else return a - b;
        });

        // 연산의 개수 N
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            // 1. x가 0이 아니라면 x라는 값을 넣는 연산
            if (x != 0) pq.add(x);
                // 2. x가 0이라면 절댓값이 가장 작은 값을 출력하고 그값을 배열에서 제거
            else {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
