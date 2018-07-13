/*
 * @(#)CountupThread.java    Created on 2018年6月27日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package TwoPhaseTermination_10;

/**
 * 计数器线程 （收到终止请求后，先调用终止处理的方法，然后终止）
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月27日 下午2:47:18 $
 */
public class CountupThread extends Thread {

    // 计数值
    private long counter = 0;

    // 发出终止请求后变为true
    private volatile boolean shutDownReqeusted = false;

    // 终止请求
    public void shutDownRequest() {
        shutDownReqeusted = true;
        interrupt(); // 确保线程在sleep或wait状态下也会被终结
    }

    // 检查是否发出了终止请求
    public boolean isShutDownRequested() {
        return shutDownReqeusted;
    }

    @Override
    public void run() {
        try {
            while (!isShutDownRequested()) {
                doWork();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            doShutDown();
        }
    }

    // 操作
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork:counter = " + counter);
        Thread.sleep(500);
    }

    // 终止处理
    private void doShutDown() {
        System.out.println("doShutDown:counter = " + counter);
    }

}
