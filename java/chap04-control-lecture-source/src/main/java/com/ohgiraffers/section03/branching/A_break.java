package com.ohgiraffers.section03.branching;

public class A_break {

    public void testSimpleBreakStatement() {

        int sum = 0;
        int i = 1;

        // 무한 루프
        while (true) {
            sum += i++;
            // 중단 조건
            if (i > 100) break;
        }
        System.out.println("sum : " + sum);
    }

    public void testSimpleBreakStatement2() {

        for (int i = 2; i < 10; i++) {
            System.out.println("========" + i + "단========");
            for (int j = 1; j < 10; j++) {
                if (j > 5) break;
                System.out.println(i + " X " + j + " = " + i * j);
            }
            System.out.println();
        }
    }

    public void testJumpBreak() {
        // 중첩 반복문 내에서 break 사용 시 jump에 대한 흐름을 이해할 수 있다
        label:
        for(;;) {   // 무한 루프
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i==3) break label;
            }
        }
    }
}
