package com.jachs.commons.io.comparator;

import java.io.File;
import java.util.Comparator;

import org.apache.commons.io.comparator.CompositeFileComparator;
import org.apache.commons.io.comparator.DirectoryFileComparator;
import org.apache.commons.io.comparator.NameFileComparator;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CompositeFileComparatorTest {
	
	@Test
	public void test1() {
		CompositeFileComparator cfc=new CompositeFileComparator(
                (Comparator<File>) DirectoryFileComparator.DIRECTORY_COMPARATOR,
                 (Comparator<File>) NameFileComparator.NAME_COMPARATOR);

		
		int c=cfc.compare(new File("F:\\assss.txt"), new File("F:\\arthas-boot.jar"));
		
		int c2=cfc.compare(new File("F:\\assss.txt"), new File("F:\\assss.txt"));
		
		System.out.println(c);
		System.out.println(c2);
	}
}
