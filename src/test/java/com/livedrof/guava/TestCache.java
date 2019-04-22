package com.livedrof.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.joda.time.DateTime;
import org.junit.Test;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCache {
    @Test
    public void tt() throws ExecutionException {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, Object>() {

            @Override
            public Object load(String key) throws Exception {
                System.out.println("loading key:" + key);
                return 100;
            }
        });

        System.out.println(cache.getIfPresent("hello"));
        cache.invalidate("hess");

//        cache.put("world",null);
//        cache.put("world",null);
//        CacheBuilder.from()
    }


    @Test
    public void test() {
        String key = "hello";
        String[] ww = new String[]{"world", "sd", "hello", "string"};
        System.out.println(Arrays.binarySearch(ww, key));
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void tests() {
        String ss = "{XLHDB8WIFF001,XLHDB8WIFF002,XLHDB8WIFF003,XLHDB8WIFF004,XLHDDTMIFF001,XLHDDTOIFF001,XPMDB8HIFF005,XPMDB8HIFF006,XPMDB8HIFF007,XPMDB8HIFF008,XPMDB8HIFF001,XPMDB8HIFF002,XPMDB8HIFF003,XPMDB8HIFF004,XPMD89HIFF001,XPMD89HIFF002,XPMD89HIFF003,XPMD89IIFF001,XPMD89IIFF002,XPMD89IIFF003,XPMD89IIFF004,XPMD89IIFF005,XPMD89IIFF006,XLHDB90IFF001,XLHDB90IFF002,XLHDB90IFF003,XLHDBB4IFF001,XK5D5PRIFF001,XK5DB8SIFF001,XK5D2NTIFF001,XRKD5PFIFF001,XRKD5PFIFF002,XRKD5PFIFF003,XK5D2NUIFF001,XK5D2NUIFF002,XK5D5PUIFF001,XK5D5POIFF001,XK5D5PNIFF001,XK5DB95IFF001,XK5D1QRIFF001,XB2D1RLIFF001,XB2D1RLIFF002,XB2D1RLIFF003,XB2D1RLIFF004,XB2D1RLIFF005,XB2D1RLIFF006,XLHD5QFIFF003,XLHD5QFIFF002,XLHD5QFIFF001,XLHD5QFIFF004,XLHD5QFIFF005,XLHD5QFIFF006}";
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(ss);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void testContains() {
        Set<Long> set = new HashSet<>();
        System.out.println(new Date().getTime()- 1000*60*60*24*6);
        System.out.println(new Date().getTime());
    }

    @Test
    public void testddd() {
        LoadingCache<Long, Map<Long, Coupon>> couponCache = CacheBuilder.newBuilder()
                .concurrencyLevel(2560)
                .maximumSize(20 * 10000)
                .expireAfterWrite(300, TimeUnit.HOURS)
                .build(new CacheLoader<Long, Map<Long, Coupon>>() {
                    @Override
                    public Map<Long, Coupon> load(Long userId) throws Exception {
                        //TODO 待确认
                        return null;
                    }
                });

        Map<Long, Coupon> maps = new HashMap<>();
        Coupon coupon = Coupon.builder()
                .name("test2")
                .userId(2L)
                .couponId(300L)
                .age(30)
                .build();
        maps.put(coupon.getCouponId(), coupon);
        coupon = Coupon.builder()
                .name("test3")
                .userId(2L)
                .couponId(310L)
                .age(30)
                .build();
        maps.put(coupon.getCouponId(), coupon);
        couponCache.put(2L,maps);
        Map<Long, Coupon> otherMaps = couponCache.getIfPresent(2L);
        otherMaps.put(null, null);
        otherMaps.putAll(getOtherCoupons());
    }

    public Map<Long, Coupon> getOtherCoupons() {
        Map<Long, Coupon> maps = new HashMap<>();
        Coupon coupon = Coupon.builder()
                .name("test2")
                .userId(2L)
                .couponId(301L)
                .age(30)
                .build();
        maps.put(coupon.getCouponId(), coupon);
        coupon = Coupon.builder()
                .name("test3")
                .userId(2L)
                .couponId(311L)
                .age(30)
                .build();
        maps.put(coupon.getCouponId(), coupon);
        return maps;
    }


    @Test
    public void addToLocalCache() {
        System.out.println("中国".length());
        System.out.println("中国2".getBytes().length);
        Date date = new Date();
        date.setTime(1884485520000L);
        System.out.println(date);
        DateTime now = new DateTime();
        DateTime today = now.withMillisOfDay(0);
        DateTime beforeToday = today.minusDays(4);
        DateTime yesterday = today.minusDays(1);
        DateTime tomorrow = today.plusDays(1);
//        System.out.println(tomorrow);
    }

    @Test
    public void testSort() {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(50);
        list.add(120);
        list.add(90);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(list);
    }

    @Test
    public void tts() {
        this.testNotNull("900");
        this.testNotNull(null);
    }

    public void testNotNull(@Nonnull String kk) {
        System.out.println("hello " + kk);
    }

    public void addToRedisCache() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(0,3);
//        executor.execute();
    }

    public void UpdateRedisCache() {


    }

    @Test
    public void test33()  {
        String fileFullPathName = "/Users/congsl/data/video/2018/12/19/18/51/sbc_fa163eede45aICJI3XOLLOVF0HU_origin.mp4";
        File ff = new File(fileFullPathName);
        System.out.println(ff.length());;
        File dirFile = new File("/Users/congsl/data/video/2018/12/19/18/51/");
        if(!dirFile.exists()) {
            System.out.println(System.currentTimeMillis());
            synchronized ("Hello") {
                dirFile.mkdirs();
            }
            System.out.println(System.currentTimeMillis());
        }
        try {
            new BufferedOutputStream(new FileOutputStream(new File(fileFullPathName)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
