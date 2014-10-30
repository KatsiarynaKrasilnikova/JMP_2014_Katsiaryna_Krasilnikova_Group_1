package com.epam.cdp.thread;

import org.apache.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyWriter {

    private static final Logger LOGGER = Logger.getLogger(MyWriter.class);

    private Lock lock;
    private BufferedWriter writer;

    public MyWriter(String file) throws IOException {
        lock = new ReentrantLock();
        writer = new BufferedWriter(new FileWriter(file, true));
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public void writeFilePath(String filePath) {
        lock.lock();
        try {
            writer.write(filePath);
            writer.newLine();
            LOGGER.info(filePath);
        } catch (IOException e) {
            LOGGER.error(e);
        } finally {
            lock.unlock();
        }
    }
}
