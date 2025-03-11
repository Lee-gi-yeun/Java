package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F_FindTreeParent {

    static int N;                   // 노드의 개수
    static List<Integer>[] list;    // 연결 노드의 저장 배열(희소 그래프이므로 리스트 사용)
    static int[] parent;            // 최종 결과 저장 배열
    static boolean[] visited;       // 방문 결과 저장 배열

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        N = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for(int i = 1; i <= N + 1; i++){
            list[i] = new ArrayList<>();
        }

        // N - 1 개 줄의 입력 처리
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        return null;
    }
}
