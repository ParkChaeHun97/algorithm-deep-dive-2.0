package implementation.problem.PGS_과제_진행하기;

// 모든 과제를 Entry 객체로 변환 후 시작 시간순 정렬

// 마지막 과제가 아니라면, 다음 과제 시작 전까지 쓸 수 있는 시간 계산

// 현재 과제를 먼저 스택에 넣고 시간 차감 시작

// 남은 시간 내에 과제를 끝낼 수 있는 경우

// 다 못 끝내고 일부만 진행 후 멈추는 경우 -> 루프 탈출

// 마지막 과제는 방해받지 않으므로 바로 완료 처리

import java.util.Stack;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 1. 모든 과제를 Entry 객체로 변환 후 시작 시간순 정렬
        Entry[] entries = new Entry[plans.length];
        for (int i = 0; i < plans.length; i++) {
            entries[i] = new Entry(plans[i][0], plans[i][1], plans[i][2]);
        }
        Arrays.sort(entries, (a, b) -> a.startTime - b.startTime);

        Stack<Entry> stack = new Stack<>();
        List<String> finished = new ArrayList<>();

        for (int i = 0; i < entries.length; i++) {
            Entry current = entries[i];

            // 마지막 과제가 아니라면, 다음 과제 시작 전까지 쓸 수 있는 시간 계산
            if (i < entries.length - 1) {
                Entry next = entries[i + 1];
                int availableTime = next.startTime - current.startTime;

                // 현재 과제를 먼저 스택에 넣고 시간 차감 시작
                stack.push(current);

                while (!stack.isEmpty() && availableTime > 0) {
                    Entry top = stack.peek();

                    if (top.completeTime <= availableTime) {
                        // 남은 시간 내에 과제를 끝낼 수 있는 경우
                        availableTime -= top.completeTime;
                        finished.add(stack.pop().name);
                    } else {
                        // 다 못 끝내고 일부만 진행 후 멈추는 경우
                        top.completeTime -= availableTime;
                        availableTime = 0; // 루프 탈출
                    }
                }
            } else {
                // 마지막 과제는 방해받지 않으므로 바로 완료 처리
                finished.add(current.name);
            }
        }

        // 2. 모든 새 과제가 시작된 후 스택에 남은 멈춘 과제들 순서대로 완료
        while (!stack.isEmpty()) {
            finished.add(stack.pop().name);
        }

        return finished.toArray(new String[0]);
    }

    static class Entry {
        String name;
        int startTime;
        int completeTime;

        public Entry(String name, String startTime, String completeTime) {
            this.name = name;
            this.startTime = timeToMin(startTime, 's');
            this.completeTime = timeToMin(completeTime, 'c');
        }

        public static int timeToMin(String time, char type) {
            if (type == 'c') {
                return Integer.parseInt(time);
            }
            String[] timeS = time.split(":");
            return (Integer.parseInt(timeS[0]) * 60) + Integer.parseInt(timeS[1]);
        }
    }
}
