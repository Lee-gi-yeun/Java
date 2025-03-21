package com.ohgiraffers.section01.literal;

public class Application03 {
    public static void main(String[] args) {

        System.out.println(9 + 9);              // 18
        System.out.println("9" + 9);            // "99"
        System.out.println(9 + "9");            // "99"
        System.out.println("9" + "9");          // "99"

        System.out.println(9 + 9 + "9");        // "189"
        System.out.println(9 + "9" + 9);        // "999"
        System.out.println("9" + 9 + 9);        // "999"
        System.out.println("9" + (9 + 9));      // "918"

        System.out.println("=========== 10과 20의 사칙연산 결과 ===========");
        System.out.println(10 + 20);
        System.out.println(10 - 20);
        System.out.println(10 * 20);
        System.out.println(10 / 20);
        System.out.println(10 % 20);

        System.out.println("=========== 10과 20의 사칙연산 결과 보기 좋게 출력 ===========");
        System.out.println("10과 20의 합 : " + (10 + 20));		//주의 : 괄호를 묶지 않으면 문자열 합치기가 일어나서 결과가 1020이 된다.
        System.out.println("10과 20의 차 : " + (10 - 20));		//문자열은 마이너스 연산이 불가능하기에 앞에서 생성된 문자열과 마이너스 연산이 불가하다. (반드시 괄호 사용)
        System.out.println("10과 20의 곱 : " + (10 * 20));		//아래 부터는 동일한 방식이다.
        System.out.println("10과 20을 나누기 한 몫 : " + (10 / 20));
        System.out.println("10과 20을 나누기 한 나머지 : " + (10 % 20));
    }
}
