package jachs.commons.codec;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

/**
 * 
 * @author zhanchaohan
 *
 */
public class CodecTest {
	@Test
	public void test() {
		byte[] data = "hell world".getBytes();
		Base64 base64 = new Base64();
		String encode = base64.encodeAsString(data);
		System.out.println(encode);
		System.out.println(new String(base64.decode(encode)));
	}

	@Test
	public void test1() {
		System.out.println("===============MD5======================");
		String result = DigestUtils.md5Hex("测试");
		System.out.println(result);
	}

	@Test
	public void test2() throws UnsupportedEncodingException, DecoderException {
	}
}
