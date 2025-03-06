package com.ohgiraffers.section01.method;

// 메인 메소드 (실행 메소드) 없이 기능 메소드만 정의
public class Calculator {
    public int min(int a, int b){
        return a < b ? a : b;
    }
    public static int max(int a, int b){
        return a > b ? a : b;
    }
}
