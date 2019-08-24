package gov.nist.example.microsoft_2016.model;

import java.nio.file.Files;
import java.nio.file.Paths;

public class StaticWord {
	public static String writeBeginning() {
		String result = null;
		try {
			result = new String(Files.readAllBytes(Paths.get("C:\\Users\\sebas\\eclipse-workspace3\\NIST\\src\\main\\resources\\beginning.txt")));
		} catch (Exception e) {
			
		}
		return result;
	}
	
	public static String writeEnding() {
		String result = null;
		try {
			result = new String(Files.readAllBytes(Paths.get("C:\\Users\\sebas\\eclipse-workspace3\\NIST\\src\\main\\resources\\ending.txt")));
		} catch (Exception e) {
			
		}
		return result;
	}

}
