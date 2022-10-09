package thread;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Indexer implements Runnable {
    private final BlockingQueue<File> queue;

    public Indexer(BlockingQueue<File> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            indexFile(queue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void indexFile(File take) {
        System.out.println(take.getName()+"indexing...");
    }

    public static void main(String[] args) {
        startIndexing(new File[]{new File("C:\\Users\\hechen\\Desktop\\20220815")});
    }

    public static void startIndexing(File[] roots){
        LinkedBlockingQueue<File> queue = new LinkedBlockingQueue<>(100);
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return true;
            }
        };

        for (File root : roots) {
            new Thread(new FileCrawler(queue,filter,root)).start();
        }

        final int N_CONSUMERS = 100;
        for (int i = 0; i < N_CONSUMERS; i++) {
            new Thread(new Indexer(queue)).start();
        }
    }
}
