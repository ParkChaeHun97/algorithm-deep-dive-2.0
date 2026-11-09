package two_pointer.problem.KAKAO_WINTER2019_징검다리_건너기;

// 모노톤 덱

// 1. 뒤에 들어올게 peekLast() 보다 작거나 같으면 -> pop, 그 후 항상 addLast
// 2. 크면 -> pollLast() 후 addLast -> 클 때 까지 while 해야함
// 3. 앞쪽 idx가 현재 윈도우 범위를 벗어나면? 앞쪽을 제거

// i >= k - 1 일때만 최솟값 갱신 -> stones[peekFirst()] -> 윈도우 크기가 정해진 시점.

import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int value = Integer.MAX_VALUE;

        for(int i = 0; i < stones.length; i++) {

            while(!deque.isEmpty() && stones[deque.peekLast()] <= stones[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // 윈도우 사이즈 벗어난것 빼기, window는 한칸씩 늘어나므로 if만으로 충분하다.
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            if (i >= k - 1) value = Math.min(value, stones[deque.peekFirst()]);

        }


        return value;
    }
}
