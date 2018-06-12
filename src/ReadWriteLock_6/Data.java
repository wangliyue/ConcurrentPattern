/*
 * @(#)Data.java    Created on 2018年6月12日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ReadWriteLock_6;

/**
 * 可以读取（Read）和写入（Write）的类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月12日 下午2:33:41 $
 */
public class Data {

    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            this.buffer[i] = '*';
        }
    }

    /**
     * 读取 （借助ReadWriteLock来实现 读写互斥，读读不互斥）
     *
     * @return
     * @throws InterruptedException
     */
    public char[] read() throws InterruptedException {
        lock.readLock();
        try {
            return doRead();
        }
        finally { // 保持获取的锁，一定释放掉
            lock.readUnlock();
        }
    }

    /**
     * 写入 （借助ReadWriteLock来实现 读写互斥，读读不互斥）
     *
     * @param c
     * @return
     * @throws InterruptedException
     */
    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            doWrite(c);
        }
        finally {
            lock.writeUnlock();
        }
    }

    /**
     * 实际的读取方法
     *
     * @return
     * @throws InterruptedException
     */
    private char[] doRead() {
        char[] newBuffer = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        try {
            Thread.sleep(50); // 模拟一个耗时操作
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return newBuffer;
    }

    /**
     * 实际的写入操作
     *
     * @param c
     */
    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(50); // 模拟一个耗时操作
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
