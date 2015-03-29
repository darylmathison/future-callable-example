/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mathison.futurecallable;

import java.util.concurrent.Callable;

/**
 *
 * @author Daryl
 */
public class CounterCallable implements Callable<SumTimeAnswer> {

    private long start;
    private long end;
    
    public CounterCallable(long start, long end) {
        this.start = start;
        this.end = end;
    }
    
    @Override
    public SumTimeAnswer call() throws Exception {
        long sum = 0;
        long startTime = System.currentTimeMillis();
        for(long i = start; i <= end; i++){
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        
        return new SumTimeAnswer(sum, endTime - startTime);
    }
}
