package week_09_implementation_simulation.kakao_blind_2018_캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {

        // 캐시사이즈가 0이면 그냥 무조건 miss임
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        // List로 관리 하자
        List<String> list = new LinkedList<>();
        int answer = 0;


        for(int i = 0; i < cities.length; i++) {
            int idx = -1;

            if(!list.isEmpty()) {
                // 1. 전체 문자열 비교하기

                for(int j = 0; j < list.size(); j++) {
                    if(list.get(j).equals(cities[i].toLowerCase())) {
                        idx = j;
                        break;
                    }
                }

                // 같은게 있으니 캐시 사이즈 비교할게 없음
                if(idx != -1) {
                    list.add(cities[i].toLowerCase());  // 맨 뒤로 다시 추가
                    list.remove(idx);           // 기존 위치에서 제거
                    answer += 1;
                    // 캐시 사이즈 비교 후 넣기
                } else {
                    if(cacheSize <= list.size()){
                        list.remove(0);
                        list.add(cities[i].toLowerCase());
                    }else {
                        list.add(cities[i].toLowerCase());
                    }

                    answer += 5;

                }

            }else {
                list.add(cities[i].toLowerCase());
                answer+= 5;
            }


        }

        return answer;
    }
}
