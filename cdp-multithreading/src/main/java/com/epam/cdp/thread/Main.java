package com.epam.cdp.thread;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.ShellFactory;
import com.epam.cdp.thread.command.FindFileCommand;
import com.epam.cdp.thread.pool.ThreadPool;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    private static final String PROP_FILE_NAME = "config.properties";
    private static final String NUM_THREADS = "num.threads";
    private static final String CAPACITY = "capacity";
    private static final String FILE_NAME = "file.name";

    private ThreadPool threadPool;
    private MyWriter myWriter;

    public Main() throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME));

        int numThreads = Integer.valueOf(prop.getProperty(NUM_THREADS));
        int capacity = Integer.valueOf(prop.getProperty(CAPACITY));
        String fileName = prop.getProperty(FILE_NAME);

        threadPool = new ThreadPool(numThreads, capacity);
        myWriter = new MyWriter(fileName);
    }

    @Command(name = "find")
    public void findFile(@Param(name = "directory") String directory, @Param(name = "file name") String fileName) {
        File dir = new File(directory);
        if (!dir.exists()) {
            LOGGER.info("Directory does not exist.");
        } else {
            threadPool.execute(new FindFileCommand(dir, fileName, myWriter, threadPool));
        }
    }

    @Command(name = "stop")
    public void stop() {
        threadPool.stop();
    }

    @Command(name = "start")
    public void start() {
        threadPool.start();
    }

    @Command(name = "list")
    public void list() {
        System.out.println(threadPool.list());
    }

    @Command(name = "exit")
    public void exit() {
        threadPool.shutdownNow();
        myWriter.close();
    }

    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("thread", "Type ?list or ?list-all, to see available commands.",
                new Main()).commandLoop();
    }
}
