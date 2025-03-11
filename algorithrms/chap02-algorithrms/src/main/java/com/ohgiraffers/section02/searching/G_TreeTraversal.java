package com.ohgiraffers.section02.searching;

import com.sun.source.tree.BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class G_TreeTraversal {
    static int N;
    static char[][] tree = new char[26][2];  // 각 노드의 왼쪽, 오른쪽 자식을 저장하는 배열(알파벳 갯수 26개)
    static StringBuilder result = new StringBuilder();

    public static String solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[parent - 'A'][0] = left;  // 왼쪽 자식 저장
            tree[parent - 'A'][1] = right; // 오른쪽 자식 저장
        }

        // 전위 순회
        result.setLength(0);
        preorder('A');
        result.append("\n");

        // 중위 순회
        inorder('A');
        result.append("\n");

        // 후위 순회
        postorder('A');

        return result.toString();
    }

    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    private static void preorder(char node) {
        if (node == '.') return;
        result.append(node);
        preorder(tree[node - 'A'][0]);      // 재귀적 방식(트리 순회)
        preorder(tree[node - 'A'][1]);
    }

    // 중위 순회: 왼쪽 → 루트 → 오른쪽
    private static void inorder(char node) {
        if (node == '.') return;
        inorder(tree[node - 'A'][0]);
        result.append(node);
        inorder(tree[node - 'A'][1]);
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    private static void postorder(char node) {
        if (node == '.') return;
        postorder(tree[node - 'A'][0]);
        postorder(tree[node - 'A'][1]);
        result.append(node);
    }
}
