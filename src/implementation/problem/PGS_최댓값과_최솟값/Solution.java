package implementation.problem.PGS_최댓값과_최솟값;

class Solution {
    public String solution(String s) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        String[] split = s.split(" ");

        for(int i = 0; i < split.length; i++) {
            int number = Integer.parseInt(split[i]);
            maxValue = Math.max(maxValue, number);
            minValue = Math.min(minValue, number);
        }


        return minValue + " " + maxValue;
    }
}
