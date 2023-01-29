package com.jachs.apachejohnzon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.johnzon.mapper.Mapper;
import org.apache.johnzon.mapper.MapperBuilder;
import org.junit.jupiter.api.Test;

import com.jachs.apachejohnzon.entity.MySuperObject;

/***
 * 
 * @author zhanchaohan
 *
 */
public class T1 {
	final Mapper mapper = new MapperBuilder().build();
	final static String FILEPATH="D:\\\\tmp\\\\test.txt";
	
	@Test
	public void t1() throws Exception {
		OutputStream os=new FileOutputStream(FILEPATH);
		final MySuperObject object = new MySuperObject();
		
		object.setName("pck");
		object.setAge(12);
		object.setAddress("隐藏字段");
		object.setT_Address("123");
		
		mapper.writeObject(object, os);
		
		os.close();
	}
	
	@Test
	public void t2() throws Exception{
		InputStream is=new FileInputStream(FILEPATH);
		
		final MySuperObject otherObject = mapper.readObject(is, MySuperObject.class);
		
		System.out.println(otherObject.getName());
		System.out.println(otherObject.getAge());
		System.out.println(otherObject.getAddress());
		System.out.println(otherObject.getT_Address());
	}
	
	
}
