package com.jachs.apache_commons_imaging;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.apache.commons.imaging.ImageFormat;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImagingConstants;
import org.apache.commons.imaging.formats.tiff.constants.TiffConstants;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class ImageWriteExample {
	public static byte[] imageWriteExample(final File file)
			throws ImageReadException, ImageWriteException, IOException {
		// read image
		final BufferedImage image = Imaging.getBufferedImage(file);

		final ImageFormat format = ImageFormats.TIFF;
		final Map<String, Object> params = new HashMap<String, Object>();

		// set optional parameters if you like
		params.put(ImagingConstants.PARAM_KEY_COMPRESSION,
				Integer.valueOf(TiffConstants.TIFF_COMPRESSION_UNCOMPRESSED));

		return Imaging.writeImageToBytes(image, format, params);
	}
	String testImage=ImageReadExample.class.getResource("/").getPath();
	
	@Test
	public void test1() throws ImageReadException, IOException, ImageWriteException {
		byte[] bi=imageWriteExample(new File(testImage+File.separator+"best.png"));
		IOUtils.write(bi, new FileOutputStream(testImage+File.separator+"ImageWriteExample.png"));
	}
}