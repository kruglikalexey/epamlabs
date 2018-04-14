package com.epam.labs.lab2;

import java.util.Iterator;
import java.util.List;

public interface Range <T extends Comparable> {
    boolean isBefore(Range<T> other);
    boolean isAfter(Range<T> other);
    boolean isConcurrent(Range<T> other);
    T getLowerBound();
    T getUpperBound();
    boolean contains(T value);
    List<T> asList();
    Iterator<T> asIterator();
}
