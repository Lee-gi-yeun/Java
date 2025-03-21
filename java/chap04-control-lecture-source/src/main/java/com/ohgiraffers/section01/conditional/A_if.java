package com.ohgiraffers.section01.conditional;

import java.util.Scanner;

public class A_if {

    public void testSimpleIfStatement(){
        // if 문 단독 사용의 흐름을 이해하고 적용할 수 있다.
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 하나 입력 : ");
        int num = sc.nextInt();

        if(num % 2 == 0) {
            System.out.println("짝수");
        }
        System.out.println("프로그램 종료");
    }

    public void testNestedIfStatement(){
        // 중첩 if 문의 흐름을 이해하고 적용할 수 있다.
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자 하나 입력 : ");
        int num = sc.nextInt();

        if(num > 0) {
            if(num % 2 == 0) {
                System.out.println("짝수");
            }
        }
        System.out.println("프로그램 종료");
    }
}
