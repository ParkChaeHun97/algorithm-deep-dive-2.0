package implementation.problem.PGS_추억_점수;

import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] score = new int[photo.length];

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], i);
        }

        for(int i = 0; i< photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                String people = photo[i][j];
                if(map.containsKey(people)) score[i] += yearning[map.get(people)];
            }
        }

        return score;
    }
}
