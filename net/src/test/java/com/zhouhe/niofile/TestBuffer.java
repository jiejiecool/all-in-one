package com.zhouhe.niofile;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.CharBuffer;

@Slf4j
public class TestBuffer {
    @Test
    public void test1() {
        //测试limit的作用
        //1. 先定义一个charbuffer
        //2. 设置这个buffer的limit
        //3. 在超过limit的地方put数据

        char[] arr = new char[]{'a','b','c','d','e','f'};
        CharBuffer charBuffer = CharBuffer.wrap(arr);
        log.info("charBuffer.capacity:{}, limit:{}", charBuffer.capacity(), charBuffer.limit());


        charBuffer.limit(3);
        log.info("charBuffer.capacity:{}, limit:{}", charBuffer.capacity(), charBuffer.limit());

        charBuffer.put(0, 'x');
        log.info("charBuffer:{}", charBuffer);

        charBuffer.put(2,'y');
        log.info("charBuffer:{}", charBuffer);

        charBuffer.position(1);
        log.info("charBuffer:{}", charBuffer);

        charBuffer.put('k');
        log.info("charBuffer:{}", charBuffer);

        charBuffer.clear();
        log.info("charBuffer:{}", charBuffer);

    }
}