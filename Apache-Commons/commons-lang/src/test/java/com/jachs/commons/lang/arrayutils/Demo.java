package com.jachs.commons.lang.arrayutils;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/****
 * 集合处理工具类有点鸡助跟JDK的java.util.Arrays差不多
 * 
 * @author zhanchaohan
 *https://commons.apache.org/proper/commons-lang/javadocs/api-release/index.html
 */
public class Demo {
	// 添加数据
	@Test
	public void ArrayUtilsAddDemo() {
		// 简单添加
		ArrayUtils arrayUtils = new ArrayUtils();
		boolean[] boo1 = new boolean[] { true, true };
		boolean[] boo2 = arrayUtils.add(boo1, false);

		for (boolean b : boo2) {
			System.out.println(b);
		}
		// 添加到指定下标
		char[] ch = new char[5];
		ch[1] = 'a';
		char[] ch1 = arrayUtils.add(ch, 2, 'b');
		for (char c : ch1) {
			System.out.println(c);
		}
		// 添加全部
		String[] st = new String[] { "我", "是" };
		String[] st1 = new String[] { "中", "国", "人" };
		String[] st2 = arrayUtils.addAll(st, st1);
		for (String string : st2) {
			System.out.println(string);
		}
	}

	/****
	 * 克隆返回类型转换结果并处理空值的数组。
	 */
	@Test
	public void ArrayUtilscloneDemo() {
		ArrayUtils arrayUtils = new ArrayUtils();
		// copy数组
		char[] ch = new char[] { 77, 76 };
		char[] ch1 = arrayUtils.clone(ch);
		System.out.println(arrayUtils.isEquals(ch, ch1));
		for (char c : ch1) {
			System.out.println(c);
		}
		//
		double[] dou = new double[5];
		dou[1] = 2.2;
		dou[2] = 3.2;
		double[] dou1 = arrayUtils.clone(dou);
		double[] dou2 = dou;
		System.out.println(arrayUtils.isEquals(dou, dou1));
		System.out.println(arrayUtils.isEquals(dou, dou2));
		System.out.println(arrayUtils.isEquals(dou1, dou2));
		dou[0] = 5.5;
		for (double d : dou) {
			System.out.println(d);
		}
		System.out.println("-------------");
		for (double d : dou1) {
			System.out.println(d);
		}
		System.out.println("-------------");
		for (double d : dou2) {
			System.out.println(d);
		}
	}

	// 判断数据是否存在该数据
	@Test
	public void ArrayUtilsContainsDemo() {
		ArrayUtils arrayUtils = new ArrayUtils();
		int[] in = new int[] { 2, 5 };
		System.out.println(arrayUtils.contains(in, 2));
		System.out.println(arrayUtils.contains(in, 1));
		String[] st = new String[] { "一个", "汉字" };
		System.out.println(arrayUtils.contains(st, "汉"));
		System.out.println(arrayUtils.contains(st, "汉字"));
	}

	// 判断数据是否存在该数据
	@Test
	public void ArrayUtilsIndexOfDemo() {
		ArrayUtils arrayUtils = new ArrayUtils();
		char[] ch = new char[] { 87, 89, 99, 100, 452, 99 };
		int index = arrayUtils.indexOf(ch, (char) 99);
		int indexStart = arrayUtils.indexOf(ch, (char) 99, 4);// 数组,配置字符,起始匹配位置
		System.out.println(index);
		System.out.println(indexStart);
		String[] str = new String[] { "文", "字", "一" };
		int strIndex = arrayUtils.indexOf(str, "字");
		int strIndex1 = arrayUtils.indexOf(str, "无");
		System.out.println(strIndex);
		System.out.println(strIndex1);
		// 指标的给定的值在一个给定的容差的阵列。搞不懂什么意思。。。
		double[] dou = new double[] { 1.5, 2.5, 3.5 };
		int douIndex = arrayUtils.indexOf(dou, 3.5, 3.2);
		// indexOf(double[] array, double valueToFind, int startIndex, double tolerance)
		System.out.println(douIndex);

		// lastIndexOf同indexOf一个左往右匹配,一个右往左匹配
	}

	// 插入数据
	@Test
	public void ArrayUtilsInsertOfDemo() {
		ArrayUtils arrayUtils = new ArrayUtils();
		int[] in = new int[5];
		in[0] = 1;
		in[1] = 3;
		int[] in0 = arrayUtils.insert(3, in, 9);// 下标3插入数字9
		int[] in1 = arrayUtils.insert(1, in, 2, 2, 3, 5, 5, 5);// 从下标1开始依次插入2,2,3,5,5,5
		for (int i : in0) {
			System.out.println(i);
		}
		System.out.println("-------------");
		for (int i : in1) {
			System.out.println(i);
		}
	}

	// 基础校验
	@Test
	public void ArrayUtilsCheckOfDemo() {
		ArrayUtils arrayUtils = new ArrayUtils();
//		String[] str = new String[] { "文", "字" };
//		String[] str1 = new String[] { "文", "字" };
//		System.out.println(arrayUtils.isArrayIndexValid(str, 1));// 返回给定数组在给定索引处是否可以安全访问。防止下标越界和空指针
//		System.out.println(arrayUtils.isEmpty(str));// 为空
//		System.out.println(arrayUtils.isEquals(str, str1));// 值相等
//		System.out.println(arrayUtils.isNotEmpty(str));// 非空
//		System.out.println(arrayUtils.isSameLength(str, str1));// 长度是否相等
//		System.out.println(arrayUtils.isSameType(str, str1));// 类型是否相等
//		int[] in = new int[] { 1, 2, 3, 4, 5 };
//		System.out.println(arrayUtils.isSorted(in));// 此方法检查提供的数组是否按自然顺序排序（true之前为false），是否顺序排列,只能是Number不能是字符

		// nullToEmpty null转换为空防止空指针,将空引用更改为空引用的防御性编程技术。
		// remove 删除
		// removeAll 区间删除
		int[] reverse=new int[] {5,9,1,82,45,99,874};//翻转  123  321
//		arrayUtils.reverse(reverse);
//		for (int i : reverse) {
//			System.out.println(i);
//		}
//		System.out.println("----------------");
//		arrayUtils.shift(reverse, 2);//位移前后对换
//		for (int i : reverse) {
//			System.out.println(i);
//		}
//		System.out.println("----------------");
//		arrayUtils.shuffle(reverse);//使用Fisher-Yates算法随机排列指定数组的元素
//		for (int i : reverse) {
//			System.out.println(i);
//		}
		//subarray 截取
		arrayUtils.swap(reverse, 1, 2);//位置互换,下标1和下标2
		for (int i : reverse) {
			System.out.println(i);
		}
	}
}
