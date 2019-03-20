package com.java.example.io;

import java.io.File;

public class FileEx {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\BrajaGopalMaity\\Desktop");
		
		System.out.println("Is directory : "+ file.isDirectory());
		System.out.println("Absolute path : "+ file.getAbsolutePath());
		System.out.println("Path : "+ file.getPath());
		System.out.println(file.lastModified());
		
		for(File f: file.listFiles()) {
			System.out.println(f.getName() + f.isDirectory());
		}
	}

}
