package week_09_implementation_simulation.kakao_blind_2018_파일명_정렬;

import java.util.Arrays;

public class Solution {
    /**
     * // HEAD, NUMBER, TAIL로 구분해야함.
     *
     * */

    public static String[] splitHNT(String str) {
        int i = 0;

        // 1. head 찾기: 숫자가 나올 때 까지
        while(!Character.isDigit(str.charAt(i))) {
            i++;
        }

        String head = str.substring(0,i);

        // 2. number 찾기: 숫자가 아닌게 나올 때까지
        int numStart = i;

        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
        }

        String number = str.substring(numStart, i);

        // 3. 나머지 tail
        String tail = str.substring(i);

        return new String[] {head, number, tail};
    }


    public String[] solution(String[] files) {

        Arrays.sort(files, (a,b) -> {
            String[] aSplit = splitHNT(a);
            String[] bSplit = splitHNT(b);

            // 1. HEAD는 대소문자 구분 하지 않는다.
            String aHead = aSplit[0].toLowerCase();
            String bHead = bSplit[0].toLowerCase();

            // Head 자체로 정렬이 안되면 다음기준은 number
            if(!aHead.equals(bHead)) {
                return  aHead.compareTo(bHead);
            }else {
                // 2. number는 int로 변환 시키기
                int aNum = Integer.parseInt(aSplit[1]);
                int bNum = Integer.parseInt(bSplit[1]);
                return aNum - bNum;
            }
        });

        return files;
    }
}
