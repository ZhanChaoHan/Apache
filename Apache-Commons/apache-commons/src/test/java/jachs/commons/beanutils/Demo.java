package jachs.commons.beanutils;


import org.junit.Test;
import org.springframework.beans.BeanUtils;

import jachs.commons.beanutils.vo.People;
import jachs.commons.beanutils.vo.Person;

/**
 * @author zhanchaohan
 * 
 */
public class Demo {

    @Test
    public void tests () {
        People p1 = new People ( "张三", 10, 123456789 );

        Person ps1 = new Person ( "donkey", 8, "154782@jhk.com" );
        //原属性覆盖掉了
        BeanUtils.copyProperties ( p1, ps1 );
        System.out.println ( p1.toString () );
        System.out.println ( ps1.toString () );

        System.out.println ( "2020-07-04 14:53:40".split ( "\\s" )[0] );
        //       BeanUtils.copyProperties ( p1, ps1, editable );
    }
}
