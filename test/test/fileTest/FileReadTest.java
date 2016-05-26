package test.fileTest;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.hibernate.annotations.Where;

public class FileReadTest {

	public static void main(String[] args) {

		try {

			File file = new File(
					"E:\\数据\\google_5000000/google_5000000.txt");

			InputStream is = new FileInputStream(file);
			
			DataInputStream ds = new DataInputStream(is);

			String s="";
			
			while (s!=null) {
				s=ds.readLine();
				System.out.println(s);
			}

			ds.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
