/*
 * @(#)TsLog.java    Created on 2018年7月13日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadSpecificStorage_11;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年7月13日 下午2:07:46 $
 */
public class TSLog {

    private PrintWriter writer;

    /**
     * 初始化writer
     *
     * @param fileName
     */
    public TSLog(String fileName) {
        try {
            writer = new PrintWriter(fileName);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写日志
     *
     * @param s
     */
    public void println(String s) {
        writer.println(s);
    }

    /**
     * 关闭日志
     */
    public void close() {
        writer.println("====End of log====");
        writer.close();
    }
}
