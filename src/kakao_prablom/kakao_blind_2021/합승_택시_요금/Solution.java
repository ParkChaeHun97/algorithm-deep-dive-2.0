package kakao_prablom.kakao_blind_2021.합승_택시_요금;

import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        Graph graph = new Graph(n);

        for(int i = 0; i<fares.length; i++) {
            int[] fare = fares[i];
            int node1 = fare[0];
            int node2 = fare[1];
            int weight = fare[2];
            graph.addEdge(node1, node2, weight);
        }


        graph.floydWarshall();


        int answer = graph.returnResult(n, s, a, b);
        return answer;
    }
}

class Graph {
    int[][] arr;
    int n;
    int min = 2_000_000_00;

    final int INF = 2_000_000_00;

    public int[][] getArr() {
        return arr;
    }

    public Graph(int n) {
        this.n = n;
        this.arr = new int[n+1][n+1]; // 지점 생성
        for(int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], this.INF);
            arr[i][i]  = 0;
        }
    }

    public void addEdge(int a, int b, int weight) {
        arr[a][b] = weight;
        arr[b][a] = weight;

    }

    public void floydWarshall() {
        for(int k = 1; k <= this.n; k++) {
            for(int i = 1; i <= this.n; i++) {
                for(int j = 1; j <= this.n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

    }

    public int returnResult(int n, int s, int a, int b) {
        for(int p = 1; p <= n; p++) {
            // s에서 p까지가서? p에서a + p에서 b
            min = Math.min(min, arr[s][p] + arr[p][a] + arr[p][b]);
        }
        return min;
    }

}
