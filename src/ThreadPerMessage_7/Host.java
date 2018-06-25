/*
 * @(#)Host.java    Created on 2018年6月23日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadPerMessage_7;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月23日 下午1:58:40 $
 */
public class Host {

    private static final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("=========request(" + count + "," + c + ") begin================");
        new Thread() {
            @Override
            public void run() {
                helper.handle(count, c);
            };
        }.start();
        System.out.println("=========request(" + count + "," + c + ") end================");
    }
}
