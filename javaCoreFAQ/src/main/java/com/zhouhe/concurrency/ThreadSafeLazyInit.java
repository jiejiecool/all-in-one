package com.zhouhe.concurrency;

public class ThreadSafeLazyInit {
    private static volatile MyDataSource dataSource;

    public static MyDataSource getInstance() {
        if (dataSource == null) {
            synchronized (MyDataSource.class) {
                if (dataSource == null) {
                    dataSource = new MyDataSource();
                }
            }
        }

        return dataSource;
    }
}
