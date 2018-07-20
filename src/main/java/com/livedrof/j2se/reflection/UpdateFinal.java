package com.livedrof.j2se.reflection;

import java.lang.reflect.Field;

public class UpdateFinal {
    public static void main(String args[]) throws NoSuchFieldException, IllegalAccessException {
        Pojo2 p = new Pojo2();
        p.printName();
        Field nameField = p.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(p, new StringBuilder("111"));
        p.printName();

    }
}

class Pojo2 {
    private final StringBuilder name = new StringBuilder("default2");

    public void printName() {
        System.out.println(name);
    }
}