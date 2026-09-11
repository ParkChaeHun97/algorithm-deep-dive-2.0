package tree.BOJ_1991_트리_순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tree tree = new Tree();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            tree.input(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
        }

        tree.orderAndPrinter('A');



    }
}

class Tree {

    Map<Character, char[]> tree = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public void input(char node, char left, char right) {
        tree.put(node,new char[]{left, right});
    }

    public void orderAndPrinter(char start) {
        preorder(start);
        sb.append("\n");
        inorder(start);
        sb.append("\n");
        postorder(start);
        System.out.print(sb.toString());
    }

    private void preorder(char start) {
        if(start == '.') return;
        sb.append(start);
        preorder(tree.get(start)[0]);
        preorder(tree.get(start)[1]);
    }

    private void inorder(char start) {
        if(start == '.') return;
        inorder(tree.get(start)[0]);
        sb.append(start);
        inorder(tree.get(start)[1]);
    }

    private void postorder(char start) {
        if(start == '.') return;
        postorder(tree.get(start)[0]);
        postorder(tree.get(start)[1]);
        sb.append(start);
    }

}
