package kr.ac.kookmin.exception.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Makes numbered.txt the same as original.txt, but with each line numbered.
 */
public class AddLineNumber {
	public static void main(String[] args) {
		File path = new File("src/kr/ac/kookmin/exception/fileio");
		System.out.println(path.getAbsolutePath());

		try {
			BufferedReader inputStream =
					new BufferedReader(new FileReader(path + "/original.txt"));
			PrintWriter outputStream =
					new PrintWriter(new FileOutputStream(path + "/numbered.txt"));

			String s = null;
			int i = 0;
			outputStream.write(1);
			while ((s = inputStream.readLine()) != null) {
				i++;
				System.out.println(i + " " + s);
				outputStream.println(i + " " + s);
			}

			inputStream.close();
			outputStream.close();
		}

		catch (FileNotFoundException e) {
			System.err.println("Caught FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}
}
