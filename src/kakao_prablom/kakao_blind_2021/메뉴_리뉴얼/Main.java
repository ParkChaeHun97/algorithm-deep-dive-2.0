package kakao_prablom.kakao_blind_2021.메뉴_리뉴얼;

import java.util.*;

public class Main {

    /**
     * orders는 각 사람이 시킨 단품 메뉴
     * course는 코스 메뉴로 정할 갯수가 들어있음
     * */

    static Map<String,Integer> map = new HashMap<>();

    private static String[] solution(String[] orders, int[] course) {

        /**
         * 각각의 course가 코스 메뉴를 정할 갯수임
         * 각 orders마다 ABCFG이고 course가 2이면 AB,AC....BC,FG, ( 순열보단 조합임)
         * 각각을 Map에 ++ 해준다. 없거나 길이가 안되면 넘어감
         * course가 depth임
         * */

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                String currentOrders = orders[j];
                boolean[] useAlphabet = new boolean[orders[j].length()]; // 처음에 받는 조합부터 시작
                backtracking(0, 0, course[i], useAlphabet, currentOrders); // course의 첫번째 갯수만큼 조합을 만든다.
            }
        }

        /**
         * Map 준비완료
         * 코스 메뉴가 2개짜리 최대(4번)갯수가 2개라면?
         *
         * 1. course[0]번 length의 최대 갯수 세고
         * 2. 최대 갯수에 해당 하면 넣기
         *
         * */


        List<String> result = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {

            int maxCount = 0;

            // i번째 조합중 가장 큰 조합 뽑기
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String menu = entry.getKey();
                int count = entry.getValue();

                if(course[i] == menu.length()) {
                    maxCount = Math.max(maxCount, count);
                }
            }
            // 메뉴 조합에 추가
            for(Map.Entry<String,Integer> entry : map.entrySet()) {
                if (maxCount < 2) continue;
                if(entry.getValue() == maxCount && course[i] == entry.getKey().length()) {
                    result.add(entry.getKey());
                }
            }

            maxCount = 0;


        }

        Collections.sort(result);

        map.clear();

        return result.toArray(new String[0]);
    }

    private static void backtracking(int depth, int start, int end, boolean[] useAlphabet, String currentOrders) {
        if(depth == end) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < currentOrders.length(); i++) { // 조합 처리
                if(useAlphabet[i]) {
                    sb.append(currentOrders.charAt(i));
                }
            }

            // 조합된 것을 map에 추가
            if(map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString()) + 1);
                return;
            }

            map.put(sb.toString(), 1);
            return;

        }

        // 예외처리 : 현재 오더가 end 보다 작으면 그냥 return;
        if(currentOrders.length() < end) return;

        for (int i = start; i < currentOrders.length(); i++) {
            if(!useAlphabet[i]) {
                useAlphabet[i] = true;
                backtracking(depth + 1, i + 1, end, useAlphabet, currentOrders);
                useAlphabet[i] = false;
            }
        }


    }

}
