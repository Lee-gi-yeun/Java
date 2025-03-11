package com.ohgiraffers.section02.searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SolutionTest {

    private static String input1, input2, input3;
    private static String output1, output2, output3;

    @BeforeAll
    public static void set() {
        input1 = "5 7 3\n" +
                "0 2 4 4\n" +
                "1 1 2 5\n" +
                "4 0 6 2";

        output1 = "3\n1 7 13";
    }

    public static Stream<Arguments> provideSource() {
        return Stream.of(
                arguments(input1, output1)
        );
    }

    @DisplayName("Baekjoon 2583 - 영역 구하기")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("provideSource")
    public void testSolution(String input, String expected) throws IOException {
        String result = Solution.solution(input);
        Assertions.assertEquals(expected, result.trim());
    }
}
