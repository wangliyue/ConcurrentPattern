/*
 * @(#)Main.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Producer_Consumer_5;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午4:43:22 $
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Table table = new Table(3); // 创建一个能放置3个蛋糕的桌子
        new MarkerThread("MakerThread-1", table, 12344).start();
        new MarkerThread("MakerThread-2", table, 52044).start();
        new MarkerThread("MakerThread-3", table, 32344).start();
        new EaterThread("EaterThread-1", table, 10030).start();
        new EaterThread("EaterThread-2", table, 20030).start();
        new EaterThread("EaterThread-3", table, 33030).start();
    }
}
