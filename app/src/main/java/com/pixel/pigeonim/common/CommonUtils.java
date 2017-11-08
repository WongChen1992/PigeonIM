package com.pixel.pigeonim.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wongchen on 2017/11/8.
 */

public class CommonUtils {
    public static boolean isMobileNum(String number) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
