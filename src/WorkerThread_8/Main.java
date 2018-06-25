/*
 * @(#)Main.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package WorkerThread_8;

/**
 * 工人模式 （类似生产者消费者模式）
 * 
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午4:47:34 $
 */
public class Main {

    public static void main(String[] args) {
        Channel channel = new Channel(5); // 持有5个工人线程
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobe", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
