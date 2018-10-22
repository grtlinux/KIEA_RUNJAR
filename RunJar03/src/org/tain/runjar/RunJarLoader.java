package org.tain.runjar;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.tain.utils.ClassUtils;

public final class RunJarLoader {

	private static final boolean flag = true;

	///////////////////////////////////////////////////////////////////////////

	private static class ManifestInfo {
		private String rsrcMainClass;
		private String[] rsrcClassPath;
		public String getRsrcMainClass() {
			return rsrcMainClass;
		}
		public void setRsrcMainClass(String rsrcMainClass) {
			this.rsrcMainClass = rsrcMainClass;
		}
		public String[] getRsrcClassPath() {
			return rsrcClassPath;
		}
		public void setRsrcClassPath(String[] rsrcClassPath) {
			this.rsrcClassPath = rsrcClassPath;
		}
	}

	///////////////////////////////////////////////////////////////////////////

	private static String[] splitSpaces(String line) throws Exception {

		if (line == null)
			return null;

		List<String> list = new ArrayList<>();
		String[] arrLine = line.split("\\s+");

		for (String str : arrLine) {
			if ("".equals(str = str.trim()))
				continue;

			list.add(str);
		}

		return (String[]) list.toArray(new String[list.size()]);
	}

	private static ManifestInfo getManifestInfo() throws Exception {

		Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(JarFile.MANIFEST_NAME);
		while (urls.hasMoreElements()) {
			URL url = (URL) urls.nextElement();
			if (!flag) System.out.printf(">>>>> url = %s%n", url);

			InputStream is = url.openStream();
			if (is == null)
				continue;

			Manifest manifest = new Manifest(is);
			Attributes attributes = manifest.getMainAttributes();
			if (!flag) {
				for (Map.Entry<Object, Object> entry : attributes.entrySet()) {
					System.out.printf(">>>>> Attributes [%s] = [%s]%n"
							, String.valueOf(entry.getKey())
							, String.valueOf(entry.getValue()));
				}
			}

			if (attributes.getValue("Rsrc-Main-Class") == null)
				continue;

			ManifestInfo manifestInfo = new ManifestInfo();
			manifestInfo.setRsrcMainClass(attributes.getValue("Rsrc-Main-Class").trim());
			manifestInfo.setRsrcClassPath(splitSpaces(attributes.getValue("Rsrc-Class-Path")));

			return manifestInfo;
		}

		if (flag) throw new Exception("Missing attributes for JarRsrcLoader is Manifest (Rsrc-Main-Class, Rsrc-Class-Path)");

		return null;
	}

	///////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		if (!flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());

		if (flag) {
			ManifestInfo manifestInfo = getManifestInfo();

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL.setURLStreamHandlerFactory(new RsrcURLStreamHandlerFactory(classLoader));

			URL[] rsrcUrls = new URL[manifestInfo.getRsrcClassPath().length];
			for (int i=0; i < manifestInfo.getRsrcClassPath().length; i++) {
				String rsrcPath = manifestInfo.getRsrcClassPath()[i];
				if (!flag) System.out.printf(">>>>> rsrcPath = %s%n", rsrcPath);

				if (rsrcPath.endsWith("/")) {
					rsrcUrls[i] = new URL("rsrc:" + rsrcPath);
				} else {
					rsrcUrls[i] = new URL("jar:rsrc:" + rsrcPath + "!/");
				}
				if (!flag) System.out.printf(">>>>> rsrcUrl = %s%n", rsrcUrls[i]);
			}

			if (flag) {
				ClassLoader jceClassLoader = new URLClassLoader(rsrcUrls, null);
				Thread.currentThread().setContextClassLoader(jceClassLoader);

				Class<?> cls = Class.forName(manifestInfo.getRsrcMainClass(), true, jceClassLoader);
				Method main = cls.getMethod("main", new Class[] { args.getClass() });
				main.invoke((Object) null, new Object[] { args });
			}
		}
	}

	private static void test02(String[] args) throws Exception {
		if (!flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());

		if (flag) {
			ManifestInfo manifestInfo = getManifestInfo();

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL.setURLStreamHandlerFactory(new RsrcURLStreamHandlerFactory(classLoader));

			URL[] rsrcUrls = new URL[manifestInfo.getRsrcClassPath().length];
			for (int i=0; i < manifestInfo.getRsrcClassPath().length; i++) {
				String rsrcPath = manifestInfo.getRsrcClassPath()[i];
				if (!flag) System.out.printf(">>>>> rsrcPath = %s%n", rsrcPath);

				if (rsrcPath.endsWith("/")) {
					rsrcUrls[i] = new URL("rsrc:" + rsrcPath);
				} else {
					rsrcUrls[i] = new URL("jar:rsrc:" + rsrcPath + "!/");
				}
				if (!flag) System.out.printf(">>>>> rsrcUrl = %s%n", rsrcUrls[i]);
			}

			if (flag) {
				ClassLoader jceClassLoader = new URLClassLoader(rsrcUrls, null);
				Thread.currentThread().setContextClassLoader(jceClassLoader);

				Class<?> cls = Class.forName(manifestInfo.getRsrcMainClass(), true, jceClassLoader);
				Method main = cls.getMethod("main", new Class[] { args.getClass() });
				main.invoke((Object) null, new Object[] { args });
			}
		}
	}

	private static void test03(String[] args) throws Exception {
		if (!flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());

		if (!flag) {
			String resourcePath = new Object() {}.getClass().getEnclosingClass().getName().replace('.', '/');
			if (flag) System.out.printf(">>>>> %s%n", resourcePath);
			
			ResourceBundle rb = ResourceBundle.getBundle(resourcePath);
			for (String key : rb.keySet()) {
				String val = rb.getString(key);
				if (flag) System.out.printf(">>>>> [%s=%s]%n", key, val);
			}
			
			if (flag) System.out.println(">>>>> args = " + Arrays.asList(args));
		}
		
		if (flag) {
			ManifestInfo manifestInfo = getManifestInfo();

			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			URL.setURLStreamHandlerFactory(new RsrcURLStreamHandlerFactory(classLoader));

			URL[] rsrcUrls = new URL[manifestInfo.getRsrcClassPath().length];
			for (int i=0; i < manifestInfo.getRsrcClassPath().length; i++) {
				String rsrcPath = manifestInfo.getRsrcClassPath()[i];
				if (!flag) System.out.printf(">>>>> rsrcPath = %s%n", rsrcPath);

				if (rsrcPath.endsWith("/")) {
					rsrcUrls[i] = new URL("rsrc:" + rsrcPath);
				} else {
					rsrcUrls[i] = new URL("jar:rsrc:" + rsrcPath + "!/");
				}
				if (!flag) System.out.printf(">>>>> rsrcUrl = %s%n", rsrcUrls[i]);
			}

			if (flag) {
				ClassLoader jceClassLoader = new URLClassLoader(rsrcUrls, null);
				Thread.currentThread().setContextClassLoader(jceClassLoader);

				String resourcePath = new Object() {}.getClass().getEnclosingClass().getName().replace('.', '/');
				ResourceBundle rb = ResourceBundle.getBundle(resourcePath);
				
				if (args.length == 0) {
					String mainClass = rb.getString("org.tain.runjar.default");
					Class<?> cls = Class.forName(mainClass, true, jceClassLoader);
					Method main = cls.getMethod("main", new Class[] { args.getClass() });
					main.invoke((Object) null, new Object[] { args });
				} else {
					for (String arg : args) {
						String key = "org.tain.runjar." + arg;
						String mainClass = rb.getString(key);
						
						Class<?> cls = Class.forName(mainClass, true, jceClassLoader);
						Method main = cls.getMethod("main", new Class[] { args.getClass() });
						main.invoke((Object) null, new Object[] { args });
						
						try { Thread.sleep(2000); } catch (InterruptedException e) {}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		if (!flag) System.out.println(">>>>> " + ClassUtils.getClassInfo());

		if (!flag) {
			args = new String[] { "test01", "test02", };
		}
		
		if (!flag) test01(args);
		if (!flag) test02(args);
		if (flag) test03(args);
	}
}
