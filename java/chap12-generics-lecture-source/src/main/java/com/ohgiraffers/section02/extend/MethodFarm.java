package com.ohgiraffers.section02.extend;

public class MethodFarm {
    // 메소드 매개변수로 전달 받은 타입 객체
    public <T> void animalType(T t1, T t2){

    }
    public <T extends Mammal> void mammalType(T t){

    }
    public <T extends Reptile> void raptitleType(T t){

    }
}
