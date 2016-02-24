package com.hcse.lib.util;

import java.io.File;
import java.util.ArrayList;

public class XXFile {
    static String generateFileName(String mi, ArrayList<Integer> segment) {
        StringBuilder sb = new StringBuilder();

        String md5Lite = Encoder.digestMd5Lite(mi);

        for (int i = 0; i < segment.size() - 1; i++) {
            sb.append(md5Lite.substring(segment.get(i), segment.get(i + 1)));
            sb.append(File.separator);
        }

        sb.append(md5Lite);
        sb.append(".XX");

        return sb.toString();
    }
}
