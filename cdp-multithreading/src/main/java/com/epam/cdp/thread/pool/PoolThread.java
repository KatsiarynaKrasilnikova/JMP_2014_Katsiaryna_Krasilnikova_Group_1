package com.epam.cdp.thread.pool;

import com.epam.cdp.thread.command.ICommand;

import java.util.concurrent.BlockingQueue;

public class PoolThread implements Runnable {

    private BlockingQueue<ICommand> commands;
    private boolean isInterrupted;
    private boolean isStoped;

    public PoolThread(BlockingQueue<ICommand> commands) {
        this.commands = commands;
    }

    public void run() {
        while (!isInterrupted()) {
            ICommand command = commands.poll();
            if (command != null) {
                command.execute();
            }
        }
    }

    public synchronized void interrupt() {
        isInterrupted = true;
    }

    public synchronized void stop() {
        isStoped = true;
    }

    public synchronized boolean isInterrupted() {
        return isInterrupted;
    }

    public synchronized boolean isStoped() {
        return isStoped;
    }
}
