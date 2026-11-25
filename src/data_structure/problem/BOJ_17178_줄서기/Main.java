package data_structure.problem.BOJ_17178_줄서기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Ticket implements Comparable<Ticket> {
        String raw;
        String prefix;
        int number;

        Ticket(String raw) {
            this.raw = raw;
            String[] parts = raw.split("-");
            this.prefix = parts[0];
            this.number = Integer.parseInt(parts[1]);
        }

        @Override
        public int compareTo(Ticket o) {
            int prefixCmp = this.prefix.compareTo(o.prefix);
            if (prefixCmp != 0) {
                return prefixCmp;
            }
            return Integer.compare(this.number, o.number);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        List<Ticket> line = new ArrayList<>(n * 5);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                line.add(new Ticket(st.nextToken()));
            }
        }

        List<Ticket> sortedOrder = new ArrayList<>(line);
        Collections.sort(sortedOrder);

        Deque<Ticket> waiting = new ArrayDeque<>();
        int targetIdx = 0;

        for (Ticket current : line) {
            // 대기 공간 맨 앞사람이 지금 입장할 차례면 먼저 입장
            while (!waiting.isEmpty() && waiting.peek().compareTo(sortedOrder.get(targetIdx)) == 0) {
                waiting.pop();
                targetIdx++;
            }

            // 현재 줄의 사람이 입장할 차례면 바로 입장, 아니면 대기 공간으로
            if (current.compareTo(sortedOrder.get(targetIdx)) == 0) {
                targetIdx++;
            } else {
                waiting.push(current);
            }
        }

        // 남은 인원은 대기 공간에서 순서대로 나와야 함
        while (!waiting.isEmpty()) {
            if (waiting.peek().compareTo(sortedOrder.get(targetIdx)) == 0) {
                waiting.pop();
                targetIdx++;
            } else {
                System.out.println("BAD");
                return;
            }
        }

        System.out.println("GOOD");
    }
}
