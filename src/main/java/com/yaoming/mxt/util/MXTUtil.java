package com.yaoming.mxt.util;

import java.util.HashMap;
import java.util.Map;

public final class MXTUtil {
	
	// 数据库连接信息
	
	private static String connectionUrl = "jdbc:sqlserver://127.0.0.1:7788;" + "databaseName=mxt;user=sa;password=123456;";
//	private static String connectionUrl = "jdbc:sqlserver://192.168.28.199:1433;" + "databaseName=db_test2;user=sa;password=MxT@0592;";
	
	
	// 将存储过程返回的收入明细字符串分解成[A:B]的Map
	public static Map<String, Double> convert2DetailStringToMap(String string) {

		// 字符串处理
		String[] strs = string.split(";");

		Map<String, Double> income_map = new HashMap<String, Double>();

		for (int i = 0; i < strs.length; i++) {
			String row = strs[i].toString();
			String[] arr = row.split(":");
			income_map.put(arr[0], Double.parseDouble(arr[1]));
		}

		return income_map;

	}
	
	// 将存储过程返回的收入明细字符串分解成[A:[B:C]]的Map
	public static Map<String, Map<Double,Double>> convert3DetailStringToMap(String string) {

		// 字符串处理
		String[] strs = string.split(";");

		Map<String, Map<Double,Double>> totalMap = new HashMap<String, Map<Double,Double>>();

		for (int i = 0; i < strs.length; i++) {
			String row = strs[i].toString();
			
			String[] arr = row.split(":");
			String title = arr[0];
			String[] subarr = arr[1].split(",");

			
			Map<Double,Double> subMap = new  HashMap<Double, Double>();
			
			subMap.put(Double.parseDouble(subarr[0]), Double.parseDouble(subarr[1]));
			totalMap.put(title, subMap);
			

		}

		return totalMap;

	}
	
	// 返回数据库连接信息
	public static String getDBConnectionUrl() {
		
		return connectionUrl;
	}

}
