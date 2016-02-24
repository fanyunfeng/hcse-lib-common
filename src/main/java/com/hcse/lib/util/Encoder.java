package com.hcse.lib.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encoder {

    static char[] charMap = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public static String digestMd5Lite(String content) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            digest.update(content.getBytes());

            int hight, low;
            byte[] buf = digest.digest();

            StringBuilder sb = new StringBuilder(32);
            for (int i = 7; i >= 0; i--) {

                hight = buf[i] & 0xF0;
                hight >>>= 4;
                low = buf[i] & 0x0F;

                sb.append(charMap[hight]);
                sb.append(charMap[low]);
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {

            return null;
        }
    }
}
