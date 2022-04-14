package com.limyel.blog.utils;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成 slug
 */
public class SlugUtil {

    public static String generate(String s) {
        if (StringUtils.isBlank(s)) {
            // todo 如果为空，完善
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 标记，ascii 字符和汉字交界的地方加上 - 符号
        boolean flag = true;
        for (char c: s.toCharArray()) {
            if ((int) c <= 128) {
                stringBuilder.append(String.valueOf(c).trim());
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
                // 如果不是最后一个字符，结尾加上 - 符号
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString().toLowerCase();
    }

}
