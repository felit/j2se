package com.livedrof.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

public class TestCache {
    @Test
    public void tt() throws ExecutionException {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {

            @Override
            public Object load(String key) throws Exception {
                return 900;
            }
        });

        System.out.println(cache.get("hello"));
    }
}
