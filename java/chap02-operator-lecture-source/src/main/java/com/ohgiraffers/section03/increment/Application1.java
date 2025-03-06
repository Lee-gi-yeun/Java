package com.ohgiraffers.section03.increment;

public class Application1 {
    public static void main(String[] args) {
        /* 단항으로 사용될 때는 1 증가/1 감소의 의미를 가진다. */
        int num = 20;
        System.out.println("num : " + num);

        num++;		//1 증가
        System.out.println("num : " + num);

        ++num;		//1 증가
        System.out.println("num : " + num);

        num--;		//1 감소
        System.out.println("num : " + num);

        --num;		//1 감소
        System.out.println("num : " + num);

        // 다른 연산자와 함께 증감 연산자를 사용하는 경우
        int firstNum = 20;
        int result1 = firstNum++ * 3;
        System.out.println("fisrtNum : " + firstNum);
        System.out.println("result1 : " + result1);

        int secondNum = 20;
        int result2 = ++secondNum * 3;
        System.out.println("secondNum : " + secondNum);
        System.out.println("result2 : " + result2);
    }
}
