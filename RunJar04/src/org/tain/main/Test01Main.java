package org.tain.main;

import java.util.Arrays;

import org.tain.utils.ClassUtils;

public class Test01Main {

	private static final boolean flag;
	
	static {
		flag = true;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		if (flag) {
			if (flag) System.out.println(">>>>> " + Arrays.asList(args));
		}
	}
}
