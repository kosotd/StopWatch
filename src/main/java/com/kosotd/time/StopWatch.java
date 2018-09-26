package com.kosotd.time;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class StopWatch {
    private static Map<Integer, StopWatch> instances = new HashMap<>();
    private static Logger logger = Logger.getLogger(StopWatch.class.getName());
    private long startTime;
    private boolean started = false;

    private StopWatch(){}

    public static StopWatch getInstance(int id) {
        return instances.computeIfAbsent(id, integer -> new StopWatch());
    }

    public void start() {
        startTime = System.nanoTime();
        started = true;
    }

    public void stop(BiConsumer<Logger, Long> consumer){
        stop(TimeUnit.MILLISECONDS, consumer);
    }

    public void stop(TimeUnit timeUnit, BiConsumer<Logger, Long> consumer){
        long stopTime = stop(timeUnit);
        consumer.accept(logger, stopTime);
    }

    public long stop(){
        return stop(TimeUnit.MILLISECONDS);
    }

    public long stop(TimeUnit timeUnit){
        if (!started) throw new RuntimeException("Timer not started");
        started = false;
        long nanoTime = System.nanoTime() - startTime;
        return timeUnit.convert(nanoTime, TimeUnit.NANOSECONDS);
    }
}
