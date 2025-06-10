package com.zhouhe.concurrency;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestAtomicLong {
    private final int threadCount = 2000;
    private ExecutorService executor;
    private CountDownLatch countDownLatch;
    private MyThreadSafeCounter threadSafeCounter;
    private MyUnThreadSafeCounter unThreadSafeCounter;

    @BeforeEach
    public void set() {
        executor = Executors.newFixedThreadPool(threadCount);
        countDownLatch = new CountDownLatch(threadCount);
        threadSafeCounter = new MyThreadSafeCounter();
        unThreadSafeCounter = new MyUnThreadSafeCounter();
    }
    @Test
    public void testThreadSafe() throws InterruptedException {
        for (int i = 0; i < threadCount; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                threadSafeCounter.call();
                unThreadSafeCounter.call();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();

        //assert threadSafeCounter.getCount() == threadCount;
        System.out.println(threadSafeCounter.getCount());
        System.out.println(unThreadSafeCounter.getCount());
    }
}
