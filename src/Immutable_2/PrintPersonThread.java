/*
 * @(#)PrintPersonThread.java    Created on 2018年5月28日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Immutable_2;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月28日 下午2:50:44 $
 */
public class PrintPersonThread extends Thread {

    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "-------" + person);
        }
    }
}
