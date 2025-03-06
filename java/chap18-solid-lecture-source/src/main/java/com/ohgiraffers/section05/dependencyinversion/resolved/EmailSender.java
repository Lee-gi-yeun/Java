package com.ohgiraffers.section05.dependencyinversion.resolved;

public class EmailSender implements MessageSender{

    @Override
    public void sendMessage(String messgae) {
        System.out.println("이메일로 알림을 발송 : " + messgae);
    }
}
