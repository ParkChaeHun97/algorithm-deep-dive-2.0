package kakao_prablom.kakao_blind_2018.비밀지도;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = new String[n];

        for(int i = 0; i < n; i++) {
            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
            String temp = " ".repeat(n - str.length()) + str.replaceAll("0", " ").replaceAll("1","#");
            answer[i] = temp;
        }

        return answer;
    }
}
