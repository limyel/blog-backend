package com.limyel.blog.utils;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * 生成 slug
 */
public class SlugUtil {

    public static String generate(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (char c: s.toCharArray()) {
            if ((int) c <= 128) {
                stringBuilder.append(String.valueOf(c).strip());
                flag = false;
                continue;
            }
            if (!flag) {
                stringBuilder.append("-");
                flag = true;
            }
            try {
                stringBuilder.append(PinyinHelper.convertToPinyinString(String.valueOf(c), "", PinyinFormat.WITHOUT_TONE));
            } catch (PinyinException e) {
                e.printStackTrace();
            }
            if (c != s.charAt(s.length()-1)) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

}
