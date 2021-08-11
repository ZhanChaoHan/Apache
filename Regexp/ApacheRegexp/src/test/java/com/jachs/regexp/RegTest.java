package com.jachs.regexp;

import org.apache.regexp.RE;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class RegTest {

	@Test
	public void test1() {
		RE r = new RE("a*b");
		boolean matched = r.match("aaaab");

		System.out.println(matched);
	}

	@Test
	public void test2() {
		// ------------------------------------
		RE r = new RE("(a*)b"); // Compile expression
		boolean matched = r.match("xaaaab"); // Match against "xaaaab"

		String wholeExpr = r.getParen(0); // wholeExpr will be 'aaaab'
		String insideParens = r.getParen(1); // insideParens will be 'aaaa'

		int startWholeExpr = r.getParenStart(0); // startWholeExpr will be index 1
		int endWholeExpr = r.getParenEnd(0); // endWholeExpr will be index 6
		int lenWholeExpr = r.getParenLength(0); // lenWholeExpr will be 5

		int startInside = r.getParenStart(1); // startInside will be index 1
		int endInside = r.getParenEnd(1); // endInside will be index 5
		int lenInside = r.getParenLength(1); // lenInside will be 4
		
		System.out.println(matched);
		System.out.println("-------------------------------------------------");
		System.out.println(wholeExpr);
		System.out.println(insideParens);
		System.out.println("-------------------------------------------------");
		System.out.println(startWholeExpr);
		System.out.println(endWholeExpr);
		System.out.println(lenWholeExpr);
		System.out.println("-------------------------------------------------");
		System.out.println(startInside);
		System.out.println(endInside);
		System.out.println(lenInside);
	}
}
