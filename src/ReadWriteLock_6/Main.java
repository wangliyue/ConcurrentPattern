/*
 * @(#)Main.java    Created on 2018年6月11日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ReadWriteLock_6;

/**
 * 读写锁模式 <br/>
 * 要求： <br/>
 * 1.一个线程对指定对象进行读操作时，其他线程不能对该对象进行写操作 （读写互斥） <br/>
 * 2.一个线程对指定对象进行写操作时，其他线程不能对该对象进行读操作 （读写互斥）<br/>
 * 3.一个线程对指定对象进行读操作时，其他线程可以对该对象进行读操作 （读读不互斥）
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月11日 下午5:55:27 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Data data = new Data(10);

        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();
        new ReaderThread(data).start();

        new WriterThread(data, "ABCDEFGHIJKLMN").start();
        new WriterThread(data, "abcdefghijklmn").start();
    }

}
