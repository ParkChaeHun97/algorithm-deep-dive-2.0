package recursive.BOJ_17478_재귀함수가_뭔가요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("어느 한 컴퓨터공학과 학생이 교수님께 물었다.");
        int n = Integer.parseInt(br.readLine());
        recusive(n, "");
    }

    static void recusive(int n, String indent) {
        System.out.println(indent + "\"재귀함수가 뭔가요?\"");
        System.out.println(indent + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(indent + "그 선인에게 어느 날 한 제자가 찾아와서 물었지.\"");

        if(n == 0) {
            System.out.println(indent + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            return;
        }

        recusive(n-1, indent + "    ");

        System.out.println(indent + "\"라고 답변하였지.\"");

    }

}
