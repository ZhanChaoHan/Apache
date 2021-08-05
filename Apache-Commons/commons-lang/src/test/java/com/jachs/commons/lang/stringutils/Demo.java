package com.jachs.commons.lang.stringutils;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * @author zhanchaohan
 * 
 */
public class Demo {
    //空
    @Test
    public void testIsEmpty () {
        System.out.println ( StringUtils.isEmpty ( null ) );//true
        System.out.println ( StringUtils.isEmpty ( "" ) );//true
        System.out.println ( StringUtils.isEmpty ( " " ) );//false
        System.out.println ( StringUtils.isEmpty ( "  " ) );//false
        System.out.println ( StringUtils.isEmpty ( " aa " ) );//false
        System.out.println ( StringUtils.isEmpty ( "aa" ) );//false
    }

    //非空
    @Test
    public void testIsNotEmpty () {
        System.out.println ( StringUtils.isNotEmpty ( null ) );//false
        System.out.println ( StringUtils.isNotEmpty ( "" ) );//false
        System.out.println ( StringUtils.isNotEmpty ( " " ) );//true
        System.out.println ( StringUtils.isNotEmpty ( "  " ) );//true
        System.out.println ( StringUtils.isNotEmpty ( " aa " ) );//true
        System.out.println ( StringUtils.isNotEmpty ( "aa" ) );//true
    }

    //判断某字符串是否为空或长度为0或由空白符(whitespace)构成
    @Test
    public void testIsBlank () {
        System.out.println ( StringUtils.isBlank ( null ) );//true
        System.out.println ( StringUtils.isBlank ( "" ) );//true
        System.out.println ( StringUtils.isBlank ( " " ) );//true
        System.out.println ( StringUtils.isBlank ( "        " ) );//true
        System.out.println ( StringUtils.isBlank ( "\t \n \f \r" ) );//true
        System.out.println ( StringUtils.isBlank ( "\b" ) );//false
        System.out.println ( StringUtils.isBlank ( "bob" ) );//false
        System.out.println ( StringUtils.isBlank ( " bob " ) );//false
        System.out.println ( StringUtils.isBlank ( null ) );//true
    }

    //去除二端空格
    @Test
    public void testTrim () {
        System.out.println ( StringUtils.trim ( null ) );//null
        System.out.println ( StringUtils.trim ( "" ) );//""
        System.out.println ( StringUtils.trim ( " " ) );//""
        System.out.println ( StringUtils.trim ( "     \b \t \n \f \r    " ) );//""
        System.out.println ( StringUtils.trim ( "     \n\tss   \b" ) );//ss
        System.out.println ( StringUtils.trim ( " d   d dd     " ) );//d   d dd
        System.out.println ( StringUtils.trim ( "dd     " ) );//dd
        System.out.println ( StringUtils.trim ( "     dd       " ) );//dd
    }

    //去除去掉字符串两端的控制符(control characters, char <= 32)如果变为null或""，则返回null
    @Test
    public void testTrimToNull () {
        System.out.println ( StringUtils.trimToNull ( null ) );//null
        System.out.println ( StringUtils.trimToNull ( "" ) );//null
        System.out.println ( StringUtils.trimToNull ( " " ) );//null
        System.out.println ( StringUtils.trimToNull ( "     \b \t \n \f \r    " ) );//null
        System.out.println ( StringUtils.trimToNull ( "     \n\tss   \b" ) );//ss
        System.out.println ( StringUtils.trimToNull ( " d   d dd     " ) );//d   d dd
        System.out.println ( StringUtils.trimToNull ( "dd     " ) );//dd
        System.out.println ( StringUtils.trimToNull ( "     dd       " ) );//dd
    }

    //去掉字符串两端的控制符(control characters, char <= 32)如果变为null或""，则返回""
    @Test
    public void testTrimToEmpty () {
        System.out.println ( StringUtils.trimToEmpty ( null ) ); // ""
        System.out.println ( StringUtils.trimToEmpty ( "" ) ); //""
        System.out.println ( StringUtils.trimToEmpty ( " " ) ); //""
        System.out.println ( StringUtils.trimToEmpty ( "     \b \t \n \f \r    " ) );//""
        System.out.println ( StringUtils.trimToEmpty ( "     \n\tss   \b" ) ); //ss
        System.out.println ( StringUtils.trimToEmpty ( " d   d dd     " ) ); //d   d dd
        System.out.println ( StringUtils.trimToEmpty ( "dd     " ) ); // dd
        System.out.println ( StringUtils.trimToEmpty ( "     dd       " ) ); //dd
    }

    //去掉字符串两端的空白符(whitespace)，如果输入为null则返回null下面是示例(注意和trim()的区别)：
    @Test
    public void testStrip () {
        System.out.println ( StringUtils.strip ( null ) );//null
        System.out.println ( StringUtils.strip ( "" ) );//""
        System.out.println ( StringUtils.strip ( " " ) );//""
        System.out.println ( StringUtils.strip ( "     \b \t \n \f \r    " ) );//"\b"
        System.out.println ( StringUtils.strip ( "     \n\tss   \b" ) );//"ss   \b"
        System.out.println ( StringUtils.strip ( " d   d dd     " ) );//"d   d dd"
        System.out.println ( StringUtils.strip ( "dd     " ) );//"dd"
        System.out.println ( StringUtils.strip ( "     dd       " ) );//"dd"
        
        //去掉str两端的在stripChars中的字符。如果str为null或等于""，则返回它本身；如果stripChars为null或""，则返回strip(String str)。
        System.out.println ( StringUtils.strip ( " abc ", " a " ) );//bc
        System.out.println ( StringUtils.strip ( " abcde ", " ade " ) );//bc
        System.out.println ( StringUtils.strip ( " abcde ", " ae " ) );//bcd
        //和strip相似，去掉str前端的在stripChars中的字符。
        System.out.println ( StringUtils.stripStart("abc","ba") );//c
        System.out.println ( StringUtils.stripStart("abdc ","dba") );//c
        System.out.println ( StringUtils.stripStart("abdcef ","edbaf") );//cef
        //和strip相似，去掉str后端的在stripChars中的字符。
        System.out.println ( StringUtils.stripEnd("abc","bc") );//a
        System.out.println ( StringUtils.stripEnd("abdc ","dc") );//abdc
        System.out.println ( StringUtils.stripEnd("abdcef","cef") );//abd
        System.out.println ( StringUtils.stripEnd("abdcef ","cef") );//abdcef 
        //对字符串数组中的每个字符串进行strip(String str)，然后返回。
        System.out.println ( "-------------------------------------------------" );
        for ( String str : StringUtils.stripAll ( new String[] {" abc ","a b"," c ","cb"} ) ) {
            System.out.println ( str );
        }
        System.out.println ( "-------------------------------------------------" );
        //对字符串数组中的每个字符串进行strip(String str, String stripChars)，然后返回。
        for ( String str : StringUtils.stripAll ( new String[] {" abc ","a b"," c ","cb","aaa","aa"," ba"},"a" ) ) {
            System.out.println ( str );
        }
        System.out.println ( "----------------------------------" );
        //不知道有什么用0.0
        System.out.println ( StringUtils.stripAccents ( "abc" ) );
    }
    //去掉字符串两端的空白符(whitespace)，如果变为null或""，则返回null
    @Test
    public void testStripToNull () {
        System.out.println ();
        System.out.println ( StringUtils.stripToNull ( null ) ); // null
        System.out.println ( StringUtils.stripToNull ( "" ) ); // null
        System.out.println ( StringUtils.stripToNull ( " " ) ); // null
        System.out.println ( StringUtils.stripToNull ( "     \b \t \n \f \r    " ) );// "\b"
        System.out.println ( StringUtils.stripToNull ( "     \n\tss   \b" ) ); // "ss   \b"
        System.out.println ( StringUtils.stripToNull ( " d   d dd     " ) ); // "d   d dd"
        System.out.println ( StringUtils.stripToNull ( "dd     " ) ); // "dd"
        System.out.println ( StringUtils.stripToNull ( "     dd       " ) ); // "dd"
    }

    //去掉字符串两端的空白符(whitespace)，如果变为null或""，则返回""
    @Test
    public void testStripToEmpty () {
        System.out.println ( StringUtils.stripToEmpty ( null ) ); //""
        System.out.println ( StringUtils.stripToEmpty ( "" ) ); // ""
        System.out.println ( StringUtils.stripToEmpty ( " " ) ); // ""
        System.out.println ( StringUtils.stripToEmpty ( "     \b \t \n \f \r    " ) ); // "\b"
        System.out.println ( StringUtils.stripToEmpty ( "     \n\tss   \b" ) ); // "ss   \b"
        System.out.println ( StringUtils.stripToEmpty ( " d   d dd     " ) ); //"d   d dd"
        System.out.println ( StringUtils.stripToEmpty ( "dd     " ) ); // "dd"
        System.out.println ( StringUtils.stripToEmpty ( "     dd       " ) ); // "dd"
    }
    //二遍字符串是否一致
    @Test
    public void testEquals() {
        System.out.println ( StringUtils.equals ( " ", " " ) );//true
        System.out.println ( StringUtils.equals ( "", " " ) );//false
        System.out.println ( StringUtils.equals ( null, null) );//true
        System.out.println ( StringUtils.equals ( null, "") );//false
        //不区分大小写
        System.out.println (StringUtils.equalsIgnoreCase ( "abcdef", "AbCdEf" ) );//true
        System.out.println (StringUtils.equalsIgnoreCase ( "abcdef", "AbCdE" ) );//false
        
        System.out.println ( "-------------------------------------");
        System.out.println ( StringUtils.equalsAny( " abc ", "ab" ) );//false
        System.out.println ( StringUtils.equalsAny ( "abcde", "f" ) );//false
        System.out.println ( StringUtils.equalsAny ( "abcde", "cd") );//false
        System.out.println ( StringUtils.equalsAny ("abcde", "g") );//false
        System.out.println ( StringUtils.equalsAny( " abc ", "abc" ) );//false
        System.out.println ( StringUtils.equalsAny ( "abcde", "abcde" ) );//true
        //不区分大小写
        System.out.println (StringUtils.equalsAnyIgnoreCase ( "abc","ABC" ) );//true
        System.out.println (StringUtils.equalsAnyIgnoreCase ( "abc","abc" ) );//true
        System.out.println (StringUtils.equalsAnyIgnoreCase ( "abcd","abcD" ) );//true
    }
    //配置一个字符串是否包含另一个字符串
    @Test
    public void testIndexOf() {
        //从左到右匹配到的下标
        System.out.println (StringUtils.indexOf ( "abcde", "ab" ) );//0
        System.out.println (StringUtils.indexOf ( "abcde", "bc" ) );//1
        System.out.println (StringUtils.indexOf ( "abcde", "e" ) );//4
        //找出字符数组searChars第一次出现在字符串中的位置
        System.out.println ( StringUtils.indexOfAny ( "abcdefg", "ds" ) );//3
        System.out.println ( StringUtils.indexOfAny ( "abcdefg", "g" ) );//6
        System.out.println ( StringUtils.indexOfAny ( "abcdefg", "op" ) );//-1
        System.out.println (  StringUtils.indexOfAny ( "abcdef", new String[] {"poi","ios","a"} ));//0
        System.out.println (  StringUtils.indexOfAny ( "abcdef", new String[] {"poi","ios","e"} ));//4

        //从右往左取值
        System.out.println (StringUtils.lastIndexOf ( "abcde", "ab" ) );//0
        System.out.println (StringUtils.lastIndexOf ( "abcde", "bc" ) );//1
        System.out.println (StringUtils.lastIndexOf ( "abcde", "e" ) );//4
        //找出字符数组searChars第一次出现在字符串中的位置
        System.out.println ( StringUtils.lastIndexOfAny ( "abcdefg", "ds" ) );//-1
        System.out.println ( StringUtils.lastIndexOfAny ( "abcdefg", "g" ) );//6
        System.out.println ( StringUtils.lastIndexOfAny ( "abcdefg", "op" ) );//-1
        System.out.println (  StringUtils.lastIndexOfAny ( "abcdef", new String[] {"poi","ios","a"} ));//0
        System.out.println (  StringUtils.lastIndexOfAny ( "abcdef", new String[] {"poi","ios","e"} ));//4
        
        //找出字符串中不在字符数组searchars中的第一个字符出现的位置(从0位开始) 如果都在，返回-1
        System.out.println (StringUtils.indexOfAnyBut("sdsfhhl0","h"));//结果是0
        System.out.println (StringUtils.indexOfAnyBut("sdsfhhl0","s"));//结果是1
        System.out.println (StringUtils.indexOfAnyBut("aa","aa"));//结果是-1
        
        //统计参数1和参数2开始部分共有的字符个数
        System.out.println (StringUtils.indexOfDifference("sdsfdsf","s"));//结果是1
        System.out.println (StringUtils.indexOfDifference(new String[]{"sdsfdsf","s"}));//结果是1
        System.out.println ( "----------------------------------------------" );
        ///去掉参数2在参数1开始部分共有的字符串
        System.out.println (StringUtils.difference("靓仔靓仔","靓仔靓仔UYS"));//结果是：UYS
        System.out.println (StringUtils.difference("奥利给啊啊","奥利给啊啊QWQ"));//结果是：QWQ
        //查找，不区分大小写,没有找到返回-1
        System.out.println (StringUtils.indexOfIgnoreCase("aFabbSSdd","f"));//返回1
        System.out.println (StringUtils.indexOfIgnoreCase("aFabbSSdd","f",2));//从指定位置开始查找，不区分大小写--返回-1
        System.out.println (StringUtils.indexOfIgnoreCase("aFabbSSdd","f",1));//返回1
        System.out.println (StringUtils.lastIndexOfIgnoreCase("",""));//0
        System.out.println (StringUtils.lastIndexOfIgnoreCase("","",2));//0
    }
    //
    @Test
    public void testAlpha() {
        //判断是否只包含unicode字符（注意：汉字也是unicode字符）
        System.out.println ( StringUtils.isAlpha ( "爱我中华" ) );//true
        System.out.println ( StringUtils.isAlpha ( "爱我 大中华" ) );//false
        System.out.println ( StringUtils.isAlpha ( "&*(" ) );//false
        //判断是否只包含unicode字符及空格
        System.out.println ( StringUtils.isAlphaSpace ( "爱我中华" ) );//true
        System.out.println ( StringUtils.isAlphaSpace ( "爱我 大中华" ) );//true
        System.out.println ( StringUtils.isAlphaSpace ( "123456" ) );//false
        //判断是否只包含unicode字符、数字及空格
        System.out.println ( StringUtils.isAlphanumeric("中国8681") );//true
        //判断是否只包含unicode字符、数字及空格
        System.out.println ( StringUtils.isAlphanumericSpace("1 2 3 4 5 6") );//true
        System.out.println ( StringUtils.isAlphanumericSpace("一二三四五六") );//true
        System.out.println ( StringUtils.isAlphanumericSpace("1 2 3 4 5 6 一<") );//false
        //判断是否只包含数字及空格
        System.out.println ( StringUtils.isNumericSpace ( "1 2 3 4 5   6" ) );//true
        System.out.println ( StringUtils.isNumericSpace ( "1 2 3 4 5  五  6" ) );//false
        //判断是否只包含可打印的ascii码字符（注意，空格不属于范围内）
        System.out.println ( StringUtils.isAsciiPrintable("aAbBcC") );//true
        //判断是否为数字（注意：小数点和正负号，都会判定为false）
        System.out.println ( StringUtils.isNumeric("123456") );//true
        System.out.println ( StringUtils.isNumeric("123456o") );//false
        //判定是否只包括空白字符
        System.out.println ( StringUtils.isWhitespace(" ") );//true
        System.out.println ( StringUtils.isWhitespace("") );//true
        System.out.println ( StringUtils.isWhitespace(null) );//false
        System.out.println ( StringUtils.isWhitespace("空") );//false
        //判定是否全部为大写
        System.out.println ( StringUtils.isAllUpperCase("ABCDE") );//true
        System.out.println ( StringUtils.isAllUpperCase("Abcde") );//false
        System.out.println ( StringUtils.isAllUpperCase("abcde") );//false
        //判定是否全部为小写
        System.out.println ( StringUtils.isAllLowerCase("") );
        //判定是否混合大小写（注意：包含其他字符，如空格，不影响结果判定）
        System.out.println ( StringUtils.isMixedCase("AAAAAA") );//false
        System.out.println ( StringUtils.isMixedCase("AAAAAAbbbbbb") );//true
    }
    //起止字符判定
    @Test
    public void testStartsWith() {
        System.out.println ( StringUtils.startsWith ( "abc", "abc" ) );//true
        System.out.println ( StringUtils.startsWith ( "aBc", "abc" ) );//false
        System.out.println ( StringUtils.startsWith ( "ABC", "abc" ) );//false
        //不区分大小写
        System.out.println ( StringUtils.startsWithIgnoreCase ( "abc", "abc" ) );//true
        System.out.println ( StringUtils.startsWithIgnoreCase ( "aBc", "abc" ) );//true
        System.out.println ( StringUtils.startsWithIgnoreCase ( "ABC", "abc" ) );//true
        //字符串以数组中的字符串开始
        System.out.println ( StringUtils.startsWithAny ( "abc", new String[] {"abc","aBc","ABC"} ) );//true
        System.out.println ( StringUtils.startsWithAny ( "aBc", new String[] {"abc","aaa","bbb"} ) );//false
        System.out.println ( StringUtils.startsWithAny ( "ABC", new String[] {"bbb","ccc","aaa"} ) );//false
    }
    @Test
    //不解释了同上一个开头一个结尾
    public void testEndsWith() {
    }
    //替换字符串:把text中的searchString替换成replacement，max是最大替换次数，默认是替换所有
    @Test
    public void testReplace() {
        System.out.println ( StringUtils.replace ("sshhhs","ss","p" ) );//全部替换--->结果是：phhhs
        System.out.println ( StringUtils.replace ("sshhhsshss","ss","7777",2 ) );//max：最大替换次数-->结果是：7777hhh7777hss
        //替换一次
        System.out.println ( StringUtils.replaceOnce ( "sshhhss","ss","p" ) );//只替换一次-->结果是：phhhss
        System.out.println ( StringUtils.replaceOnceIgnoreCase ( "Sshhhss","ss","p" ) );//不区分大小写,phhhss
        //替换全部，马上被放弃的方法
        System.out.println ( StringUtils.replaceAll ( "aabbccddaabbccaabb", "aa", "11" ) );//11bbccdd11bbcc11bb
        //替换单字符
        System.out.println (  StringUtils.replaceChars ( "abcdeabcdeabcdeaaa", "a", "2" ));//2bcde2bcde2bcde222
        //替换全部char one by one暂时看不出和replace有什么区别
        System.out.println ( StringUtils.replaceChars ( "abcabcabcabc", "abc", "123" ) );//123123123123
        //替换第一个匹配字符串，马上放弃的方法
        System.out.println ( StringUtils.replaceFirst ( "abcabcabcabc", "abc", "ABC" ) );//ABCabcabcabc
        //不区分大小写
        System.out.println ( StringUtils.replaceIgnoreCase ( "AbcabCaBc", "abc", "^_^" ) );//^_^^_^^_^
        System.out.println ( StringUtils.replaceIgnoreCase ( "AbcabCaBc", "abc", "^_^" , 2 ) );//^_^^_^aBc
    }
}
