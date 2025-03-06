package com.ohgiraffers.section02.openclosed.resolved;

public class KakaoPayment implements Payment{

    @Override
    public void process() {
        System.out.println("카카오페이로 결제합니다.");
    }
}
