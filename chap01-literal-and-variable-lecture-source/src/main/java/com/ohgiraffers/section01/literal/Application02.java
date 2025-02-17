package com.ohgiraffers.section01.literal;

public class Application02 {
    public static void main(String[] args) {

        System.out.println("=== 정수와 정수 ====");
        System.out.println(123 + 456);
        System.out.println(123 - 23);
        System.out.println(123 * 10);
        System.out.println(123 / 10);
        System.out.println(123 % 10);

        System.out.println(1.23 + 1.23);
        System.out.println(1.23 - 0.23);
        System.out.println(1.23 * 10.0);
        System.out.println(1.23 / 10.0);
        System.out.println(1.23 % 1.0);			//약간의 오차가 생긴다

        System.out.println(123 + 0.5);
        System.out.println(123 - 0.5);
        System.out.println(123 * 0.5);
        System.out.println(123 / 0.5);
        System.out.println(123 % 0.5);

        System.out.println();
        System.out.println('a' + 'b');
        System.out.println('a' - 'b');
        System.out.println('a' * 'b');
        System.out.println('a' / 'b');
        System.out.println('a' % 'b');

        System.out.println('a' + 1);
        System.out.println('a' - 1);
        System.out.println('a' * 2);
        System.out.println('a' / 2);
        System.out.println('a' % 2);

        System.out.println("hello" + "world");
//System.out.println("hello" - "world");			//에러 발생
//System.out.println("hello" * "world");			//에러 발생
//System.out.println("hello" / "world");			//에러 발생
//System.out.println("hello" % "world");			//에러 발생

        System.out.println("====문자열과 다른 리터럴 ====");
        System.out.println("helloworld" + 123);
        System.out.println("helloworld" + 123.456);
        System.out.println("helloworld" + 'a');
        System.out.println("helloworld" + true);
        System.out.println("123" + "456");

        //System.out.println(true + false);				//에러 발생
//System.out.println(true - false);				//에러 발생
//System.out.println(true * false);				//에러 발생
//System.out.println(true / false);				//에러 발생
//System.out.println(true % false);				//에러 발생

        //System.out.println(true + 1);				//에러 발생
//System.out.println(true - 1);				//에러 발생
//System.out.println(true * 1);				//에러 발생
//System.out.println(true / 2);				//에러 발생
//System.out.println(true % 2);				//에러 발생

        //System.out.println(true + 1.0);				//에러 발생
//System.out.println(true - 1.0);				//에러 발생
//System.out.println(true * 1.0);				//에러 발생
//System.out.println(true / 2.0);				//에러 발생
//System.out.println(true % 2.0);				//에러 발생

        System.out.println(true + "a");		  		//문자열 합치기 됨
//System.out.println(true - "a");				//에러 발생
//System.out.println(true * "a");				//에러 발생
//System.out.println(true / "a");				//에러 발생
//System.out.println(true % "a");				//에러 발생

    }
}
