package com.ohgiraffers.section01.array.level04.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application1 {

    public static void main(String[] args) {

        /* 로또번호 생성기
         * 6칸 짜리 정수 배열을 하나 생성하고
         * 1부터 45까지의 중복되지 않는 난수를 발생시켜 각 인덱스에 대입한 뒤
         * 오름차순 정렬하여 출력하세요.
         * Arrays.sort(배열) 메소드 활용하여 정렬 가능.
         * */
        int n = 6;  // 생성할 난수 개수
        int min = 1, max = 45;  // 난수 범위 [min, max]

        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);  // 리스트를 랜덤으로 섞기
        List<Integer> result = numbers.subList(0, n);  // n개 추출

        int[] arr = new int[6];

        for(int i=0; i<n;i++){
            arr[i]= result.get(i);
        }

        Arrays.sort(arr);

        for(int i=0; i<n;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}