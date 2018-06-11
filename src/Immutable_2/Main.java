/*
 * @(#)Main.java    Created on 2018年5月28日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Immutable_2;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月28日 下午2:50:16 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Person person = new Person("wangliyue", "HangZhou");
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
        new PrintPersonThread(person).start();
    }

}
