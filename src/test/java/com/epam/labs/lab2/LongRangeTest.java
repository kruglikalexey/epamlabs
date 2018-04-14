package com.epam.labs.lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;

class LongRangeTest {

    static Range<Long> range1;
    static Range<Long> range2;
    static Range<Long> range3;
    static Range<Long> range4;

    static Stream<Arguments> provideContains() {
        return Stream.of(
                Arguments.of(range1, 3L, true),
                Arguments.of(range1, 7L, false),
                Arguments.of(range2, 7L, true),
                Arguments.of(range4, 100L, false),
                Arguments.of(range3, 6L, true)
        );
    }

    @BeforeEach
    void setUp() {
        range1 = new LongRange(1, 5);
        range2 = new LongRange(6, 8);
        range3 = new LongRange(6, 7);
        range4 = new LongRange(9, 14);
    }

    @Test
    void isBefore() {
        assertThat(range1.isBefore(range2) && range1.isBefore(range3) && range1.isBefore(range4), is(true));
    }

    @Test
    void isAfter() {
        assertThat(range2.isAfter(range1) && range3.isAfter(range1) && range4.isAfter(range3), is(true));
    }

    @Test
    void isConcurrent() {
        assertThat(range2.isConcurrent(range3), is(true));
    }

    @ParameterizedTest
    @MethodSource("provideContains")
    void contains(Range<Long> range, long item, boolean answer) {
        assertThat(range.contains(item), is(answer));
    }

    @Test
    void asList() {
        assertThat(range1.asList(), equalTo(Arrays.asList(1L, 2L, 3L, 4L)));
    }

    @Test
    void asIterator() {
        assertThat(range1.asIterator(), notNullValue());
    }
}