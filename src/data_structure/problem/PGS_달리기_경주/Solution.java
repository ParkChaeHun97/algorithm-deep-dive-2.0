package data_structure.problem.PGS_달리기_경주;

// 플레이어에서 플레이어 이름을 외치면 스왑한다.
// map<String,Integer>[이름 : 순위]를 저장
// kai를 외치면? map.get("kai")의 순위를 찾아서 players[순위] <-> players[순위-1]을 스왑한다.

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for(int i = 0; i < callings.length; i++) {
            int rank = map.get(callings[i]);
            swap(players, rank - 1, rank);

            String front = players[rank -1];
            String back = players[rank];

            // map에 순위 갱신
            map.put(front, rank -1);
            map.put(back, rank);

        }

        return players;
    }

    public static void swap(String[] players, int front, int back) {
        String temp = players[front];
        players[front] = players[back];
        players[back] = temp;
    }

}
