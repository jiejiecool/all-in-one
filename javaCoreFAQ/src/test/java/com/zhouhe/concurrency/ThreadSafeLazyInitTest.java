package com.zhouhe.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadSafeLazyInitTest {
    int count = 1000;

    @Test
    public void testConcurrentInit() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(count);
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                MyDataSource instance = ThreadSafeLazyInit.getInstance();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();



    }

    @Test
    public void testConcurrentUnsafeInit() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(count);
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                MyDataSource instance = UnThreadSafeInit.getInstance();
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();



    }
}
