package implementation.problem.PGS_서울에서_김서방_찾기;

class Solution {
    public String solution(String[] seoul) {

        int kimIdx = -1;

        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                kimIdx = i;
                break;
            }
        }

        return "김서방은 " + kimIdx + "에 있다";
    }
}
