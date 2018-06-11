/*
 * @(#)Main.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Balking_4;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午3:41:09 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Data data = new Data("balk_test.txt", "Hello");

        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }

}
