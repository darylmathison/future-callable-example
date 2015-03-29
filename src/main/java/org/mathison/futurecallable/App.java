package org.mathison.futurecallable;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static final long BEGIN = 0;
    public static final long END = 100000;
    public static void main( String[] args )
    {
        FutureTask<SumTimeAnswer> task = new FutureTask<>(new CounterCallable(BEGIN, END));
        FutureTask<SumTimeAnswer> firstHalf = new FutureTask<>(new CounterCallable(BEGIN, END/2));
        FutureTask<SumTimeAnswer> secondHalf = new FutureTask<>(new CounterCallable(END/2 + 1, END));
        
        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.submit(task);
        pool.submit(firstHalf);
        pool.submit(secondHalf);
        
        try {
            SumTimeAnswer taskAnswer = task.get();
            System.out.println("just one thread Time: " + taskAnswer.getTimeToFinish()
                + " Total: " + taskAnswer.getSum());
            
            
            SumTimeAnswer taskFirstAnswer = firstHalf.get();
            SumTimeAnswer taskSecondAnswer = secondHalf.get();
            long totalTime = taskFirstAnswer.getTimeToFinish() + taskSecondAnswer.getTimeToFinish();
            long totalSum = taskFirstAnswer.getSum() + taskSecondAnswer.getSum();
            System.out.println("Two thread time: " + totalTime + " Total: " + totalSum);
        } catch(CancellationException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
