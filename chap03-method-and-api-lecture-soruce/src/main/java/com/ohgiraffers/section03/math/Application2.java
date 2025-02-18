package com.ohgiraffers.section03.math;

import java.util.Random;

public class Application2 {
    public static void main(String[] args) {
        // 사용자 범위의 난수 발생 시키기

        // 1. Math.randon()

        // 0~9 범위의 랜덤 값
        int random1 = (int) (Math.random() * 10);
        System.out.println(random1);
        // 1~10 범위의 랜덤 값
        int random2 = (int) (Math.random() * 10) + 1;
        System.out.println(random2);

        // 2. Random 클래스
        Random random = new Random();
        // 0~9 범위의 랜덤 값
        int random3 = random.nextInt(10);
        // 1~10 범위의 랜덤 값
        int random4 = random.nextInt(10) + 1;

        System.out.println(random3);
        System.out.println(random4);


    }
}
