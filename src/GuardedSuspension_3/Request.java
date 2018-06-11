/*
 * @(#)Request.java    Created on 2018年5月30日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package GuardedSuspension_3;

/**
 * 请求
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月30日 上午10:54:11 $
 */
public class Request {

    private final String name;

    public Request(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[Request " + name + "]";
    }
}
