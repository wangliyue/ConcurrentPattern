/*
 * @(#)Person.java    Created on 2018年5月28日
 * Copyright (c) 2018 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package Immutable_2;

/**
 * Person类为不可变类
 *
 * @author wangly
 * @version $Revision: 1.0 $, $Date: 2018年5月28日 下午2:46:09 $
 */
public final class Person {

    private final String name;

    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "[name=" + name + ",address=" + address + "]";
    }
}
