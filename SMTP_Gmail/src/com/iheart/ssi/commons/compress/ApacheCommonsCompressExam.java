package com.iheart.ssi.commons.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.utils.IOUtils;

public class ApacheCommonsCompressExam {
	public static void main(String[] args) {
		File output = new File("D:/", "zipFile.zip");
		File f1 = new File("D:/http.conf");
		File f2 = new File("D:/log.conf");
		File f3 = new File("D:/B2B-Client.log");
		
		try {
			OutputStream out = new FileOutputStream(output);
			
			ArchiveOutputStream os = new ArchiveStreamFactory().createArchiveOutputStream("zip", out);
			
			os.putArchiveEntry(new ZipArchiveEntry("http.conf"));
			IOUtils.copy(new FileInputStream(f1), os);
			os.closeArchiveEntry();
			
			os.putArchiveEntry(new ZipArchiveEntry("log.conf"));
			IOUtils.copy(new FileInputStream(f2), os);
			os.closeArchiveEntry();
			
			os.putArchiveEntry(new ZipArchiveEntry("B2B-Client.log"));
			IOUtils.copy(new FileInputStream(f3), os);
			os.closeArchiveEntry();
			
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ArchiveException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
