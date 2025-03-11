package com.ohgiraffers.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Solution {


    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = {0,0,-1,1};
    static int[] dirY = {1,-1,0,0};

    public static String solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {  // 열 먼저 반복
                for (int y = y1; y < y2; y++) {  // 행 반복
                    map[y][x] = 1;  // (y, x) 형태로 저장
                }
            }
        }
        // 출력 확인
        System.out.println("모눈 종이");
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        ArrayList<Integer> areas = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    int areaSize = dfs(i, j);
                    areas.add(areaSize);
                }
            }
        }
        // 오름차순 정렬
        Collections.sort(areas);

        // 출력 형식 맞추기
        StringBuilder sb = new StringBuilder();
        sb.append(areas.size()).append("\n"); // 영역 개수
        for (int size : areas) {
            sb.append(size).append(" ");
        }

        return sb.toString().trim();
    }

    private static int dfs(int x, int y) {
        if (visited[x][y]) return 0;
        visited[x][y] = true;
        int areaSize = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dirX[i];
            int ny = y + dirY[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    areaSize += dfs(nx, ny);
                }
            }
        }
        return areaSize;
    }
}
