package week_06_data_structure_greedy.data_structure.BOJ_1764_듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> hashSet = new HashSet<>();


        // 1. N, M 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. N 만큼 Set에 삽입
        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        List<String> intersectionList = new ArrayList<>();

        // 3. m 만큼 비교
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (hashSet.contains(name)) {
                intersectionList.add(name);
            }
        }

        Collections.sort(intersectionList);

        sb.append(intersectionList.size()).append("\n");

        // 4. 교집합 sb에 넣기
        for (int i = 0; i < intersectionList.size(); i++) {
            sb.append(intersectionList.get(i)).append("\n");
        }

        System.out.print(sb);



    }
}
