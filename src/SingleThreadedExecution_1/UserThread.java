/*
 * @(#)UserThread.java    Created on 2018年5月27日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package SingleThreadedExecution_1;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月27日 下午3:03:42 $
 */
public class UserThread extends Thread {

    private final Gate gate;

    private final String name;

    private final String address;

    public UserThread(Gate gate, String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(name + "-----------Begin");
        while (true) { // 人不断的通过指定的门
            gate.pass(name, address);
        }
    }
}
