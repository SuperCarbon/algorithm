package com.zj.algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		File f = new File("D:\\test.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		for (int i = 0; i < 1000000; i++) {
			String url = "www.163.com";
			bw.write(url + "\r\n");
		}
		bw.close();
		long end = System.currentTimeMillis();
		System.out.println("spend time==>" + (end - start));
	}

}
