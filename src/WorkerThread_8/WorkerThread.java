/*
 * @(#)WorkerThread.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package WorkerThread_8;

/**
 * 工人线程用户获取请求，并处理
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午4:53:54 $
 */
public class WorkerThread extends Thread {

    private final Channel channel;

    /**
     * @param string
     * @param channel
     */
    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true) {
            Request request = channel.takeRequest();
            request.execute();
        }
    }
}
