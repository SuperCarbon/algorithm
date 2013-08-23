package com.zj.algorithm;

import java.io.IOException;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws IOException {
		String a = "123";
		String b = "123";
		String c = new String("123");
		String d = new String("123");
		//System.out.println(a.equals(b));
		System.out.println(c.equals(a));
	}

}
