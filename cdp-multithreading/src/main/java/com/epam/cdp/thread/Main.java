package com.epam.cdp.thread;

import asg.cliche.Command;
import asg.cliche.ShellFactory;
import com.epam.cdp.thread.command.FindFileCommand;
import com.epam.cdp.thread.pool.ThreadPool;

import java.io.File;
import java.io.IOException;

public class Main {

    File dir = new File("C:\\Users\\Ilya_Kukushkin\\Desktop");
    String fileName = "SETTINGS.txt";

    private ThreadPool threadPool;
    private MyWriter myWriter;

    public Main() throws IOException {
        threadPool = new ThreadPool(5, 10);
        myWriter = new MyWriter("file.txt");
    }

    @Command(name = "find", abbrev = "f")
    public void findFile() {
        threadPool.execute(new FindFileCommand(dir, fileName, myWriter, threadPool));
    }

    /*@Command(name = "stop")
    public void stop() throws InterruptedException {
        threadPool.stop();
    }

    @Command(name = "start")
    public void start() throws InterruptedException {
        threadPool.start();
    }*/

    @Command(name = "exit", abbrev = "e")
    public void exit() {
        threadPool.interrupt();
        myWriter.close();
    }

    public static void main(String[] args) throws IOException {
        ShellFactory.createConsoleShell("thread", "Type ?list or ?list-all, to see available commands.",
                new Main()).commandLoop();
    }
}
