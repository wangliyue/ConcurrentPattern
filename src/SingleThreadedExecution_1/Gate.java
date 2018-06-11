/*
 * @(#)Gate.java    Created on 2018年5月27日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package SingleThreadedExecution_1;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月27日 下午2:55:01 $
 */
public class Gate {

    private int counter = 0; // 记录通过门的人次

    private String name; // 当前通过门的人名

    private String address; // 当前通过门的人的地址

    /**
     * 人通过门 (此处的counter字段，name字段，address字段为共享资源sharedResource.对于共享资源的操作，需要加锁)
     *
     * @param name
     * @param address
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

    /**
     * 检验当前对象状态是否一致
     */
    private void check() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("No." + this.counter + "=============对象状态不一致=============name：" + this.name
                    + "================address:" + this.address + "=====================");
        }
    }
}
