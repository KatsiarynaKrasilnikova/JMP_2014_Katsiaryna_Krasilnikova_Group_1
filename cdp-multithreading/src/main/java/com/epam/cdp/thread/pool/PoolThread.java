package com.epam.cdp.thread.pool;

import com.epam.cdp.thread.command.ICommand;
import org.apache.log4j.Logger;

import java.util.concurrent.BlockingQueue;

public class PoolThread implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(PoolThread.class);

    private BlockingQueue<ICommand> commands;
    private boolean isStopped;

    public PoolThread(BlockingQueue<ICommand> commands) {
        this.commands = commands;
    }

    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                while (isStopped()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        LOGGER.error(e);
                    }
                }
            }

            ICommand command = commands.poll();
            if (command != null) {
                command.execute();
            }
        }
    }

    public synchronized void stop() {
        isStopped = true;
    }

    public synchronized void start() {
        isStopped = false;
        notifyAll();
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
