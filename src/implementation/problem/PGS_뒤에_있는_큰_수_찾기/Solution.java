package implementation.problem.PGS_뒤에_있는_큰_수_찾기;

import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>(); // 인덱스를 저장

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) { // 스택이 비어있지 않고, 현재 숫자가 스택 top 인덱스의 숫자보다 크다면
                int idx = stack.pop();
                answer[idx] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }
}

/**
 * 확정되지 않는 것은 넣는다.
 * 확정되면 뺀다.
 * 끝까지 확정되지 않은 idx는 그대로 둔다.
 * */
