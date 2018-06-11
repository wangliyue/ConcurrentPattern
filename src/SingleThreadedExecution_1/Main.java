/*
 * @(#)Main.java    Created on 2018年5月27日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package SingleThreadedExecution_1;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月27日 下午3:03:21 $
 */
public class Main {

    /**
     * 三个人不断的通过一道门
     * 
     * @param args
     */
    public static void main(String[] args) {
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Amercian").start();
        new UserThread(gate, "Boba", "Braile").start();
        new UserThread(gate, "Carter", "Candan").start();

    }

}
