/*
 * @(#)ReaderThread.java    Created on 2018年6月12日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ReadWriteLock_6;

/**
 * 读操作的线程
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月12日 下午3:22:26 $
 */
public class ReaderThread extends Thread {

    private Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] chars = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(chars));
            }
        }
        catch (InterruptedException e) {

        }
    }
}
