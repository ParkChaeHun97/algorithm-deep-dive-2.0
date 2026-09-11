package week_09_implementation_simulation.kakao_blind_2021_신규_아이디_추천;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT$*..y.abcdefghijklm"));
        System.out.println(solution(""));

        System.out.println(solution("abcdefghijklmno.z"));
    }
    /**
     * 1. 모든 대문자를 소문자로 바꾼다.
     * 2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거한다.
     * 3. 마침표가 2번이상 연속되면 하나의 마침표로 합친다.
     * 4. 마침표가 맨 앞이나 맨 뒤에 있으면 제거한다.
     * 5. 빈 문자열이 되면, a를 대입한다.
     * 6. 길이가 16자 이상이면 첫 15자만 남가고 나머지를 제거한다. 그 결과 마지막 글자가 마침표면 그것도 제거한다.
     * 7. 길이가 2자 이하라면 마지막 글자를 길이가 3이 될때까지 반복해서 끝에 붙인다.
     * */

    public static String solution(String new_id) {
        new_id = toLowercase(new_id);
        new_id = deleteCharacter(new_id);
        new_id = datToOne(new_id);
        new_id = frontRearDeleteDot(new_id);
        new_id = emptyString(new_id);
        new_id = length16Higher(new_id);
        new_id = length2Lower(new_id);
        return new_id;
    }

    // 모든 문자 소문자로 바꾸기
    public static String toLowercase(String id) {
        id = id.toLowerCase();
        return id;
    }

    // -_!@$%^&*()=+[{]}:?,<>/ 제거
    public static String deleteCharacter(String id) {
//        char[] delChars = new char[] {'!', '@', '$', '%', '^', '&', '*', '(', ')', '=', '+', '[', '{', ']', '}', ':', '?', ',', '<', '>', '/'};
//
//        for (int i = 0; i < delChars.length; i++) {
//            id = id.replace(delChars[i], ' ');
//        }
//        String[] idArray = id.split(" ");
//
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < idArray.length; i++) {
//            sb.append(idArray[i]);
//        }

//        return sb.toString();

        // 최적화 1 : 정규 표현식 사용하기
        return id.replaceAll("[^a-z0-9\\-_.]",""); // a-z, 0-9, -_. 허용 제외 모두 빈문자로

    }

    // 마침표가 2번이상 연속되면 하나의 마침표로 합친다.
    public static String datToOne(String id) {
//        if(id.equals("")) return "";
//
//        char prevChar = id.charAt(0);
//
//        for (int i = 1; i < id.length(); i++) {
//            char currentChar = id.charAt(i);
//            if(prevChar == '.') {
//                if(currentChar == '.') {
//                    id = id.substring(0,i) + id.substring(i+1, id.length());
//                    i--;
//                }
//            }
//            prevChar = currentChar;
//
//        }

//        return id;

        // 최적화 2 : 정규 표현식 사용하기
        return id.replaceAll("\\.{2,}", "."); // .이 2개인걸 .으로 바꿈
    }

    // 마침표가 맨 앞이나 맨 뒤에 있으면 제거한다.
    public static String frontRearDeleteDot(String id) {
//        if(id.equals("")) return "";
//        char frontChar = id.charAt(0);
//        char rearChar = id.charAt(id.length()-1);
//
//        while (frontChar == '.' || rearChar == '.') {
//            if(frontChar == '.') id = id.substring(1, id.length());
//            if(rearChar == '.') id = id.substring(0, id.length()-1);
//
//            frontChar = id.charAt(0);
//            rearChar = id.charAt(id.length()-1);
//        }

        // 최적화 3 : 정규표현식 사용하기
        return id.replaceAll("^\\.|\\.$", ""); // ^\\.(맨앞의.) |(or) \\.$(맨뒤의 .)
    }

    public static String emptyString(String id) {
        if(id.equals("")) {
            id = id + "a";
        }
        return id;
    }

    //* 6. 길이가 16자 이상이면 첫 15자만 남가고 나머지를 제거한다. 그 결과 마지막 글자가 마침표면 그것도 제거한다.
    public static String length16Higher(String id) {

        if(id.length() >= 16) {
            id = id.substring(0, 15);
            if(id.charAt(id.length()-1) == '.') id = id.substring(0, id.length()-1);
        }
        return id;
    }

    // * 7. 길이가 2자 이하라면 마지막 글자를 길이가 3이 될때까지 반복해서 끝에 붙인다.
    public static String length2Lower(String id) {
        if(id.length() <= 2) {
            while (id.length() <= 2) {
                id = id + id.charAt(id.length()-1);
            }
        }
        return id;
    }
}
