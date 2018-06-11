/*
 * @(#)Table.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Producer_Consumer_5;

/**
 * 放置蛋糕的桌子
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午4:43:11 $
 */
public class Table {

    private final String[] buffer;
    private int tail; // 下次put的位置
    private int head; // 下次take的位置
    private int count; // buffer中的蛋糕数目

    public Table(int count) {
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
    }

    /**
     * 放置蛋糕
     *
     * @throws InterruptedException
     */
    public synchronized void put(String cake) throws InterruptedException {
        while (count >= buffer.length) {
            wait(); // 当前线程进入等待队列
        }
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        buffer[tail] = cake; // 放置蛋糕
        tail = (tail + 1) % buffer.length; // 设置下次put的位置
        count++; // 蛋糕数量+1
        notifyAll(); // 唤醒所有线程 （目的让消费者线程来取蛋糕）
    }

    /**
     * 拿取蛋糕
     *
     * @return 蛋糕
     * @throws InterruptedException
     */
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait(); // 当前线程进入等待队列
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();// 唤醒所有线程 （目的让生产者者线程来放置蛋糕）
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
