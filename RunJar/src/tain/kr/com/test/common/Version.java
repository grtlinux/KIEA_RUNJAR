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
package tain.kr.com.test.common;

import java.util.ResourceBundle;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Version.java
 *   -. Package    : tain.kr.common
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 28. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Version {

	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String clsName = null;
	
	private String desc = null;
	private String version = null;
	
	private Version() throws Exception {
		if (flag) {
			this.clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(this.clsName.replace('.', '/'));
			
			this.desc = rb.getString("tain.kr.common.version.desc");
			this.version = rb.getString("tain.kr.common.version");
		}
	}
	
	public String getDesc() throws Exception {
		return this.desc;
	}
	
	public String getVersion() throws Exception {
		return this.version;
	}
	
	public void print() throws Exception {
		if (flag) {
			System.out.println("desc > " + this.desc);
			System.out.println("version > " + this.version);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Version instance = null;
	
	public static synchronized Version getInstance() throws Exception {
		
		if (instance == null) {
			instance = new Version();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Version.getInstance().print();
		}
	}
	
	public static void main(String[] args) throws Exception {
		if (flag) System.out.println(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
