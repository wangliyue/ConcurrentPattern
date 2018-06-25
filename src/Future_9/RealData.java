/*
 * @(#)RealData.java    Created on 2018年6月25日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Future_9;

/**
 * 实际数据对象类
 * 
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月25日 下午3:21:16 $
 */
public class RealData implements Data {

    private final String content;

    public RealData(int count, char c) {
        System.out.println("=============make RealData(" + count + "," + c + ") begin=============");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.content = new String(buffer);
        System.out.println("=============make RealData(" + count + "," + c + ") end=============");
    }

    @Override
    public String getContent() {
        return content;
    }

}
