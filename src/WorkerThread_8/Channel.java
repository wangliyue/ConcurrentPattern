/*
 * @(#)Channle.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package WorkerThread_8;

/**
 * 负责传递工作请求已经保存工人线程的类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午4:53:01 $
 */
public class Channel {

    private static final int MAX_REQUEST = 100;

    private final Request[] requestQueue;

    private int tail; // 下次putRequest的位置

    private int head; // 下次takeRequest的位置

    private int count; // request的数量

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.tail = 0;
        this.head = 0;
        this.count = 0;

        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    /**
     * 启动处理请求的Worker线程
     */
    public void startWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    /**
     * 投送请求
     *
     * @param request
     */
    public synchronized void putReqeust(Request request) {
        while (count >= requestQueue.length) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    /**
     * 获取请求
     *
     * @return
     */
    public synchronized Request takeRequest() {
        while (count <= 0) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
