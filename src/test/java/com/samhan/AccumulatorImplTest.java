package com.samhan;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccumulatorImplTest {
    private Accumulator accumulator;

    @Before
    public void setup() {
        accumulator = new AccumulatorImpl();
    }

    @Test
    public void accumulatorStartsWith0Total() {
        assertThat(accumulator.getTotal(), is(0));
    }

    @Test
    public void accumulateOfSingleNumberReturnsItself() {
        int result = accumulator.accumulate(5);

        assertThat(result, is(5));
    }

    @Test
    public void accumulateReturnsTheSumOfArguments() {
        int result = accumulator.accumulate(1, 2, 3, 4);

        assertThat(result, is(10));
    }

    @Test
    public void accumulateUpdatesTheTotal() {
        accumulator.accumulate(5);

        assertThat(accumulator.getTotal(), is(5));
    }

    @Test
    public void resetTheRunningTotalTo0() {
        accumulator.accumulate(5);
        assertThat(accumulator.getTotal(), is(5));

        accumulator.reset();

        assertThat(accumulator.getTotal(), is(0));
    }

    @Test
    public void UsageExample() {
        int firstSum = accumulator.accumulate(1, 2, 3);
        int secondSum = accumulator.accumulate(4);
        int total = accumulator.getTotal();

        assertThat(firstSum, is(6));
        assertThat(secondSum, is(4));
        assertThat(total, is(10));

        accumulator.reset();

        assertThat(accumulator.getTotal(), is(0));
    }
}
