package com.zhouhe.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class MyThreadSafeCounter {
    private AtomicLong count = new AtomicLong(0);

    public long getCount() {
        return count.get();
    }

    public void call() {
        count.incrementAndGet();
    }
}
