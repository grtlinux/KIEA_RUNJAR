/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----------------------------------------------------------------
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.test.util;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CheckSystem.java
 *   -. Package    : tain.kr.util
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 28. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CheckSystem {

	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String clsName = null;
	
	private String systemKey = null;
	private String strWin = null;
	private String strLinux = null;
	
	private Properties prop = null;
	
	private CheckSystem() throws Exception {
		
		if (flag) {
			this.clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(this.clsName.replace('.', '/'));
			
			this.systemKey = rb.getString("tain.kr.util.check.system.key");
			this.strWin = rb.getString("tain.kr.util.check.system.win.string");
			this.strLinux = rb.getString("tain.kr.util.check.system.linux.string");
			
			this.prop = System.getProperties();
		}
	}
	
	private String get(String key) throws Exception {
		
		String val = null;
		
		if (flag) {
			val = this.prop.getProperty(key);
		}
		
		return val;
	}
	
	private String get(String key, String def) throws Exception {
		
		String val = null;
		
		if (flag) {
			val = this.prop.getProperty(key, def);
		}
		
		return val;
	}
	
	public boolean isWindows() throws Exception {
		
		boolean ret = false;

		if (!flag) {
			String osName = get(this.systemKey, "");
			if (osName.indexOf("Win", 0) >= 0) {
				return true;
			}
		}
		
		if (flag) {
			String osName = get(this.systemKey);
			if (osName.indexOf("Win", 0) >= 0) {
				return true;
			}
		}
		
		return ret;
	}
	
	public boolean isLinux() throws Exception {
		return isWindows() ? false : true;		
	}
	
	public String getSystemName() throws Exception {
		
		if (isLinux()) {
			return this.strLinux;
		} else {
			return this.strWin;
		}
	}
	
	public void print() throws Exception {
		
		if (flag) System.out.println("info > " + getSystemName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static CheckSystem instance = null;
	
	public static synchronized CheckSystem getInstance() throws Exception {
		
		if (instance == null) {
			instance = new CheckSystem();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			CheckSystem.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) System.out.println(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
