package gov.nist.example.zip;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.util.*;
import java.util.zip.*;

import org.apache.commons.codec.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.jdom2.JDOMException;

import com.google.common.io.ByteSource;

import gov.nist.example.microsoft_2016.model.StaticWord;
import gov.nist.example.parse.XmlWordDocument;

/**
 * This program reads contents of a ZIP file.
 *
 * @author www.codejava.net
 */
public class ReadZipFile {
	
	public static String CATALOG_LOCATION = "C:\\Users\\sebas\\eclipse-workspace3\\NIST\\src\\main\\resources\\full_nist_low_example.xml"; //NEEDS TO BE A PROPERTY!

//	private static void read(String zipFilePath) {
//		try {
//			ZipFile zipFile = new ZipFile(zipFilePath);
//			final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFilePath));
//
//			Enumeration<? extends ZipEntry> entries = zipFile.entries();
//			String text = null;
//
//			while (entries.hasMoreElements()) {
//				ZipEntry entry = entries.nextElement();
//				String name = entry.getName();
//				if (StringUtils.equalsAnyIgnoreCase(name, "word/document.xml")) {
//					System.out.println("HERE!!!");
//					InputStream stream = zipFile.getInputStream(entry);
//					ByteSource byteSource = new ByteSource() {
//						@Override
//						public InputStream openStream() throws IOException {
//							return stream;
//						}
//					};
//					try {
//						XmlWordDocument xmlWord = new XmlWordDocument(byteSource.openBufferedStream());
//					} catch (JDOMException e) {
//						System.out.println("Failed: " + e.getMessage());
//						e.printStackTrace();
//					}
////					text = byteSource.asCharSource(Charsets.UTF_8).read();
////					text = StringUtils.replace(text, "field", "Iggy");
////					System.out.println(text);
//					zos.putNextEntry(new ZipEntry("word/document.xml"));
//					zos.putNextEntry(new ZipEntry("abc.txt"));
//
////					byte[] buf = new byte[1024];
////					int len;
////					while ((len = (stream.read(buf))) > 0) {
////						String s = new String(buf);
////						if (s.contains("field")) {
////							buf = s.replaceAll("field", "Iggy").getBytes();
////						}
////						zos.write(buf, 0, (len < buf.length) ? len : buf.length);
////					}
//					zos.closeEntry();
//					zos.close();
//				} else {
//
//			        zos.putNextEntry(entry);
//			        InputStream is = zipFile.getInputStream(entry);
//			        byte[] buf = new byte[1024];
//			        int len;
//			        while((len = is.read(buf)) > 0) {            
//			            zos.write(buf, 0, len);
//			        }
//				}
////                long compressedSize = entry.getCompressedSize();
////                long normalSize = entry.getSize();
////                String type = entry.isDirectory() ? "DIR" : "FILE";
//// 
////                System.out.println(name);
////                System.out.format("\t %s - %d - %d\n", type, compressedSize, normalSize);
//			}
//
//			zipFile.close();
//		} catch (IOException ex) {
//			System.err.println(ex);
//		}
//	}
	
	static void modifyTextFileInZip(String zipPath) throws Exception {
	    Path zipFilePath = Paths.get(zipPath);
	    try (FileSystem fs = FileSystems.newFileSystem(zipFilePath, null)) {
	        Path source = fs.getPath("word/document.xml");
	        Files.deleteIfExists(source);
	    	//Files.delete(source);
	    	Files.write(source, StaticWord.writeBeginning().getBytes());
	    	XmlWordDocument xmlWord = new XmlWordDocument(CATALOG_LOCATION);
	    	Files.write(source, xmlWord.run().getBytes(), StandardOpenOption.APPEND);
	    	Files.write(source, StaticWord.writeEnding().getBytes(), StandardOpenOption.APPEND);

	    }
	}

	public static void main(String[] args) throws Exception {
		String zipFilePath = "C:\\Users\\sebas\\eclipse-workspace3\\NIST\\src\\main\\resources\\FedRAMP-SSP-Low-Baseline-Template - Copy.docx";// args[0];
		String newZipFile = "C:\\Users\\sebas\\eclipse-workspace3\\NIST\\src\\main\\resources\\FedRAMP-SSP-Low-Baseline-Template - NEW.docx";// args[1];
		Path copied = Paths.get(newZipFile);
	    Path originalPath = Paths.get(zipFilePath);
	    Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);

		modifyTextFileInZip(newZipFile);
	}
}