package com.ohgiraffers.section01.conditional;

public class Application {
    public static void main(String[] args) {
        A_if a_if = new A_if();
        B_ifElse b_ifElse = new B_ifElse();
        C_ifElseIf cIfElseIf = new C_ifElseIf();
        D_switch dSwitch = new D_switch();

//        a_if.testSimpleIfStatement();
//        a_if.testNestedIfStatement();

//        b_ifElse.testSimpleIfElseStatement();

//        cIfElseIf.testIfElseIfStatement();
//        cIfElseIf.testNestedIfElseIfStatement();
//        cIfElseIf.improveIfElseIfStatement();
//        dSwitch.testSimpleSwitchStatement();
        dSwitch.improveSwitchStatement();
    }
}
