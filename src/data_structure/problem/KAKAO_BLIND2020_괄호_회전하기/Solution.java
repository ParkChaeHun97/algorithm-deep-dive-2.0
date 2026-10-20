package data_structure.problem.KAKAO_BLIND2020_괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int count = 0;

        for(int i = 0; i <= s.length() - 1; i++) {
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for(int j = 0; j < s.length(); j++) {
                int start = (i + j) % s.length();

                if (s.charAt(start) == '(' ||
                    s.charAt(start) == '{' ||
                    s.charAt(start) == '[') {
                    stack.push(s.charAt(start));
                } else {
                    if(stack.isEmpty()) {
                        isValid = false;
                        break;
                    }else {
                        if (stack.peek() == '(' && s.charAt(start) == ')') stack.pop();
                        else if (stack.peek() == '{' && s.charAt(start) == '}') stack.pop();
                        else if (stack.peek() == '[' && s.charAt(start) == ']') stack.pop();
                        else {
                            isValid = false;
                            break;
                        }
                    }

                }
            }

            if (isValid && stack.isEmpty()) count++;

        }

        return count;
    }
}
