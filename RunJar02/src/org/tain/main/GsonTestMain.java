package org.tain.main;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class GsonTestMain {

	private static final boolean flag = true;

	//////////////////////////////////////////////////////////////////////
	private static void test01() {
		Gson gson = new Gson();

		if (flag) {
			/*
			 * Person -> JSON -> Person
			 */
			try {
				Person person = new Person();
				person.setName("Kang");
				person.setAge(25);
				person.setAddr("Seoul");

				String strJson = gson.toJson(person);
				System.out.println("test01-1 >>>>> " + strJson);

				person = gson.fromJson(strJson, Person.class);
				System.out.println("test01-1 >>>>> " + person);

				strJson = "{\"age\":25,\"name\":\"Kang\",\"addr\":\"Jeju\"}";
				person = gson.fromJson(strJson, Person.class);
				System.out.println("test01-1 >>>>> " + person);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (flag) {
			/*
			 * JSON(less) -> Person
			 */
			try {
				String strJson = "{\"name\":\"Kang\"}";
				Person person = gson.fromJson(strJson, Person.class);
				System.out.println("test01-2 >>>>> " + person);

				strJson = gson.toJson(person);
				System.out.println("test01-2 >>>>> " + strJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (flag) {
			/*
			 * JSON(more) -> Person
			 */
			try {
				String strJson = "{\"age\":25,\"name\":\"Kang\",\"addr\":\"Jeju\",\"content\":\"This is a information of the one.\"}";
				Person person = gson.fromJson(strJson, Person.class);
				System.out.println("test01-3 >>>>> " + person);

				Type mapType = new TypeToken<Map<String,Object>>(){}.getType();
				Map<String,Object> map = gson.fromJson(strJson, mapType);
				System.out.println("test01-3 >>>>> " + map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static class Person {
		private String name;
		private int age;
		private String addr;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String toString() {
			return String.format("Person ['%s', %d, '%s']", this.getName(), this.getAge(), this.getAddr());
		}
	}

	//////////////////////////////////////////////////////////////////////
	private static void test02() {
		Gson gson = new Gson();

		if (flag) {
			try {
				String strJson = "{\"age\":25,\"name\":\"Kang\",\"addr\":\"Jeju\",\"content\":\"This is a information of the one.\"}";
				Type mapType = new TypeToken<Map<String,Object>>(){}.getType();

				Map<String,Object> map = gson.fromJson(strJson, mapType);
				System.out.println("test02-1 >>>>> " + map);

				strJson = gson.toJson(map);
				System.out.println("test02-2 >>>>> " + strJson);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//////////////////////////////////////////////////////////////////////
	/*
	 * client of Provider, Consumer
	 * in
	 *     reqHeader
	 *     reqBody
	 * out
	 *     resResult
	 */
	private static void test03() {

		Map<String, Object> reqHeader = null;
		Map<String, Object> reqBody = null;
		Map<String, Object> resResult = null;

		if (flag) {
			reqHeader = new HashMap<String, Object>();
			reqBody = new HashMap<String, Object>();

			reqHeader.put("serviceId", "S001");
			reqHeader.put("programId", "SampleImpl01");
			reqHeader.put("sourceServer", "SRC");
			reqHeader.put("targetServer", "TGT");

			reqBody.put("name", "Kang");
			reqBody.put("age", 25);
			reqBody.put("addr", "Seoul");
			reqBody.put("content", "This is a information of the one.");
		}

		if (flag) {
			resResult = operation(reqHeader, reqBody);
		}

		if (flag) {
			/*
			 * print the result of operation - 1
			 */
			for (Map.Entry<String, Object> entry : resResult.entrySet()) {
				String key = entry.getKey();
				Object val = entry.getValue();
				System.out.printf("test03-1 >>>>> [%s:%s]%n", key, val);
			}
		}

		if (flag) {
			/*
			 * print the result of operation - 2
			 */
			Gson gson = new Gson();
			String jsonResult = gson.toJson(resResult);
			System.out.println("test03-2 >>>>> " + jsonResult);
		}

		if (flag) {
			/*
			 * print the JSON with pretty - 3
			 */
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonResult = gson.toJson(resResult);
			System.out.println("test03-3 >>>>> " + jsonResult);
		}

		if (flag) {
			/*
			 * transfer Json to Pretty Json
			 */
			Gson gson = new Gson();
			String jsonResult = gson.toJson(resResult);
			System.out.println("test03-4 >>>>> " + jsonResult);
			String jsonPrettyResult = toPrettyFormat(jsonResult);
			System.out.println("test03-5 >>>>> " + jsonPrettyResult);
		}

		if (flag) {
			/*
			 * transfer Json to ResultBean
			 */
			Gson gson = new Gson();
			String jsonResult = gson.toJson(resResult);
			//ResultBean resultBean = gson.fromJson(jsonResult, ResultBean.class);
			//System.out.println("test03-6 >>>>> " + resultBean);
		}
	}

	private static Map<String, Object> operation(Map<String, Object> reqHeader, Map<String, Object> reqBody) {
		Gson gson = new Gson();

		String jsonHeader;
		String jsonBody;
		String jsonResult;

		if (flag) {
			jsonHeader = gson.toJson(reqHeader);
			jsonBody = gson.toJson(reqBody);
		}

		if (flag) {
			//jsonResult = new EsbWsImpl().operation(jsonHeader, jsonBody);
		}

		Map<String, Object> resResult = null;

		if (flag) {
			//resResult = gson.fromJson(jsonResult, new TypeToken<Map<String, Object>>(){}.getType());
		}

		return resResult;
	}

	private static String toPrettyFormat(String jsonString) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		return gson.toJson(jsonObject);
	}

	//////////////////////////////////////////////////////////////////////
	private static void test04() {

	}

	//////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		if (flag) System.out.println(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());

		if (!flag) test01();
		if (!flag) test02();
		if (flag) test03();
		if (flag) test04();
	}
}
