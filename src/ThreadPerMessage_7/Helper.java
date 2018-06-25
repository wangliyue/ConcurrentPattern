/*
 * @(#)Helper.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadPerMessage_7;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午1:59:43 $
 */
public class Helper {

    /**
     * @param count
     * @param c
     */
    public void handle(int count, char c) {
        System.out.println("=========handle(" + count + "," + c + ") begin================");
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(1000); // 模拟一个耗时操作
                System.out.println(c);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=========handle(" + count + "," + c + ") end================");
    }

}
