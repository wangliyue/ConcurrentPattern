/*
 * @(#)WriterThread.java    Created on 2018年6月12日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ReadWriteLock_6;

import java.util.Random;

/**
 * 写操作的线程
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月12日 下午3:22:39 $
 */
public class WriterThread extends Thread {

    private static final Random random = new Random();

    private final Data data;

    private final String fillStr;

    private char c;

    private int index;

    public WriterThread(Data data, String fillStr) {
        this.data = data;
        this.fillStr = fillStr;
    }

    @Override
    public void run() {
        try {
            while (true) {
                c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        }
        catch (InterruptedException e) {

        }
    }

    /**
     * 获取要写入的字符
     *
     * @return
     */
    private char nextChar() {
        char c = fillStr.charAt(index);
        index++;
        if (index >= fillStr.length()) {
            index = 0;
        }
        return c;
    }
}
