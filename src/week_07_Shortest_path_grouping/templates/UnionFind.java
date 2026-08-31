package week_07_Shortest_path_grouping.templates;

public class UnionFind {
    static int[] parent;

    public static void main(String[] args) {
        int n = 6;
        init(n);

        // 1 2 3이 그룹 대표는 1
        union(3,1);
        union(2,1);
        // 4 5 6이 그룹 대표는 4
        union(5,4);
        union(6,4);



    }


    // 초기화 모두 자기 자신이 대표
    private static void init(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // find: x의 대표(루트)를 찾음
    private static int find(int x) {
        if(parent[x] == x) return x; // 자기 자신이 부모면 대표
        return parent[x] = find(parent[x]); // 부모 타고 올라가기, 대표를 바로 연결 (경로 압축)
    }

    // union: a와 b를 같은 그룹으로 합침
    private static void union(int a, int b) {
        a = find(a); // a의 대표
        b = find(b); // b의 대표
        if (a != b) { // 대표가 같지 않으면
            parent[a] = b; // a의 대표를 b 밑으로 붙임
        }
    }
}
