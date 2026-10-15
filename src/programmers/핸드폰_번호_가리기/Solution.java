package programmers.핸드폰_번호_가리기;

class Solution {
    public String solution(String phone_number) {

        StringBuilder answer = new StringBuilder();
        int maskLength = phone_number.length() - 4;

        for (int i = 0; i < maskLength; i++) {
            answer.append("*");
        }

        // 마지막 4자리를 잘라서 붙임
        answer.append(phone_number.substring(maskLength));
        return answer.toString();
    }
}