package com.zhouhe.ticketwindow;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟叫号程序，一共500个号，4个发号器，要求递增不重复
 */
@Slf4j
public class UnsafeTickWindow implements Runnable{
    private int index = 1;
    private final static int MAX = 500;
    private final static Object MUTEX = new Object();
    @Override
    public void run()
    {
        synchronized (MUTEX)
        {
            while (index <= MAX)
            {
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        final UnsafeTickWindow task = new
                UnsafeTickWindow();
        Thread windowThread1 = new Thread(task, "一号窗口");
        Thread windowThread2 = new Thread(task, "二号窗口");
        Thread windowThread3 = new Thread(task, "三号窗口");
        Thread windowThread4 = new Thread(task, "四号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
        windowThread1.join();
        windowThread2.join();
        windowThread3.join();
        windowThread4.join();
    }
}
