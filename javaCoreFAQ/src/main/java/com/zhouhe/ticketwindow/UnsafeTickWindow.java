package com.zhouhe.ticketwindow;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟叫号程序，一共500个号，4个发号器，要求递增不重复
 */
@Slf4j
public class UnsafeTickWindow implements Runnable{
    private static int MAX_NUM = 500;
    private static int index = 1;

    @Override
    public void run() {
        while (index <= MAX_NUM) {
            log.info("current index:{}",index++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new UnsafeTickWindow());
        Thread thread1 = new Thread(new UnsafeTickWindow());
        Thread thread2 = new Thread(new UnsafeTickWindow());
        Thread thread3 = new Thread(new UnsafeTickWindow());

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();

    }
}
