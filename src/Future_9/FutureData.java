/*
 * @(#)FutureData.java    Created on 2018年6月25日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Future_9;

/**
 * 虚拟数据对象类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月25日 下午3:21:00 $
 */
public class FutureData implements Data {

    private RealData realData = null;

    private boolean ready = false;

    public synchronized void setRealData(RealData realData) {
        if (ready) {
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        if (!ready) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getContent();
    }

}
