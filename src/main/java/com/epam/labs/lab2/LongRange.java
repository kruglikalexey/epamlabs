package com.epam.labs.lab2;

import lombok.Value;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Value
public class LongRange implements Range<Long> {
    Long upperBound;
    Long lowerBound;

    public LongRange(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException(String.format("%s is upper, %s is lower, it\'s wrong", upperBound, lowerBound));
        }
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    @Override
    public boolean isBefore(Range<Long> other) {
        return upperBound < other.getLowerBound();
    }

    @Override
    public boolean isAfter(Range<Long> other) {
        return lowerBound > other.getUpperBound();
    }

    @Override
    public boolean isConcurrent(Range<Long> other) {
        return !isAfter(other) && !isBefore(other);
    }

    @Override
    public boolean contains(Long value) {
        return value < upperBound && value >= lowerBound;
    }

    @Override
    public List<Long> asList() {
        List<Long> list = new ArrayList<Long>((int) (upperBound - lowerBound + 1));
        for (long i = lowerBound; i < upperBound; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public Iterator<Long> asIterator() {
        return asList().iterator();
    }
}
