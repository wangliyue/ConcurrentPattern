/*
 * @(#)Request.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package WorkerThread_8;

import java.util.Random;

/**
 * 请求类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午4:52:44 $
 */
public class Request {

    private final String name; // 委托者

    private final int number; // 请求的编号

    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    /**
     * 处理该请求的方法
     */
    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
