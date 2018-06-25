/*
 * @(#)Host.java    Created on 2018年6月25日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Future_9;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月25日 下午3:20:35 $
 */
public class Host {

    public Data request(final int count, final char c) {
        System.out.println("============request(" + count + "," + c + ") begin===============");

        final FutureData futureData = new FutureData(); // 对于客服端委托的请求，先发给客户端一张 提取券

        new Thread(new Runnable() {

            @Override
            public void run() {
                RealData realData = new RealData(count, c); // 生产实际数据对象
                futureData.setRealData(realData); // 关联虚拟数据对象 与 实际数据对象
            }
        }).start();

        System.out.println("============request(" + count + "," + c + ") end===============");
        return futureData;
    }
}
