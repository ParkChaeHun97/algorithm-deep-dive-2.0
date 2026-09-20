package kakao_prablom.kakao_blind_2018.추석_트래픽;

public class Solution {

    public int solution(String[] lines) {
        //"2016-09-15 20:59:57.421 0.351s" -> xxxxxxxxxx(ms), xxxx(ms)

        int[][] msArray = timeToMs(lines); // [응답 완료시간(시작부터 끝시간), 처리시간] 을 ms로 반환
        int[] resultArray = parsingResult(msArray);
        int maxResult = maximumValue(resultArray);

        return maxResult;
    }

    private int maximumValue(int[] resultArray) {
        int maxValue = 0;

        for (int var : resultArray) {
            maxValue = Math.max(maxValue, var);
        }
        return maxValue;

    }

    private int[] parsingResult(int[][] msArray) {

        int[] startTimes = calculateStartTimes(msArray);

        // 시작시간 기점이나 끝난시간 기점이나 가장 큰값이 필요하기 때문에 배열길이는 그대로 선언
        int[] result = new int[msArray.length];

        for (int i = 0; i < startTimes.length; i++) {
            int startTime = startTimes[i];
            int startTimeAddOneSecond = startTime + 999;
            int resTimeStart = msArray[i][0];
            int resTimeStartAddOneSecond = resTimeStart + 999;

            int startCount = 0;
            int resStartCount = 0;

            for (int j = 0; j < msArray.length; j++) {
                int nextStartTime = startTimes[j];
                int nextResTime = msArray[j][0];


                // 범위 1. start 부터 + 999까지
                if(nextStartTime <= startTimeAddOneSecond && nextResTime >= startTime) {
                    startCount++;
                }

                // 범위 2. resStart 부터 + 999 까지
                if(nextStartTime <= resTimeStartAddOneSecond && nextResTime >= resTimeStart) {
                    resStartCount++;
                }

            }

            result[i] = Math.max(startCount, resStartCount);

        }

        return result;
    }

    //
    private int[] calculateStartTimes(int[][] msArray) {
        int[] startTimeArray = new int[msArray.length];
        for (int i = 0; i < msArray.length; i++) {

            int resTime = msArray[i][0]; // 응답 완료 시간
            int processTime = msArray[i][1]; // 처리 시간

            // 04.002은 02.003부터 2초 걸린 시간임
            // 04.002 에서 001이 포함된 시간.
            // 02.003을 만드려면 -0.001 해야함

            int startTime = resTime - processTime + 1; // 요청을 받은 시작시간

            startTimeArray[i] = startTime;
        }

        return startTimeArray;
    }

    public static int[][] timeToMs(String[] lines) {
        // 응답완료 시간 S와, 처리시간 T를 담을 배열, 둘다 ms로 담는다.
        int[][] msArray = new int[lines.length][2];


        for (int i = 0; i < lines.length; i++) {
            // "2016-09-15 20:59:57.421 0.351s" 형식으로 들어옴
            String input = lines[i];

            // 1.1 공백 기준으로 분리
            String split[] = lines[i].split(" ");
            // 2016-09-15, 20:59:57.421, 0.351s

            // 1.2. 날짜는 버린다. 항상 09-15 고정
            // - 시간을 ms로 변환하기 위해 또 분리
            // split[1]을 :,. 기준으로 분리
            String[] time = split[1].split("[:.]");
            // 20,59,57,421

            // 1.3. 모두 ms로 변환
            int ResHourMs = Integer.parseInt(time[0]) * 3600000;
            int ResMinMs = Integer.parseInt(time[1]) * 60000;
            int ResSecondMs = Integer.parseInt(time[2]) * 1000;
            int ResMs = Integer.parseInt(time[3]); // 3자리 고정

            int totalResMs = ResHourMs + ResMinMs + ResSecondMs + ResMs;

            // 2. 처리시간 0.351을 ms로 분리

            // 2.1 0.351s -> 0.351로 파싱
            String pstr = split[2].substring(0, split[2].length()-1);
            int totalProcessMs = (int) (Double.parseDouble(pstr) * 1000);

            msArray[i] = new int[]{totalResMs, totalProcessMs};
        }

        return msArray;
    }
}
