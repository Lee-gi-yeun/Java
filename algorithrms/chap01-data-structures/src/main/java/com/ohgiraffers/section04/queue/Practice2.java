package com.ohgiraffers.section04.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {

    public int solution(int w, int l, Integer[] truckWeight) {

        Queue<Integer> bridge = new LinkedList<>(); // 다리 위에 있는 트럭들 (길이 = w)
        int time = 0; // 경과 시간
        int currentWeight = 0; // 다리 위 트럭들의 총 무게

        for (int i = 0; i < w; i++) {
            bridge.offer(0); // 다리 길이만큼 0(빈 공간)으로 초기화
        }

        Queue<Integer> waitingTrucks = new LinkedList<>(Arrays.asList(truckWeight)); // 대기 트럭

        while (!waitingTrucks.isEmpty() || currentWeight > 0) {
            time++; // 시간 증가
            currentWeight -= bridge.poll(); // 다리에서 트럭(또는 빈 공간) 하나 제거

            if (!waitingTrucks.isEmpty()) {
                int nextTruck = waitingTrucks.peek(); // 대기 중인 첫 번째 트럭
                if (currentWeight + nextTruck <= l) { // 다리에 올릴 수 있는지 확인
                    bridge.offer(nextTruck); // 다리에 트럭 추가
                    currentWeight += nextTruck;
                    waitingTrucks.poll(); // 대기 트럭에서 제거
                } else {
                    bridge.offer(0); // 트럭을 올릴 수 없으면 빈 공간 유지
                }
            }
        }

//        // 트럭이 담긴 큐
//        Queue<Integer> trucks = new LinkedList<>(Arrays.asList(truckWeight));
//        // 다리의 상태를 표현하는 큐
//        Queue<Integer> bridge = new LinkedList<>();
//        // 다리 초기화
//        for (int i = 0; i < w; i++) {
//            bridge.offer(0);
//        }
//
//        int time = 0;
//        int currentLoad = 0;
//
//        // 트럭이 다리를 모두 지나갈 때까지 반복
//        while (!bridge.isEmpty()) {
//            // 한 번의 반복당 한번의 단위 시간이 소요 된다고 가정하여 시간은 증가하고 다리 큐는 제거 된다.
//            time++;
//            currentLoad -= bridge.poll();
//
//            // 아직 다리에 진입해야할 트럭이 남았다면
//            if (!trucks.isEmpty()) {
//                // 현재 다리의 하중과 진입할 트럭의 무게를 더했을 때 최대 하중보다 작다면
//                if (currentLoad + trucks.peek() <= l) {
//                    // 트럭이 다리에 진입
//                    int newTruck = trucks.poll();
//                    bridge.offer(newTruck);
//                    currentLoad += newTruck;
//                } else {
//                    // 트럭이 진입하지 못함
//                    bridge.offer(0);
//                }
//            }
//        }

        return time;
        }
}