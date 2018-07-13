/*
 * @(#)ClientThread.java    Created on 2018年7月13日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadSpecificStorage_11;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年7月13日 下午2:21:37 $
 */
public class ClientThread extends Thread {

    public ClientThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName() + " BEGIN ");
        for (int i = 0; i < 10; i++) {
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.close();
        System.out.println(getName() + " END ");
    }
}
