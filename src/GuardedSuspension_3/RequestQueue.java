/*
 * @(#)RequestQueue.java    Created on 2018年5月30日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package GuardedSuspension_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请求队列
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月30日 上午10:57:20 $
 */
public class RequestQueue {

    private final Queue<Request> queue = new LinkedList<>();

    /**
     * 从请求队列中获取一个请求
     *
     * @return
     */
    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove();
    }

    /**
     * 向请求队列中放入一个请求
     */
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }
}
