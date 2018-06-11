/*
 * @(#)ChangeThread.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Balking_4;

import java.io.IOException;
import java.util.Random;

/**
 * 修改数据，然后保存的线程
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午3:30:08 $
 */
public class ChangerThread extends Thread {

    private final Data data;

    private Random random = new Random();

    public ChangerThread(String threadName, Data data) {
        super(threadName);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i); // 改变数据
                Thread.sleep(random.nextInt(1000)); // 模拟执行一些其他操作
                data.save(); // 保存数据
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
