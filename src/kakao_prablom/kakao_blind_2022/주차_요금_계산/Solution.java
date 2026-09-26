package kakao_prablom.kakao_blind_2022.주차_요금_계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        // 1. fees (기본 시간, 기본 요금, 단위 시간, 단위 요금)
        int[] fees = {180, 5000, 10, 600};

// 2. records (입/출차 기록 배열)
        String[] records = {
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT"
        };
        s.solution(fees,records);

    }

    /**


     - 출차시간 - 입차시간 이 분보다 작으면?
     - [분=0,기존요금 + 기본요금, OUT]
     - 출차시간 - 입차시간이 넘으면
     - 기본요금 + ( (출차-입차) / 단위시간 * 단위 요금 )
     - 출차-입차를 단위시간으로 맞추기
     - (출차-입차) % 단위시간이 0이면?
     -> (출차-입차) / 단위시간
     - 아니면
     - (출차 / 단위시간) + 1


     */






    public int[] solution(int[] fees, String[] records) {
        /*
         * fees[0] 기본시간, [1] 기본 요금, [2] 단위 시간, [3] 단위 요금
         * recods "05:34 5961 IN(OUT)"
         *
         * 1. parking에 입차 기록
         * 2. charge에 요금 기록
         */

        HashMap<String, Integer> parking = new HashMap<>();
        HashMap<String, Integer> totalMins = new HashMap<>();


        for(int i = 0; i < records.length; i++) {
            String[] line = records[i].split("[:\s]"); //05, 34, 5961, IN
            int min = (Integer.parseInt(line[0]) * 60) + Integer.parseInt(line[1]);
            String carNum = line[2];
            String inOrOut = line[3];

            /**
             * 입차시
             * - 시간을 분으로 해서 넣을것
             **/

            if(inOrOut.equals("IN")) {
                parking.put(carNum, min);
            } else {
                int inTime = parking.get(carNum);
                int totalTime = min - inTime;

                int currentMin = totalMins.getOrDefault(carNum, 0);
                totalMins.put(carNum, totalTime + currentMin);
                 //주차장에서 제거
                parking.remove(carNum);
            }

        }

        // 현재 주차장에서 안나간 차량 제거

        for(Map.Entry<String, Integer> cars : parking.entrySet()) {
            // 23시 59분 기준
            int lastTime = (23 * 60) + 59;

            String carNum = cars.getKey();
            int inTime = cars.getValue();

            int totalTime = lastTime - inTime;

            int currentMin = totalMins.getOrDefault(carNum, 0);
            totalMins.put(carNum, totalTime + currentMin);

        }



        int carLength = totalMins.size();
        int[][] result = new int[carLength][2];

        // 요금 계산하기
        int i = 0;

        for(Map.Entry<String, Integer> cars : totalMins.entrySet()) {
            int defaultTime = fees[0]; // 기본 시간
            int defaultPrice = fees[1]; // 기본 요금
            int unitTime = fees[2];  // 단위 시간
            int unitPrice = fees[3]; // 단위 요금
            int unit; // 단위 * 요금을 정할 단위

            int totalTime = cars.getValue();


            // 현재 차의 번호를 미리 지정
            result[i][0] = Integer.parseInt(cars.getKey());

            // - 누적시간이 기본시간 보다 작으면?
            if(totalTime < defaultTime) { // 기본 요금
                result[i][1] = defaultPrice;

            } else {  // 출차 시간이 더크다.
                // totalTime을 갱신
                totalTime -= defaultTime;

                //  (출차-입차) % 단위시간이 0이면?
                if(totalTime % unitTime == 0) unit =  totalTime / unitTime;  // 기본시간 - (출차-입차) / 단위시간
                else unit = (totalTime / unitTime) + 1; // 기본시간 - (출차 / 단위시간) + 1

                // 기본요금 + ( (출차-입차) / 단위시간 * 단위 요금 )
                int totalPrice = defaultPrice + (unit * unitPrice);

                result[i][1] = totalPrice;


            }
            i++;

        }

        // 오름차순 만들기
        Arrays.sort(result, (a,b) -> a[0] - b[0]);

        int[] answer = new int[result.length];

        for (int j = 0; j < answer.length; j++) {
            answer[j] = result[j][1];
        }


        return answer;
    }
}
