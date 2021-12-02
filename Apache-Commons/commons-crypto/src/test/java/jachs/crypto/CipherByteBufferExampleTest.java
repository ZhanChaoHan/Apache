package jachs.crypto;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class CipherByteBufferExampleTest {
	CipherByteBufferExample cbbe=new CipherByteBufferExample();
	
	@Test
	public void test1() throws InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, BadPaddingException, IllegalBlockSizeException, IOException {
		String eCode=cbbe.encrypt("HelloWorld");
	}
	
	@Test
	public void test2() throws InvalidKeyException, InvalidAlgorithmParameterException, ShortBufferException, BadPaddingException, IllegalBlockSizeException, IOException {
		String dCode=cbbe.dencrypt("tUZC6rDx36bG/1TjwZV/8A==");
	}
	
}
