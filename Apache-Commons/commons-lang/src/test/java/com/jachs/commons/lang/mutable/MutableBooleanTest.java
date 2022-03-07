package com.jachs.commons.lang.mutable;

import org.apache.commons.lang3.mutable.MutableBoolean;
import org.junit.Test;

/***
 * @author zhanchaohan
 */
public class MutableBooleanTest {
    MutableBoolean mb=new MutableBoolean();

    @Test//看不懂有啥用
    public void test1(){
       mb.setValue(true);

       System.out.println(mb.getValue());
       System.out.println(mb.isFalse());
    }
}
