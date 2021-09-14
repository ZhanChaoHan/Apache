package org.apache.commons.crypto.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.crypto.stream.CryptoInputStream;
import org.apache.commons.crypto.stream.CryptoOutputStream;

/***
 * 
 * @author zhanchaohan
 *
 */
public class StreamExample {
	
	public static void main(final String[] args) throws IOException {
		final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("1234567890123456"), "AES");
		final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));
		final Properties properties = new Properties();
		final String transform = "AES/CBC/PKCS5Padding";

		final String input = "hello world!";
		// Encryption with CryptoOutputStream.

		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try (CryptoOutputStream cos = new CryptoOutputStream(transform, properties, outputStream, key, iv)) {
			cos.write(getUTF8Bytes(input));
			cos.flush();
		}

		// The encrypted data:
		System.out.println("Encrypted: " + Arrays.toString(outputStream.toByteArray()));

		// Decryption with CryptoInputStream.
		final InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

		try (CryptoInputStream cis = new CryptoInputStream(transform, properties, inputStream, key, iv)) {
			final byte[] decryptedData = new byte[1024];
			int decryptedLen = 0;
			int i;
			while ((i = cis.read(decryptedData, decryptedLen, decryptedData.length - decryptedLen)) > -1) {
				decryptedLen += i;
			}
			System.out.println("Decrypted: " + new String(decryptedData, 0, decryptedLen, StandardCharsets.UTF_8));
		}
	}

	/**
	 * Converts String to UTF8 bytes
	 *
	 * @param input the input string
	 * @return UTF8 bytes
	 */
	private static byte[] getUTF8Bytes(final String input) {
		return input.getBytes(StandardCharsets.UTF_8);
	}
}
