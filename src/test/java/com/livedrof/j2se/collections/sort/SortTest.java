package com.livedrof.j2se.collections.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SortTest {
    private List<User> users;

    @Before
    public void init() {
        users = new LinkedList<>();

    }

    @Test
    public void test() {
        Date now = new Date();
        users.add(new User(1, "hello", new Date()));
        users.add(new User(1, "hello", now));
        users.add(new User(1, "hello", now));
        users.add(new User(1, "9", now));
        users.add(new User(1, "hello", now));
        users.add(new User(2, "3", new Date()));
        List<User> us = users.stream().sorted(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.getId() != o2.getId()) {
                    System.out.println("" + o2.getId() + ":" + (o2.getId() - o1.getId()));
                    return new Long(o2.getId() - o1.getId()).intValue();
                } else if (o1.getName().equals("hello") && !o2.equals("hello")) {
                    return -1;
                } else if (!o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return 1;
                }
            }
        }).collect(Collectors.toList());

        us.add(new User(2, "3", new Date()));
        System.out.println(us);
    }
}
