package com.greedy.level01.basic;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.checkMethod();
        System.out.println("1부터 10 까지의 합 : "+calculator.sum1to10());
        System.out.print("두 수 중 큰 수는 ");
        calculator.checkMaxNumber(10, 20);

        System.out.println("10과 20의 합은 : "+calculator.sumTwoNumber(10,20));
        System.out.println("10과 5의 차는 : "+calculator.minusTwoNumber(10,5));

    }
}
