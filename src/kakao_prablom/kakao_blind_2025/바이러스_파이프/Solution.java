package kakao_prablom.kakao_blind_2025.바이러스_파이프;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {


    public int solution(int n, int infection, int[][] edges, int k) {
        int[] maxCount = {-1};
        List<List<int[]>> graph = new ArrayList<>();
        // 생성
        for(int i = 0; i<= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 2. 간선 잇기
        // [다음 경로, pipe번호]
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int pipeNumber = edges[i][2];
            graph.get(a).add(new int[]{b, pipeNumber});
            graph.get(b).add(new int[]{a, pipeNumber});
        }



        int[] numbers = new int[k];
        permutaion(0, k, numbers, infection, n, maxCount, graph);


        return maxCount[0];
    }



    // 1. 열었다 닫아야 하는 경우의 수를 모두 반환해야함
    // 순열 만들기
    public static void permutaion(int depth, int k, int[] numbers, int inpection, int n
            , int[] maxCount, List<List<int[]>> graph) {
        // k만큼 순열 만들기

        // 2. 1, 2 순열이 완성되면?
        if(depth == k) {
            // 3. infection 번호 부터 1번(A)로 이어진 노드를 모두 방문 처리
            boolean[] visited = new boolean[n + 1];

            visited[inpection] = true; // 초기 바이러스 지정

            // 4. 방문한 노드를 기점으로 2번(B)로 이어진 노드를 모두 방문 처리
            for(int i=0; i < numbers.length; i++) {
                int openPipe = numbers[i];
                for (int j = 1; j < visited.length; j++) {
                    // 이미 바이러스 퍼진곳에서 열린파이프를 모두 감염
                    // 첫 루프에서는 inpection만 바이러스가 있기떄문에 inpection만 실행
                    if(visited[j]) {
                        bfs(openPipe, j, visited, graph);
                    }
                }
            }



            int count = 0;
            for(boolean v : visited) {
                if(v) count++;
            }
            // 5. Max로 갯수 비교
            maxCount[0] = Math.max(count, maxCount[0]);

            return;
        }

        // 파이프 종류는 A,B,C 세개
        for(int i = 1; i<= 3; i++) {
            numbers[depth] = i;
            permutaion(depth + 1, k, numbers, inpection, n, maxCount, graph);
        }

    }


    public static void bfs(int openNumber, int inpection, boolean[] visited, List<List<int[]>> graph) {


        Queue<List<int[]>> queue = new ArrayDeque<>();

        visited[inpection] = true;
        queue.add(graph.get(inpection));

        while (!queue.isEmpty()) {
            List<int[]> poll = queue.poll();

            for(int[] next : poll) {
                int nextNumber = next[0];
                int nextPipeNumber = next[1];

                if(!visited[nextNumber] && openNumber == nextPipeNumber) // 방문하지 않고, 열린 파이프면?
                {
                    visited[nextNumber] = true;
                    queue.add(graph.get(nextNumber));
                }
            }
        }
    }





}
