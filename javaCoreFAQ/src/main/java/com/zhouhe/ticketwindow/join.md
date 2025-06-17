# Thread join方法

## 典型调用
```java
public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread downloadThread = new Thread(() -> {
            System.out.println("开始下载文件...");
            // 模拟耗时操作
            try { Thread.sleep(3000); } catch (InterruptedException e) {}
            System.out.println("文件下载完成!");
        });

        Thread processThread = new Thread(() -> {
            System.out.println("等待文件下载完成...");
            try {
                downloadThread.join(); // 等待下载线程完成
                System.out.println("开始处理文件...");
                // 文件处理逻辑
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        downloadThread.start();
        processThread.start();
        
        // 主线程等待所有工作完成
        downloadThread.join();
        processThread.join();
        
        System.out.println("所有任务完成!");
    }
}
```

## 原理剖析
总结成一句话:
`线程对象.join = synchronized(线程对象) {线程对象.wait}`

理解下上面这句话，也就是说当前线程(上面的例子就是主线程)会获取线程对象的锁，并且在这个线程对象上等待

那么问题来了，object.wait之后，什么时候才会notify呢？ 源码中没有，但是注释中有，如下
```java
    /**
     * Waits at most {@code millis} milliseconds plus
     * {@code nanos} nanoseconds for this thread to terminate.
     * If both arguments are {@code 0}, it means to wait forever.
     * This method returns immediately, without waiting, if the thread has not
     * been {@link #start() started}.
     *
     * @implNote
     * For platform threads, the implementation uses a loop of {@code this.wait}
     * calls conditioned on {@code this.isAlive}. As a thread terminates the
     * {@code this.notifyAll} method is invoked. It is recommended that
     * applications not use {@code wait}, {@code notify}, or
     * {@code notifyAll} on {@code Thread} instances.
     *
     * @param  millis
     *         the time to wait in milliseconds
     *
     * @param  nanos
     *         {@code 0-999999} additional nanoseconds to wait
     *
     * @throws  IllegalArgumentException
     *          if the value of {@code millis} is negative, or the value
     *          of {@code nanos} is not in the range {@code 0-999999}
     *
     * @throws  InterruptedException
     *          if any thread has interrupted the current thread. The
     *          <i>interrupted status</i> of the current thread is
     *          cleared when this exception is thrown.
     */
    public final void join(long millis, int nanos) throws InterruptedException {
```

`downloadThread.join();` 代表着main线程等到下载线程结束后才会结束当前线程



下面是jdk源码

```java
        synchronized (this) {
            if (millis > 0) {
                if (isAlive()) {
                    final long startTime = System.nanoTime();
                    long delay = millis;
                    do {
                        wait(delay);
                    } while (isAlive() && (delay = millis -
                             NANOSECONDS.toMillis(System.nanoTime() - startTime)) > 0);
                }
            } else {
                while (isAlive()) {
                    wait(0);
                }
            }
        }
```

