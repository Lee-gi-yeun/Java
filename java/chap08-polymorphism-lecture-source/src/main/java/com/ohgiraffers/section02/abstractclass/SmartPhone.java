package com.ohgiraffers.section02.abstractclass;

public class SmartPhone extends Product{

    // 초상 클래스를 상속 받는 경우 추상 메소드를 반드시 오버라이딩 해야 한다
    // (오버라이딩 강제화)
    @Override
    public void abstMethod() {
        System.out.println("Product 클래스의 abstMethod 오버라이딩한 메소드");
    }

    public void printSmartPhone(){
        System.out.println("SmartPhone 클래스의 printSmartPhone 메소드");
    }
}
