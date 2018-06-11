/*
 * @(#)SaverThread.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Balking_4;

import java.io.IOException;

/**
 * 执行自动保存的线程
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午3:29:06 $
 */
public class SaverThread extends Thread {

    private final Data data;

    public SaverThread(String threadName, Data data) {
        super(threadName);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save(); // 每隔一秒，要求自动保存数据
                Thread.sleep(1000);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
