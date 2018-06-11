/*
 * @(#)Data.java    Created on 2018年6月6日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Balking_4;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 当前数据的类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年6月6日 下午3:16:38 $
 */
public class Data {

    private final String fileName; // 保存的文件名称
    private String content; // 数据内容
    private boolean changed; // 数据内容是否发生变化

    public Data(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    /**
     * 修改数据内容
     */
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    /**
     * 保存数据
     *
     * @throws IOException
     */
    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    /**
     * 保存操作
     *
     * @throws IOException
     */
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave , content = " + content);
        Writer writer = new FileWriter(fileName);
        writer.write(content);
        writer.flush();
        writer.close();
    }
}
