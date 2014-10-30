package com.epam.cdp.thread.pool;

import com.epam.cdp.thread.command.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    private BlockingQueue<ICommand> commands = null;
    private List<PoolThread> threads = new ArrayList<>();

    private ExecutorService executor;

    public ThreadPool(int numThreads, int capacity) {
        commands = new ArrayBlockingQueue<>(capacity);
        executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numThreads; i++) {
            threads.add(new PoolThread(commands));
        }

        for (PoolThread thread : threads) {
            executor.execute(thread);
        }
    }

    public void execute(ICommand command) {
        commands.offer(command);
    }

    public void stop() {
        for (PoolThread thread : threads) {
            thread.stop();
        }
    }

    public void start() {
        for (PoolThread thread : threads) {
            thread.start();
        }
    }

    public void shutdownNow() {
        executor.shutdownNow();
    }

    public String list() {
        return executor.toString();
    }
}
