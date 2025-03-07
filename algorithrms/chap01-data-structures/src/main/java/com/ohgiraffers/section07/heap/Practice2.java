package com.ohgiraffers.section07.heap;

import java.util.*;

public class Practice2 {

    public long solution(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int n = Integer.parseInt(firstLine[0]); // 보석 개수
        int k = Integer.parseInt(firstLine[1]); // 가방 개수

        // 보석 리스트 (무게, 가격)
        List<int[]> jewels = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] jewelData = lines[i].split(" ");
            int m = Integer.parseInt(jewelData[0]); // 무게
            int v = Integer.parseInt(jewelData[1]); // 가격
            jewels.add(new int[]{m, v});
        }

        // 가방 리스트
        List<Integer> bags = new ArrayList<>();
        for (int i = n + 1; i < n + 1 + k; i++) {
            bags.add(Integer.parseInt(lines[i]));
        }

        // **Step 1: 정렬**
        // 보석을 무게(m) 기준으로 오름차순 정렬
        Collections.sort(jewels, Comparator.comparingInt(a -> a[0]));
        // 가방도 무게 기준으로 오름차순 정렬
        Collections.sort(bags);

        // **Step 2: 우선순위 큐(최대 힙) 활용**
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long maxValue = 0;
        int index = 0;

        // 가방을 하나씩 확인하면서 보석을 선택
        for (int bagWeight : bags) {
            // 현재 가방에 넣을 수 있는 모든 보석 추가
            while (index < jewels.size() && jewels.get(index)[0] <= bagWeight) {
                maxHeap.offer(jewels.get(index)[1]); // 보석 가격 저장
                index++;
            }

            // 가장 비싼 보석을 가져감
            if (!maxHeap.isEmpty()) {
                maxValue += maxHeap.poll();
            }
        }

        return maxValue;
    }
}
