package com.ttong.app.objectclass;

import java.io.*;

public class DbRead {
	private File file;
	private FileInputStream fistream;
	private ByteArrayInputStream bistream;
	private ObjectInputStream oistream;

	public DbRead() {}

	public DbRead(String fname) {
		file = new File(fname);
	}

	public Object getData() {
		Object data = null;

		if(file.exists()) {
			try {
				fistream = new FileInputStream(file);
				oistream = new ObjectInputStream(fistream);
				data = oistream.readObject();
			} catch(FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			} catch(ClassNotFoundException ex) {
				System.out.println(ex.getMessage());
			} finally {
				try {
					fistream.close();
					oistream.close();
				} catch(IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}

		return data;
	}
}
