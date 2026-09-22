package programmers.폰켓몬;

import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] nums) {
        // 최대로 가져갈 수 있는 수량
        int maxValue = nums.length / 2;

        // map에 저장해
        Map<Integer, Integer> ponkemons = new HashMap<>();

        for(int num : nums) {
            ponkemons.put(num, ponkemons.getOrDefault(num, 0)+1);
        }

        // 3종류
        int size = ponkemons.size();
        return maxValue > size ? size : maxValue;

    }
}