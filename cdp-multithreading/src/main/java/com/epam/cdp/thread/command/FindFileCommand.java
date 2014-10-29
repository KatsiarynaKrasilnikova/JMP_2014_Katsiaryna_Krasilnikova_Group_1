package com.epam.cdp.thread.command;

import com.epam.cdp.thread.MyWriter;
import com.epam.cdp.thread.pool.ThreadPool;

import java.io.File;

public class FindFileCommand implements ICommand {

    private File dir;
    private String fileName;
    private MyWriter myWriter;
    private ThreadPool threadPool;

    public FindFileCommand(File dir, String fileName, MyWriter myWriter, ThreadPool threadPool) {
        this.dir = dir;
        this.fileName = fileName;
        this.myWriter = myWriter;
        this.threadPool = threadPool;
    }

    @Override
    public void execute() {
        findFile(dir);
    }

    private void findFile(File dir) {
        File file = new File(dir.getAbsolutePath() + File.separatorChar + fileName);

        if (file.isFile() && file.exists()) {
            myWriter.writeFilePath(file.getAbsolutePath());
        }
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                threadPool.execute(new FindFileCommand(f, fileName, myWriter, threadPool));
            }
        }
    }
}