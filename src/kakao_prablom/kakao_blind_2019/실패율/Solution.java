package kakao_prablom.kakao_blind_2019.실패율;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    // 스테이지 번호와 실패율을 저장할 클래스
    static class Stage implements Comparable<Stage> {
        int id;
        double failureRate;

        public Stage(int id, double failureRate) {
            this.id = id;
            this.failureRate = failureRate;
        }

        @Override
        public int compareTo(Stage o) {
            // 실패율 내림차순 정렬
            if (this.failureRate < o.failureRate) {
                return 1;
            } else if (this.failureRate > o.failureRate) {
                return -1;
            } else {
                // 실패율이 같으면 스테이지 번호 오름차순 정렬
                return Integer.compare(this.id, o.id);
            }
        }
    }

    public int[] solution(int N, int[] stages) {
        // 1. 각 스테이지에 멈춰있는 인원 수 카운트
        int[] stageCounts = new int[N + 2];
        for (int stage : stages) {
            stageCounts[stage]++;
        }

        // 도달한 총 플레이어 수
        int totalPlayers = stages.length;
        List<Stage> stageList = new ArrayList<>();

        // 2. 각 스테이지별 실패율 계산
        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                // 스테이지에 도달한 유저가 없으면 실패율은 0
                stageList.add(new Stage(i, 0.0));
            } else {
                double failureRate = (double) stageCounts[i] / totalPlayers;
                stageList.add(new Stage(i, failureRate));
                // 다음 스테이지 도달 인원은 현재 스테이지에 막힌 인원만큼 차감
                totalPlayers -= stageCounts[i];
            }
        }

        // 3. 정렬 (Comparable 기준)
        Collections.sort(stageList);

        // 4. 결과 배열 변환
        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).id;
        }

        return answer;
    }
}
