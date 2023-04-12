package edu.neu.coe.info6205.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Benchmark
{
    private LocalDateTime start;
    private LocalDateTime end;
    private long time = 0;
    private boolean startCheck = false;
    private boolean endCheck = false;

    public Benchmark() {}
   
    public void startMark()
    {
        startCheck = true;
        start = LocalDateTime.now();
    }

    public void endMark()
    {
        endCheck = true;
        end = LocalDateTime.now();
    }

    public long currentTime()
    {
    	return ChronoUnit.SECONDS.between(start, LocalDateTime.now());
    }

    public long resultTime()
    {
        if(startCheck && endCheck) {
            return ChronoUnit.MILLIS.between(start, end);
        } else {
            System.out.print("BenchMark Failed. ");
        }
        return time;
    }
   
}