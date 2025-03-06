package com.ohgiraffers.section01.singleresponsibility.resolved;

public class PayCalculator {

    public void calculatePay(Employee emp) {
        int pay = emp.getWorkingHours() * emp.getPayRate();
        System.out.println(emp.getName()+ "의 급여는 " + emp.getPayRate() * emp.getWorkingHours() + "입니다");
    }
}
