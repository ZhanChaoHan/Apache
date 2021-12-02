package jachs.compress;

import java.io.File;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class ZipUtilTest {
	ZipUtil zu=new ZipUtil();
	static final String FILEPATH="E:\\log\\";
	
	@Test
	public void test1() {
		File[] sourceFiles=new File[] {
				new File(FILEPATH+"pph_error.log"),new File(FILEPATH+"pph_info.log")
				,new File(FILEPATH+"skywalkingboot-2021-02-23.0.log")};
		zu.archiveFiles2Zip(sourceFiles, new File(FILEPATH+"copy.zip"), true);
	}
	@Test
	public void test2() {
		zu.decompressZip2Files(new File(FILEPATH+"copy.zip"), new File(FILEPATH));
	}
}
