/*
 * @(#)Main.java    Created on 2018年7月13日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadSpecificStorage_11;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年7月13日 下午2:25:06 $
 */
public class Main {

    public static void main(String[] args) {
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
