package com.ohgiraffers.section02.uses.subsection02.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Application4 {
    public static void main(String[] args) {
        // 스트림의 중계 연산 중 sorted 에 대해 이해하고 사용할 수 있다
        List<Integer> integerList =
                IntStream.of(5,10,99,7,1,50)
                        .boxed()
                        .sorted((a,b) -> b - a)
//                        .sorted(Comparator.reverseOrder())
                        .toList();

        System.out.println(integerList);
    }
}
