package com.jachs.apacheapi.pdfbox;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.junit.Test;

import com.jachs.apache.ApacheApiApplication;

/***
 * 加密PDF文件
 * @author zhanchaohan
 *@see https://pdfbox.apache.org/2.0/cookbook/encryption.html
 */
public class EncryptingFile {
	
	@Test
	public void test() throws Exception {
		PDDocument doc = PDDocument.load(new File(ApacheApiApplication.class.getResource("/pdf/vocabulary.pdf").getPath()));

		// Define the length of the encryption key.
		// Possible values are 40, 128 or 256.
		int keyLength = 256;

		AccessPermission ap = new AccessPermission();

		// disable printing,
		ap.setCanPrint(false);
		// disable copying
		ap.setCanExtractContent(false);
		// Disable other things if needed...

		// Owner password (to open the file with all permissions) is "12345"
		// User password (to open the file but with restricted permissions, is empty
		// here)
		StandardProtectionPolicy spp = new StandardProtectionPolicy("12345", "Jachs", ap);
		spp.setEncryptionKeyLength(keyLength);

		// Apply protection
		doc.protect(spp);

		doc.save(EncryptingFile.class.getResource("").getPath()+File.separator+"filename-encrypted.pdf");
		doc.close();
	}
}
