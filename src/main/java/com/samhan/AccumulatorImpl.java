package com.samhan;

import java.util.Arrays;

public class AccumulatorImpl implements Accumulator {
    private int runningTotal;

    public AccumulatorImpl() {
        runningTotal = 0;
    }

    @Override
    public int accumulate(int... values) {
        int sum = Arrays.stream(values).sum();
        runningTotal += sum;
        return sum;
    }

    @Override
    public int getTotal() {
        return runningTotal;
    }

    @Override
    public void reset() {
        runningTotal = 0;
    }
}
