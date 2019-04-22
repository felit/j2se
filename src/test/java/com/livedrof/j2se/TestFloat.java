package com.livedrof.j2se;

import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class TestFloat {
    @Test
    public void test() throws NoSuchAlgorithmException {
        StringBuffer uniqueCode = new StringBuffer();
        uniqueCode.append("1024");
        uniqueCode.append("null");
        uniqueCode.append("1");
        uniqueCode.append("43-345");

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(uniqueCode.toString().getBytes());
        System.out.println(new BigInteger(1, messageDigest.digest()).toString(16));
    }


    @Test
    public void tet() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 9, 13, 0, 0);
        Date data = calendar.getTime();
        System.out.println(data);
        System.out.println(data.getTime());
        System.out.println(Math.random());
    }

    @Test
    public void testRollback() {

        for (int[] row : data) {
            System.out.println(Long.valueOf("" + row[1]).hashCode());
            System.out.println("update t_account_log_" + Long.valueOf("" + row[1]).hashCode() % 256 + " set shop_id =" + row[2] + " where id  = " + row[0] + "; ");
        }
    }


    private static int[][] data = {{3922805, 36000183, 221576},
            {3922805, 36000185, 221576},
            {3922805, 36000187, 221576},
            {3922805, 36000190, 221576},
            {3922805, 36000195, 221576},
            {3662, 36000134, 2562},
            {3662, 36000137, 2562},
            {3662, 36000148, 2562},
            {3662, 36000179, 2562},
            {3662, 36000181, 2562},
            {3513970, 36000208, 488102},
            {3513970, 36000214, 488102},
            {3513970, 36000216, 488102},
            {3513970, 36000218, 488102},
            {3513970, 36000238, 488102},
            {3513970, 36000264, 488102},
            {3513970, 36000265, 488102},
            {3513970, 36000267, 488102},
            {3513970, 36000361, 488102},
            {3513970, 36000365, 488102},
            {3513970, 36000400, 488102},
            {3513970, 36000402, 488102},
            {3513970, 36000421, 488102},
            {3513970, 36000516, 488102},
            {3513970, 36000518, 488102},
            {3513970, 36000524, 488102},
            {7216149, 36000376, 488123},
            {7216160, 36000081, 488127},
            {7216160, 36000313, 488127},
            {7216160, 36000439, 488127},
            {7216160, 36000441, 488127},
            {7216160, 36000482, 488127},
            {2217197, 36000086, 133862},
            {2217197, 36000141, 133862},
            {2217197, 36000143, 133862},
            {2217197, 36000145, 133862},
            {2217197, 36000159, 133862},
            {2217197, 36000161, 133862},
            {2217197, 36000168, 133862},
            {7216350, 36000690, 488199},
            {7216350, 36000694, 488199},
            {7216350, 36000698, 488199},
            {7216350, 36000702, 488199},
            {7216350, 36000706, 488199},
            {227558, 36000093, 488211},
            {7216522, 36000529, 488218},
            {7216522, 36000538, 488218},
            {7216522, 36000558, 488218},
            {7216522, 36000562, 488218},
            {7216522, 36000564, 488218},
            {7216522, 36000615, 488218},
            {7216522, 36000618, 488218},
            {7216534, 36000480, 488224},
            {7216534, 36000484, 488224},
            {7216534, 36000521, 488224},
            {7216523, 36000416, 488219},
            {7216523, 36000419, 488219},
            {7216682, 36000650, 488238},
            {7216682, 36000654, 488238}};

}