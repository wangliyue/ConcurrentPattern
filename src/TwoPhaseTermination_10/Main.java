/*
 * @(#)Main.java    Created on 2018年6月27日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package TwoPhaseTermination_10;

/**
 * 安全结束线程的执行
 * 
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月27日 下午2:46:50 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main:begin");

        try {
            // 启动计数器线程
            CountupThread t = new CountupThread();
            t.start();

            // 隔一段时间
            Thread.sleep(10000);

            // 线程终止请求
            System.out.println("main:shutDownRequest");
            t.shutDownRequest();

            System.out.println("main:join");
            // 等待线程终结
            t.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
