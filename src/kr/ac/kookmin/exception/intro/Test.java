package kr.ac.kookmin.exception.intro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

class AAA {

	public void readFile() {
		File path = new File("src/kr/ac/kookmin/exception/intro");
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader(path + "/a.txt"));
			try {
				String s = null;
				while ((s = inputStream.readLine()) != null) {
					System.out.println(s);
				}
			} finally {
				close(inputStream);
			}
		} catch (FileNotFoundException e) {
			System.err.println("Caught FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}
	}

	public void close(BufferedReader inputStream) {
		try {
			inputStream.close();
		} catch (Exception e) {
			System.err.println("Caught Exception: " + e.getMessage());
		}
	}
}

public class Test {
	public static void main(String args[]) {
		AAA a = new AAA();
		a.readFile();
	}
}