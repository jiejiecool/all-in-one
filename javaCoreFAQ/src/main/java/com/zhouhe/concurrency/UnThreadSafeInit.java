package com.zhouhe.concurrency;

public class UnThreadSafeInit {
    private static MyDataSource myDataSource;

    public static MyDataSource getInstance() {
        if (myDataSource == null) {
            myDataSource = new MyDataSource();
        }
        return myDataSource;
    }
}
