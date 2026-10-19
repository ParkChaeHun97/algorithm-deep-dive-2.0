package programmers.귤_고르기;

// 귤을 k개 골라 상자 하나에 담아 판매할거임
// 수확한 귤 크기가 일정하지 않아서 크기 별로 분류 할거
// 8개 크기가 1 3 2 5 4 5 2 3
// 6개를 판매 하면 크기가 1 4를 제외 해서 귤에 상자에 담으면 귤 종류가 3가지
// 서로 다른 종류가 최소일 때임

// 자료구조 hashmap, 우선순위큐
// 해시에 카운트 늘리면서 삽입
// 우선순위 큐에 삽입
// 카운트로 깎으면서 0이하되면 브레이크

import java.util.*;
import java.io.*;
class Solution {
    public int solution(int k, int[] tangerine) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            maxHeap.add(entry.getValue());
        }

        int count = 0;


        while(k > 0) {
            k-= maxHeap.poll();
            count++;
        }

        return count;

    }
}
