package com.livedrof.j2se.jdk8.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @since 1.8
 */
public class CollectionStream {
    @Test
    public void test() {
        List list = Lists.newArrayList(1, null, 2, 3, 4, 5, 6,4,3, 7);
        Stream stream = list.stream().filter(team -> team != null).distinct();
        System.out.println(stream.collect(Collectors.toList()));
    }
}
