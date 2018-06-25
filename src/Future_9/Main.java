/*
 * @(#)Main.java    Created on 2018年6月25日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Future_9;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月25日 下午3:20:26 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("================main begin=================");
        Host host = new Host();
        Data futureData1 = host.request(10, 'A');
        Data futureData2 = host.request(20, 'B');
        Data futureData3 = host.request(30, 'C');

        System.out.println("===============main other job begin============");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("===============main other job end============");

        System.out.println("data1=" + futureData1.getContent());
        System.out.println("data2=" + futureData2.getContent());
        System.out.println("data3=" + futureData3.getContent());
        System.out.println("================main end=================");
    }

}
