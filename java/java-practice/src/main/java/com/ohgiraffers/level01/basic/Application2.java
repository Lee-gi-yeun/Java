package com.ohgiraffers.level01.basic;

import java.util.Scanner;

public class Application2 {

    public static void main(String[] args) {

        /* ----- 입력 예시 -----
         *
         * 문자열 입력 : hello world Hello everyone! 안녕하세요 반갑습니다
                *
         * ----- 출력 예시 -----
         *
         * ===== 단어 빈도 =====
         * hello: 2
                * world: 1
                * everyone: 1
                * 가장 빈도 높은 단어 : hello (2 번)
                */
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 입력 : ");
        String str = sc.nextLine();
        int count=0;

        str = str.toLowerCase();
        String[] arr = str.split(" ");
        int[] countArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    isDuplicate = true; // 중복된 단어 발견
                    break;
                }
            }

            if (!isDuplicate) { // 중복이 아니면 빈도 증가
                countArr[count] = 1;
                count++;
            } else { // 중복된 단어라면 빈도 증가
                for (int k = 0; k < count; k++) {
                    if (arr[i].equals(arr[k])) {
                        countArr[k]++;
                        break;
                    }
                }
            }
        }
        int maxCount = 0;
        String maxWord = "";

        for (int i = 0; i < count; i++) {
            if (countArr[i] > maxCount) {
                maxCount = countArr[i];
                maxWord = arr[i];
            }
        }

        // 결과 출력
        System.out.println("\n===== 단어 빈도 =====");
        for (int i = 0; i < count; i++) {
            System.out.println(arr[i] + ": " + countArr[i]);
        }

        // 가장 빈도 높은 단어 출력
        System.out.println("\n가장 빈도 높은 단어 : " + maxWord + " (" + maxCount + " 번)");


    }
}