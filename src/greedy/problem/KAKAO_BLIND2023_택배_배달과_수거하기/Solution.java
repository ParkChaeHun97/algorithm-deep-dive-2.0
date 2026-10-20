package greedy.problem.KAKAO_BLIND2023_택배_배달과_수거하기;


/**
 * cap : 택배 상자를 담을 수 있는 양
 * n : 집의 갯수
 * deliveries : 배달할 택배의 배열
 * pickups : 수거할 상자의 배열
 *
 */


class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long result = 0;
        int d = 0; // 아직 처리 못 한 배달량 (음수 = 남는 용량)
        int p = 0; // 아직 처리 못 한 수거량

        for(int i = n-1; i >= 0; i--) {
            d += deliveries[i];
            p += pickups[i];

            // 이집에 볼 일이 남아있으면 여기까지 왕복해야함

            while(d > 0 || p > 0) {
                d -= cap;
                p -= cap;
                result += (long) (i + 1) * 2;

            }
        }

        return result;

    }
}
