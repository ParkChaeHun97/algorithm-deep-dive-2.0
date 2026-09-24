package kakao_prablom.kakao_winter_internship_2019.튜플;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }

    public int[] solution(String s) {
        String[] sSplit = s.split("[{},]");

        Map<Integer, Integer> countMap = new HashMap<>();

        for(String str : sSplit) {
            if(!str.isEmpty()) {
                int num = Integer.parseInt(str);
                countMap.put(num, countMap.getOrDefault(num,0) + 1);
            }
        }

        // 빈도수 내림차순
        List<Integer> keys = new ArrayList<>(countMap.keySet());
        keys.sort((a, b) -> countMap.get(b) - countMap.get(a));
        return keys.stream().mapToInt(Integer::intValue).toArray();
    }
}