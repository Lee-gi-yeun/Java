package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.*;

public class Application2 {
    public static void main(String[] args) {
        // 메소드 매개변수 제네릭 제약을 사용할 수 있다
        MethodFarm methodFarm = new MethodFarm();

        // 별도의 제약 없이 인자를 전달할 수 있다
        methodFarm.animalType(new Bunny(), new Bunny());
        methodFarm.animalType(new Snake(), new Bunny());

        // extends Mammal의 제약이 적용 된다
//        methodFarm.mammalType(new Snake());
        methodFarm.mammalType(new Rabbit());

        // extends Raptitle의 제약이 적용 된다
        methodFarm.raptitleType(new Snake());
//        methodFarm.raptitleType(new Rabbit());

    }
}
