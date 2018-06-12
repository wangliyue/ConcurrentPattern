/*
 * @(#)ReadWriteLock.java    Created on 2018年6月12日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ReadWriteLock_6;

/**
 * 提供了用于读取的锁和用于写入的锁的类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月12日 下午2:35:58 $
 */
public class ReadWriteLock {

    private int readingReaders = 0; // 正在读取中的线程个数

    private int waitingWriters = 0; // 等待写入的线程个数

    private int writingWriters = 0; // 正在写入的线程个数 （值只能是0或1）

    private boolean preferWriter = true; // 若写入优先，则为true

    /**
     * 获取读取的锁
     *
     * @throws InterruptedException
     *
     */
    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;
    }

    /**
     * 释放读取的锁
     */
    public synchronized void readUnlock() {
        readingReaders--;
        preferWriter = true;
        notifyAll();
    }

    /**
     * 获取写入的锁
     *
     * @throws InterruptedException
     */
    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        }
        finally {
            waitingWriters--;
        }
        writingWriters++;
    }

    /**
     * 释放写入的锁
     */
    public synchronized void writeUnlock() {
        writingWriters--;
        preferWriter = false;
        notifyAll();
    }

}
