package kakao_prablom.kakao_blind_2021.합승_택시_요금;

import java.util.Arrays;

public class floydWarshallPrinter {

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 4, 6);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 4, 1);

        graph.floydWarshall();


    }

    static class Graph {
        int[][] arr;
        int n;
        int min = 2_000_000_00;

        final int INF = 2_000_000_00;

        public int[][] getArr() {
            return arr;
        }

        public Graph(int n) {
            this.n = n;
            this.arr = new int[n + 1][n + 1]; // 지점 생성
            for (int i = 1; i <= n; i++) {
                Arrays.fill(arr[i], this.INF);
                arr[i][i] = 0;
            }
        }

        public void addEdge(int a, int b, int weight) {
            arr[a][b] = weight;
            arr[b][a] = weight;

        }

        public String isINF(int a) {
            return a == INF ? "INF" : String.valueOf(a);
        }

        public void floydWarshall() {
            printerArr();
            for (int k = 1; k <= this.n; k++) {
                for (int i = 1; i <= this.n; i++) {
                    for (int j = 1; j <= this.n; j++) {
                        System.out.print("i = " + i + ", j = " + j + " k = " + k + addSpace(5));
                        System.out.println("arr[" + i + "]" + "[" + j + "] = min(arr[" + i + "]" + "[" + k + "] " + "+ " + "arr[" + k + "]" + "[" + j + "])");
                        System.out.println(addSpace(25) + isINF(arr[i][j]) + addSpace(10) + isINF(arr[i][k]) + addSpace(10) + isINF(arr[k][j]));
                        System.out.println("\n");

                        if (arr[i][j] > arr[i][k] + arr[k][j]) {
                            System.out.println("거리가 갱신 됩니다.\n");
                            printerArr();
                            System.out.println("\n갱신 전\n");
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                            printerArr();
                            System.out.println("\n갱신 후\n");
                            System.out.println("\n");
                        }

                    }
                }
            }

            printerArr();
        }

        public void printerArr() {
            System.out.print(0 + "   ");
            for (int j = 1; j <= n; j++) {
                System.out.print(j + " ");
            }
            System.out.println();

            for (int i = 1; i <= n; i++) {
                System.out.print( i +" [ ");
                for (int j = 1; j <= n; j++) {
                    System.out.print(isINF(arr[i][j]) + " ");
                }
                System.out.print("]");
                System.out.println();
            }
        }

        public static String addSpace(int n) {
            return " ".repeat(n);
        }

    }
}



