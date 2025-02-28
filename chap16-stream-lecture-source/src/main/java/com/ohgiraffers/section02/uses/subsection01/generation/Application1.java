package com.ohgiraffers.section02.uses.subsection01.generation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application1 {
    public static void main(String[] args) {
        // 배열이나 컬렉션을 이용하여 스트림을 생성하는 방법을 이해하고 사용할 수 있다

        // 배열을 스트림으로 생성하기
        String[] sarr = {"java","mariadb","jdbc"};
        Stream<String> strStream1 = Arrays.stream(sarr);
        strStream1.forEach(System.out::println);

        Stream<String> strStream2 = Arrays.stream(sarr, 0,2);
        strStream2.forEach(System.out::println);

        // 컬렉션을 스트림으로 생성하기
        List<String> stringList = Arrays.asList("html","css","javascript");
        Stream<String> strStream3 = stringList.stream();
        strStream3.forEach(System.out::println);
        // 컬렉션에도 forEach 기능은 정의되어 있으므로 stream 화 하지 않고 사용할 수 있다
        stringList.forEach(System.out::println);

        // Builder 를 활용한 스트림 생성
        Stream<String> strStream4 = Stream.<String>builder()
                .add("유관순")
                .add("홍길동")
                .add("윤봉길")
                .build();
        strStream4.forEach(System.out::println);

        // iterator()를 활용하여 수열 형태의 스트림을 생성
        Stream<Integer> intStream =
                Stream.iterate(10, value -> value *2).limit(10);
        intStream.forEach(System.out::println);
    }
}
