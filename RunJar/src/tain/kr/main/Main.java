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
package tain.kr.main;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import tain.kr.common.Version;
import tain.kr.util.CheckSystem;
import tain.kr.util.DateTime;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Main.java
 *   -. Package    : tain.kr.main
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 28. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String clsName = null;
	
	private String desc = null;
	
	private Main() {
		if (flag) {
			this.clsName = this.getClass().getName();
			
			ResourceBundle rb = ResourceBundle.getBundle(this.clsName.replace('.', '/'));
			
			this.desc = rb.getString("tain.kr.main.desc");
		}
	}
	
	private String getDesc() throws Exception {
		
		return this.desc;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Version.getInstance().print();
			
			CheckSystem.getInstance().print();
			
			DateTime.getInstance().print();
			
			Main main = new Main();
			log.debug("main > " + main.getDesc());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
