/*
 * @(#)ServerThread.java    Created on 2018年5月30日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package GuardedSuspension_3;

import java.util.Random;

/**
 * 服务器处理请求线程
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月30日 上午11:04:10 $
 */
public class ServerThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request request = queue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try {
                Thread.sleep(random.nextInt(3000));
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}
