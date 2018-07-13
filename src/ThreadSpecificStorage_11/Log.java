/*
 * @(#)Log.java    Created on 2018年7月13日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package ThreadSpecificStorage_11;

/**
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年7月13日 下午2:07:34 $
 */
public class Log {

    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    /**
     * 写日志
     */
    public static void println(String s) {
        getTSLog().println(s);
    }

    /**
     * 关闭日志
     */
    public static void close() {
        getTSLog().close();
    }

    /**
     * 获取线程特有的日志
     *
     * @return
     */
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        // 如果该线程时第一次调用本方法，就将新生成并注册一个日志
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }
        return tsLog;
    }
}
