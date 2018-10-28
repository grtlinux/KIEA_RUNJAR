package org.tain.main;

import java.util.Arrays;

import org.tain.utils.ClassUtils;

public class UsageMain {

	private static final boolean flag;
	
	static {
		flag = true;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	private static void run01(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());

		if (flag) {
			if (flag) System.out.println(">>>>> arguments: " + Arrays.asList(args));
		}

		if (flag) {
			// USAGE: test01
			System.out.println("---------- arg0: test01 -----------");
			System.out.println("COMMENT: test01 project");
			System.out.println("USAGE: java -jar RunJar.jar test01 args...");
			System.out.println();
		}
		
		if (flag) {
			// USAGE: test02
			System.out.println("---------- arg0: test02 -----------");
			System.out.println("COMMENT: test02 project");
			System.out.println("USAGE: java -jar RunJar.jar test02 args...");
			System.out.println();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		if (flag) run01(args);
	}
}
