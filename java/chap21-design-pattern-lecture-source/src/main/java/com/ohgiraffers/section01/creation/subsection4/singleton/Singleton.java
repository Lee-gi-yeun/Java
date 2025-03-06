package com.ohgiraffers.section01.creation.subsection4.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("싱글톤 객체입니다.");
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        singleton1.showMessage();
        System.out.println(singleton1 == singleton2); // true

        // Java API 예시
        // Runtime : 실행 환경과 관련된 정보를 관리하는 객체로 단 하나의 객체만 만들어져서 관리 된다
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
    }
}
