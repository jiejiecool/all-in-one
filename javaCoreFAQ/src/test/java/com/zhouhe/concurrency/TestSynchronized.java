package com.zhouhe.concurrency;

import org.junit.jupiter.api.Test;

public class TestSynchronized {
    /**
     * synchronized可重入锁
     */
    @Test
    public void testReentrant() {
        /**
         * com.zhouhe.concurrency.LoggingWidget object internals:
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x000072b786912d68 (thin lock: 0x000072b786912d68)
         *   8   4        (object header: class)    0x02130908
         *  12   4        (object alignment gap)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         *
         * level 0
         * com.zhouhe.concurrency.LoggingWidget object internals:
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x000072b786912d68 (thin lock: 0x000072b786912d68)
         *   8   4        (object header: class)    0x02130908
         *  12   4        (object alignment gap)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
        LoggingWidget loggingWidget = new LoggingWidget();
        loggingWidget.doSomething();
    }
}
