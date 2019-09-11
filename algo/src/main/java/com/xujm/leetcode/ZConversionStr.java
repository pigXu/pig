package com.xujm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形转换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * @author xujm
 * @date 2019/09/11
 */
public class ZConversionStr {
    public static void main(String[] args) {
        System.out.println("LCIRETOESIIGEDHN".equals(convert("LEETCODEISHIRING", 3)));
        System.out.println("LDREOEIIECIHNTSG".equals(convert("LEETCODEISHIRING", 4)));
    }

    /**
     * 时间复杂度O(n）
     * 空间复杂度O(n)
     */
    public static String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder(s.length()));
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ) {
            //n
            for (int j = 0; j < numRows && i < chars.length; j++, i++) {
                rows.get(j).append(chars[i]);
            }
            // n-2
            for (int j = numRows - 2; j > 0 && i < chars.length; j--, i++) {
                rows.get(j).append(chars[i]);
            }
        }

        StringBuilder sb = new StringBuilder(s.length());
        for (StringBuilder row : rows) {
            sb.append(row);
        }

        return sb.toString();
    }


}
