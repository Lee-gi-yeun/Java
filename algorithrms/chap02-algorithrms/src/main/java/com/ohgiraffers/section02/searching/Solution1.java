package com.ohgiraffers.section02.searching;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {

        public int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            // 방향 벡터 (상, 하, 좌, 우)
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            // BFS를 위한 큐
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0}); // 시작 위치 (0,0) 큐에 추가

            // 방문 여부를 체크하는 배열
            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true; // 시작 지점 방문 처리

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];

                // 목적지 도달하면 최단 거리 반환
                if (x == n - 1 && y == m - 1) {
                    return maps[x][y];
                }

                // 4방향 탐색 (상, 하, 좌, 우)
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    // 범위 체크 & 이동 가능 여부 확인
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;  // 방문 처리
                        maps[nx][ny] = maps[x][y] + 1;  // 거리 갱신
                        queue.offer(new int[]{nx, ny});  // 이동할 위치 큐에 추가
                    }
                }
            }

            return -1; // 도달할 수 없는 경우
        }
}
