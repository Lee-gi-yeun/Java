package com.ohgiraffers.section01.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class E_MergeSortTest {

    static int[] act1, act2, exp1, exp2;

    @BeforeAll
    static void setUp(){
        act1 = new int[] {24,32,42,60,15,5,90,45};
        exp1 = new int[] {5,15,24,32,42,45,60,90};

    }

    static Stream<Arguments> provideAscendingSource(){
        return Stream.of(
                Arguments.of(act1,exp1)
        );
    }

    @DisplayName("병합 정렬 테스트")
    @ParameterizedTest
    @MethodSource("provideAscendingSource")
    void testQuickSort(int[] actual,int[] expected){
        E_MergeSort.solution(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

}