package com.ohgiraffers.section07.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
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

    public long solution2(String input) {
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int n = Integer.parseInt(firstLine[0]);     // n = 보석 갯수
        int k = Integer.parseInt(firstLine[1]);     // k = 가방 갯수

        List<int[]> jewels = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            String[] jewelData = lines[i].split(" ");
            int m = Integer.parseInt(jewelData[0]);     // m = 보석 무게
            int v = Integer.parseInt(jewelData[1]);     // k = 보석 가격
            jewels.add(new int[]{m, v});
        }

        List<Integer> bags = new ArrayList<>();
        for(int i = n+1; i< n+1 + k; i++){
            bags.add(Integer.parseInt(lines[i]));
        }

        Collections.sort(jewels, Comparator.comparingInt(a -> a[0]));
        Collections.sort(bags);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long maxValue = 0;
        int index = 0;

        for(int bagWeight : bags){
            while  (index < jewels.size() && jewels.get(index)[0] <= bagWeight) {
                maxHeap.offer(jewels.get(index)[1]);
                index++;
            }
            if (!maxHeap.isEmpty()) {
                maxValue += maxHeap.poll();
            }
        }
        return maxValue;

//        int weight;
//        int price;
//
//        Jewelry(int weight, int price) {
//            this.weight = weight;
//            this.price = price;
//        }
//
//        // 무게 오름차순, 무게가 같으면 가격 내림차순 정렬
//        @Override
//        public int compareTo(Jewelry o) {
//            if(this.weight == o.weight)
//                return o.price - this.price;
//            return this.weight - o.weight;
//        }
//    }
//
//    public long solution(String input) throws IOException {
//        BufferedReader br = new BufferedReader(new StringReader(input));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());   // 보석 개수
//        int k = Integer.parseInt(st.nextToken());   // 가방 개수
//
//        Jewelry[] jewelries = new Jewelry[n];   // 보석 저장 배열
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            int weight = Integer.parseInt(st.nextToken());
//            int price = Integer.parseInt(st.nextToken());
//            jewelries[i] = new Jewelry(weight, price);
//        }
//
//        int[] bags = new int[k];    // 가방 무게 저장 배열
//        for (int i = 0; i < k; i++) {
//            bags[i] = Integer.parseInt(br.readLine());
//        }
//
//        // 가방에 보석을 넣을 때 큰 가방부터 탐색하면 작은 가방에 넣을 수 없는 경우가 발생하므로 오름차순 정렬
//        Arrays.sort(bags);
//        // 보석도 무게가 낮은 것부터 탐색하도록 무게 오름차순 정렬
//        // 단, 가격의 최대값을 구해야하기 때문에 무게가 같을 때에는 가격 내림차순으로 정렬
//        Arrays.sort(jewelries);
//
//        // 보석을 담아 둘 우선순위 큐는 항상 가격이 내림차순 정렬되도록 설정 (가격 최대값의 경우를 계산하기 위해)
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        long totalPrice = 0;
//        int jewelryIndex = 0;
//        for (int i = 0; i < k; i++) {
//
//            int bagCapacity = bags[i];
//
//            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음
//            while (jewelryIndex < n && jewelries[jewelryIndex].weight <= bagCapacity) {
//                pq.offer(jewelries[jewelryIndex].price);
//                jewelryIndex++;
//            }
//
//            // 가장 비싼 보석을 가방에 담음
//            if (!pq.isEmpty()) {
//                totalPrice += pq.poll();
//            }
//        }
//
//        return totalPrice;
    }
}


