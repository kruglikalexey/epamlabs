package com.epam.labs.lab1;

import org.junit.gen5.api.DisplayName;
import org.junit.gen5.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@DisplayName("LAB1: Parameterized tests.")
public class UtilsTest {

    private static Stream<Arguments> factorialProvider() {
        return Stream.of(
                Arguments.of(1L, 1L),
                Arguments.of(2L, 2L),
                Arguments.of(3L, 6L),
                Arguments.of(4L, 24L)
        );
    }

    private static Stream<Arguments> divideProvider() {
        return Stream.of(
                Arguments.of(1d, 1d, 1d),
                Arguments.of(1d, 2d, 1d / 2d),
                Arguments.of(3d, 5d, 3d / 5d)
        );
    }

    private static Stream<Arguments> multiplyProvider() {
        return Stream.of(
                Arguments.of(1d, 1d, 1d),
                Arguments.of(1d, 2d, 2d),
                Arguments.of(3d, 5d, 3d * 5d),
                Arguments.of(1233d, -13d, 1233d * -13d)
        );
    }

    @Test
    @DisplayName("LAB1: Factorial test.")
    @ParameterizedTest(name = "{index}: {0} -> {1}")
    @MethodSource("factorialProvider")
    public void factorial(long input, long output) {
        assertThat(Utils.factorial(input), is(output));
    }

    @Test
    @DisplayName("LAB1: Divide test.")
    @ParameterizedTest(name = "{index}: {0} / {1} = {2}")
    @MethodSource("divideProvider")
    public void divide(double left, double right, double answer) {
        assertThat(Utils.divide(left, right), is(answer));

    }

    @Test
    @DisplayName("LAB1: Factorial test.")
    @ParameterizedTest(name = "{index}: {0} * {1} -> {2}")
    @MethodSource("multiplyProvider")
    public void multiply(double left, double right, double answer) {
        assertThat(Utils.multiply(left, right), is(answer));
    }
}
