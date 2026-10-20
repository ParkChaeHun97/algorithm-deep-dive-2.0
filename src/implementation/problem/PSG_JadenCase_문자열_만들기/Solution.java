package implementation.problem.PSG_JadenCase_문자열_만들기;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();


        boolean isHead = true;

        for(int i = 0; i<s.length(); i++) {

            char ch = s.charAt(i);

            if(isHead) {
                ch = Character.toUpperCase(ch);
                isHead = false;
            }else {
                ch = Character.toLowerCase(ch);
            }

            if(ch == ' ') {
                isHead = true;
            }

            sb.append(ch);


        }

        return sb.toString();
    }

}