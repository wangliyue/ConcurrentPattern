/*
 * @(#)EaterThread.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Producer_Consumer_5;

import java.util.Random;

/**
 * 消费者消费蛋糕
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午4:42:56 $
 */
public class EaterThread extends Thread {

    private Random random;

    private Table table;

    public EaterThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String cake = table.take();
                Thread.sleep(random.nextInt(1000)); // 模拟吃蛋糕的时间
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
