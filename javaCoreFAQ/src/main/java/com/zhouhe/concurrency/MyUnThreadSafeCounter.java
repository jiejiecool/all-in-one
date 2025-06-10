package com.zhouhe.concurrency;

import java.util.concurrent.atomic.AtomicLong;

public class MyUnThreadSafeCounter {
    private long count = 0;

    public long getCount() {
        return count;
    }

    public void call() {
        count+=1;
    }
}
