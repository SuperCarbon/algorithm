package com.zj.algorithm;

import java.io.IOException;
import java.util.Date;

public class Test {

	public static void main(String[] args) throws IOException {
		Date date = new Date();
		Employee e = new Employee(date);
		System.out.print(e.date);
	}

}
