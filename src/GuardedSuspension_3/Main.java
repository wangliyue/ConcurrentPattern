/*
 * @(#)Main.java    Created on 2018年5月30日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package GuardedSuspension_3;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月30日 上午11:05:41 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        RequestQueue queue = new RequestQueue();

        new ClientThread(queue).start();
        new ServerThread(queue).start();
    }

}
