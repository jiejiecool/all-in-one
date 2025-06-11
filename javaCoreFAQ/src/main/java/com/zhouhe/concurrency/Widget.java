package com.zhouhe.concurrency;

import org.openjdk.jol.info.ClassLayout;

public class Widget {
    public synchronized void doSomething() {
        System.out.println("level 0");
        System.out.println(ClassLayout.parseInstance(this).toPrintable());
    }

}
