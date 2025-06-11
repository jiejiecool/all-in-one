package com.zhouhe.concurrency;

import org.openjdk.jol.info.ClassLayout;


public class LoggingWidget extends Widget{
    @Override
    public synchronized void doSomething() {
        System.out.println("level 1");
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
        super.doSomething();
    }
}
