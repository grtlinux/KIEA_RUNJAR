package org.tain.runjar;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import org.tain.utils.ClassUtils;

public final class RunJarLoader {

	private static final boolean flag;
	private static final String className;
	private static final String resourcePath;
	private static final ResourceBundle resourceBundle;
	
	static {
		flag = true;
		className = new Object() {}.getClass().getEnclosingClass().getName();
		resourcePath = className.replace('.', '/');
		resourceBundle = ResourceBundle.getBundle(resourcePath);
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		if (!flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());
		
		String metaLib = resourceBundle.getString("org.tain.runjar.path.lib");
		String[] jarFiles = null;
		List<URL> lstUrl = null;
		String runClassName = null;
		String[] runArgs = null;
		
		if (flag) {
			runClassName = resourceBundle.getString(String.format("org.tain.runjar.%s", args[0]));
			runArgs = Arrays.copyOfRange(args, 1, args.length);
		}
		
		if (flag) {
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(metaLib);
			while (urls.hasMoreElements()) {
				URL url = (URL) urls.nextElement();
				if (!flag) System.out.printf(">>>>> url = %s%n", url );
				
				File libJars = new File(url.toURI());
				jarFiles = libJars.list();
			}
			
			if (!flag) {
				// print jarFiles
				for (String jarFile : jarFiles) {
					System.out.printf(">>>>> %s%n", jarFile);
				}
			}
		}
		
		if (flag) {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL.setURLStreamHandlerFactory(new RsrcURLStreamHandlerFactory(classLoader));
			
			lstUrl = new ArrayList<URL>();
			lstUrl.add(new URL("rsrc:./"));

			for (int i=0; i < jarFiles.length; i++) {
				String rsrc = String.format("jar:rsrc:%s%s!/", metaLib, jarFiles[i]);
				if (!flag) System.out.printf(">>>>> %s%n", rsrc);

				lstUrl.add(new URL(rsrc));
			}
			
			if (!flag) System.out.println(">>>>> lstUrl: " + lstUrl);  // print lstUrl
		}
		
		if (flag) {
			ClassLoader jceClassLoader = new URLClassLoader(lstUrl.toArray(new URL[lstUrl.size()]), null);
			Thread.currentThread().setContextClassLoader(jceClassLoader);
			
			Class<?> cls = Class.forName(runClassName, true, jceClassLoader);
			Method main = cls.getMethod("main", new Class[] { runArgs.getClass() });
			main.invoke((Object) null, new Object[] { runArgs });
		}
		
		if (!flag) {
			// post execute
			if (flag) System.out.println(">>>>> POST EXIT..");
		}
	}
	
	public static void main(String[] args) throws Exception {
		if (!flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());

		if (!flag) {
			// test for arguments
			args = new String[] {};
			args = new String[] { "default", };
			args = new String[] { "default", "ARG-1", };
			args = new String[] { "test01", };
			args = new String[] { "test01", "ARG-1", };
			args = new String[] { "test02", };
			args = new String[] { "test03", };
		}
		
		if (flag) {
			if (args.length == 0) 
				args = new String[] { "default", };
		}
		
		if (flag) test01(args);
	}
}
