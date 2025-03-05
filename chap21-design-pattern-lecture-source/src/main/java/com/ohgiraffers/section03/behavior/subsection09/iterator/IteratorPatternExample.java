package com.ohgiraffers.section03.behavior.subsection09.iterator;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class IteratorPatternExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("홍길동");
        names.add("유관순");

        // 이터레이터를 사용하여 요소 순회
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}