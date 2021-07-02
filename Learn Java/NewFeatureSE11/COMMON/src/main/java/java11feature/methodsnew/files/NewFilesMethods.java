package java11feature.methodsnew.files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NewFilesMethods {

	static void writeStringsIntoFile() {
		String strRaw = "This is String";
		String path = "abc.txt";

		Path pathFile = Paths.get(".", "xxx", "yyy", path);
		try {
			File file = new File(pathFile.getParent().toString());
			if (!file.exists()) {
				file.mkdirs();
				file.createNewFile();
			}
			Files.writeString(pathFile, strRaw, StandardCharsets.UTF_8);

		} catch (NoSuchFileException e) {

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	static void readStringsFromFile() {
		
		String path = "abc.txt";
		Path pathFile = Paths.get(".", "xxx", "yyy", path);
		try {
			File file = new File(pathFile.getParent().toString());
			if (file.exists()) {
				String readStr = Files.readString(pathFile, StandardCharsets.UTF_8);
				System.out.println("String: " + readStr);
			} else {
				System.out.println("File Not Found");
			}

		} catch (NoSuchFileException e) {

		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) throws IOException {
		writeStringsIntoFile();
		readStringsFromFile();
	}
}
