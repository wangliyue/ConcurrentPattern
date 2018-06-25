/*
 * @(#)ClientThread.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package WorkerThread_8;

import java.util.Random;

/**
 * 客户线程用户产生请求
 * 
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午4:53:28 $
 */
public class ClientThread extends Thread {

    private final Channel channel;

    private static final Random random = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putReqeust(request);
                Thread.sleep(random.nextInt(1000));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
