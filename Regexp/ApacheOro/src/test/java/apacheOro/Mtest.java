package apacheOro;

import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.MatchResult;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Mtest {
	
	@Test
	public void test1() throws MalformedPatternException {
		String source="1、一三2、都没看到,31、一三2、都没看到modna9、cahciah12、";
		
		String picReg = "\\d、";

		Perl5Compiler compiler = new Perl5Compiler();
		Perl5Matcher matcher = new Perl5Matcher();
		PatternMatcherInput inputContent = new PatternMatcherInput(source);
		Pattern pattern = compiler.compile(picReg);

		while(matcher.contains(inputContent,pattern)) {
		       MatchResult result = matcher.getMatch();
		       System.out.println(result);
		}
	}
	@Test
	public void test2() throws MalformedPatternException {
		String exactMatch = "23";
		String numberExpression = "\\d+";
		 
		PatternCompiler compiler = new Perl5Compiler();
		PatternMatcher matcher= new Perl5Matcher();
		
		Pattern pattern   =compiler.compile(numberExpression);
		if(matcher.matches(exactMatch, pattern)) {
			System.out.println("匹配");
		}else {
			System.out.println("不匹配");
		}
		
	}
}
