/*
 * @(#)MarkerThread.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Producer_Consumer_5;

import java.util.Random;

/**
 * 生产者线程生产蛋糕
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午4:42:32 $
 */
public class MarkerThread extends Thread {

    private final Random random;

    private Table table;

    private static int id = 0; // 蛋糕的流水号（所有糕点师共用，static类型）

    public MarkerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));// 模拟制作蛋糕的时间
                String cake = "[Cake No." + nextId() + " by " + getName() + "]";
                table.put(cake);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回流水号
     *
     * @return
     */
    private synchronized static int nextId() {
        return id++;
    }
}
