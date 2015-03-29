/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.mathison.futurecallable;

/**
 *
 * @author Daryl
 */
public class SumTimeAnswer {
    private long timeToFinish;
    private long sum;

    public SumTimeAnswer(long sum, long timeToFinish) {
        this.sum = sum;
        this.timeToFinish = timeToFinish;
    }
    
    public long getTimeToFinish() {
        return timeToFinish;
    }

    public long getSum() {
        return sum;
    }
}
