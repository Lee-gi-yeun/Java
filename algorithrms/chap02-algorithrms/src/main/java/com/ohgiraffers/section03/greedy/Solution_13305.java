package com.ohgiraffers.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution_13305 {

    public static long solution(String input) throws IOException {

        BufferedReader br = new BufferedReader(new StringReader(input));

        int N = Integer.parseInt(br.readLine());  // 도시 개수
        int[] distances = new int[N - 1];  // 도로 길이
        int[] prices = new int[N];  // 주유 가격

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 비용 계산
        long totalCost = 0;
        int minPrice = prices[0]; // 첫 번째 도시의 주유 가격

        for (int i = 0; i < N - 1; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // 더 저렴한 가격이 나오면 갱신
            }
            totalCost += (long) minPrice * distances[i]; // 최소 가격으로 주유
        }

        return totalCost;
    }
}
