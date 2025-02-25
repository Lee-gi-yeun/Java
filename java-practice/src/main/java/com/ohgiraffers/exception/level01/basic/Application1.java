package com.ohgiraffers.exception.level01.basic;

import com.ohgiraffers.level01.basic.Application;

import java.util.Scanner;

public class Application1 {
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * 분자 입력 : 10
         * 분모 입력 : 2
         *
         * ----- 출력 예시 -----
         *
         * 결과 : 5
         * 실행이 완료되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * 분자 입력 : 십
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 유효한 정수를 입력하세요.
         * 실행이 완료되었습니다.
         *
         * ----- 입력 예시 -----
         *
         * 분자 입력 : 10
         * 분모 입력 : 0
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 0으로 나누는 것은 허용되지 않습니다.
         * 실행이 완료되었습니다.
         */
        Scanner sc = new Scanner(System.in);
        Application1 application1 = new Application1();

        try {
            int molecule = getIntInput(sc, "분자 입력 : ");
            int denominator = getIntInput(sc, "분모 입력 : ");

            application1.method(molecule, denominator);
        } catch (Exception e) {
            System.out.println("오류 : " + e.getMessage());
        } finally {
            System.out.println("실행이 완료되었습니다.");
        }

    }

    public static int getIntInput(Scanner sc, String prompt) throws Exception {
        System.out.print(prompt);
        String input = sc.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new Exception("유효한 정수를 입력하세요.");
        }
    }

    public void method(int molecule, int denominator) throws DenominatorException {
        if (denominator == 0) {
            throw new DenominatorException("0으로 나누는 것은 허용되지 않습니다.");
        }
        System.out.println("결과 : " + molecule / denominator);
    }
}

