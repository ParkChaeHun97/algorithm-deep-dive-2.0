package kakao_prablom.kakao_blind_2019.완주하지_못한_선수;

import java.util.HashMap;

public class Main {

    public static String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> map = new HashMap<>();

        String result = "";

        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) +1 ); // 동명이인이 없으면 1 있으면 + 1
        }

        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i])-1);
        }

        for (int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) != 0) result = participant[i];
        }
        return result;
    }

}
