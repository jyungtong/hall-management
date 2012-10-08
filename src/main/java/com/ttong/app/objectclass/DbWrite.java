package com.ttong.app.objectclass;

import java.io.*;

public class DbWrite {
	private File file;
	private FileOutputStream fostream;
	private ByteArrayOutputStream bostream;
	private ObjectOutputStream oostream;

	public DbWrite() {}

	public DbWrite(String fname) {
		file = new File(fname);
	}

	public void writeData(Object data) {
		try {
			fostream = new FileOutputStream(file);
			oostream = new ObjectOutputStream(fostream);
			oostream.writeObject(data);
		} catch(FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			try {
				oostream.close();
				fostream.close();
			} catch(FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			} catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
