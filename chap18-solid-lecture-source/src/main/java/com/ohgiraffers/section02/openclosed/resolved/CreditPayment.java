package com.ohgiraffers.section02.openclosed.resolved;

public class CreditPayment implements Payment{

    @Override
    public void process() {
        System.out.println("신용카드로 결제합니다.");
    }
}
