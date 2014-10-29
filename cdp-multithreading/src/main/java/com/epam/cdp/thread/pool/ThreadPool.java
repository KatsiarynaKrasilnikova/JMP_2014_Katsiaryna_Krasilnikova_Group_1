package com.epam.cdp.thread.pool;

import com.epam.cdp.thread.command.ICommand;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue<ICommand> commands = null;
    private List<PoolThread> threads = new ArrayList<>();
    private boolean isStoped = false;

    public ThreadPool(int numThreads, int capacity) {
        commands = new ArrayBlockingQueue<>(capacity);

        for (int i = 0; i < numThreads; i++) {
            threads.add(new PoolThread(commands));
        }
        for (PoolThread thread : threads) {
            new Thread(thread).start();
        }
    }

    public void execute(ICommand command) {
        synchronized (commands) {
            commands.offer(command);
        }
    }

    /*public void stop() throws InterruptedException {
        isStoped = true;
        synchronized (commands) {
            while (isStoped) {
                commands.wait();
            }
        }
    }

    public void start() throws InterruptedException {
        isStoped = false;
        synchronized (commands) {
            commands.notifyAll();
        }
    }*/

    public synchronized void interrupt() {
        for (PoolThread thread : threads) {
            thread.interrupt();
        }
    }
}
