package implementation.problem.PGS_유연근무제;



class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {

        int result = 0;

        for (int i = 0; i < schedules.length; i++) {

            int schedule = toMin(schedules[i]) + 10;
            boolean isLate = false;
            int day = startday;

            for (int j = 0; j < timelogs[i].length; j++) {

                // 주말은 늦어도 상관없으니 건너뛴다.
                if (day % 7 == 6 || day % 7 == 0) {
                    day++;
                    continue;
                }

                // 출근시간이 스케줄 + 10 보다 늦은 경우.
                if (schedule < toMin(timelogs[i][j])) {
                    isLate = true;
                    break;
                }

                day++;
            }

            // 평일 5일간 늦지 않은 경우
            if(!isLate) result++;

        }

        return result;
    }

    public static int toMin(int time) {
        String str = String.valueOf(time);
        return (Integer.parseInt(str.substring(0, str.length()-2)) * 60) +
                Integer.parseInt(str.substring(str.length()-2, str.length()));
    }


}
