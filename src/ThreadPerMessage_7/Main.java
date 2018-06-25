/*
 * @(#)Main.java    Created on 2018年6月15日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadPerMessage_7;

/**
 * 每一个请求创建一个线程异步去处理，不影响主线程的执行 （服务器处理请求的方式）
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月15日 下午4:30:59 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=========main begin================");
        Host host = new Host();
        host.request(10, 'A');
        host.request(8, 'B');
        host.request(7, 'C');
        System.out.println("=========main end================");
    }

}
