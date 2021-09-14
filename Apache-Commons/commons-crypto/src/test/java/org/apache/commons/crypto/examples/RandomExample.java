package org.apache.commons.crypto.examples;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.crypto.random.CryptoRandom;
import org.apache.commons.crypto.random.CryptoRandomFactory;

/***
 * 
 * @author zhanchaohan
 *
 */
public class RandomExample {
	
	public static void main(final String[] args) throws GeneralSecurityException, IOException {
		// Constructs a byte array to store random data.
		final byte[] key = new byte[16];
		final byte[] iv = new byte[32];

		final Properties properties = new Properties();
		properties.put(CryptoRandomFactory.CLASSES_KEY, CryptoRandomFactory.RandomProvider.OPENSSL.getClassName());

		// Gets the 'CryptoRandom' instance.
		try (CryptoRandom random = CryptoRandomFactory.getCryptoRandom(properties)) {

			// Show the actual class (may be different from the one requested)
			System.out.println(random.getClass().getCanonicalName());

			// Generate random bytes and places them into the byte arrays.
			random.nextBytes(key);
			random.nextBytes(iv);

		}

		// Show the generated output
		System.out.println(Arrays.toString(key));
		System.out.println(Arrays.toString(iv));
	}
}
