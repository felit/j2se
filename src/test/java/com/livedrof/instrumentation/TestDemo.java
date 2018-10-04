package com.livedrof.instrumentation;


import org.testng.annotations.Test;
import org.testng.collections.Lists;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestDemo {
    @Test
    public void test() {
        this.dd();
    }

    @Nonnull
    private String dd() {
        return null;
    }
}
