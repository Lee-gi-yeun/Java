package com.ohgiraffers.section02.extend;

public class WildCardFarm {

    // 타입변수가 선언 된 RabbitFarm 객체를 생성할 때 보다 유연하게 wildcard를 활용해 본다
    public void anyType(RabbitFarm<?> farm){
        farm.getRabbit().cry();
    }

    public void extendType(RabbitFarm<? extends Bunny> farm){
        farm.getRabbit().cry();
    }

    public void superType(RabbitFarm<? super Bunny> farm){
        farm.getRabbit().cry();
    }
}
