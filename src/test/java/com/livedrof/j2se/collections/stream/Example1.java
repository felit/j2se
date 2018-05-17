package com.livedrof.j2se.collections.stream;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {
    @Test
    public void test() {
        User user = new User();
        user.setId(1);
        user.setUsername("user1");
        user.setAge(20);
        List<User> users = new LinkedList<>();
        users.add(user);
        List<String> usernames = users.stream().filter(u -> u.age < 10).map(u -> u.getUsername()).collect(Collectors.toList());
        System.out.println(usernames);


    }


    static class User {
        private int id;
        private String username;
        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
