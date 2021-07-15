package com.jachs.commons.lang.randomstringutils;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class Demo {
    @Test
    public void testIsEmpty () {
        /**
         * count 创建一个随机字符串，其长度是指定的字符数,字符将从参数的字母数字字符集中选择，如参数所示。
         * letters true,生成的字符串可以包括字母字符
         * numbers true,生成的字符串可以包含数字字符
         */
        System.out.println(RandomStringUtils.random(15, true, false));
        /**
         * 创建一个随机字符串，其长度是指定的字符数。
         * 将从所有字符集中选择字符
         */
        System.out.println(RandomStringUtils.random(22));
        /**
         * 创建一个随机字符串，其长度是指定的字符数。
         * 字符将从字符串指定的字符集中选择，不能为空。如果NULL，则使用所有字符集。
         */
        System.out.println(RandomStringUtils.random(15, "abcdefgABCDEFG123456789"));
        /**
         * 创建一个随机字符串，其长度是指定的字符数,字符将从参数的字母数字字符集中选择，如参数所示。
         * count:计算创建的随机字符长度
         * start:字符集在开始时的位置
         * end:字符集在结束前的位置，必须大于65
         * letters true,生成的字符串可以包括字母字符
         * numbers true,生成的字符串可以包含数字字符
         * 
         */
        System.out.println(RandomStringUtils.random(1009, 5, 129, true, true));
        /**
         * 产生一个长度为指定的随机字符串的字符数，字符将从拉丁字母（a-z、A-Z的选择）。
         * count:创建随机字符串的长度
         */
        System.out.println(RandomStringUtils.randomAlphabetic(15));
        /**
         * 创建一个随机字符串，其长度是指定的字符数，字符将从拉丁字母（a-z、A-Z）和数字0-9中选择。
         * count ：创建的随机数长度
         */
        System.out.println(RandomStringUtils.randomAlphanumeric(15));
        //生成汉字的方法，参考：utf-8汉字的编码范围
        System.out.println ( RandomStringUtils.random(20, 0x4e00, 0x9fa5, false,false) );
    }
}
