package com.andios.tourism.util;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 首字母转大写
	 * 
	 * @param str
	 * @return
	 */
	public static String toFirstLetterUpperCase(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		return str.substring(0, 1).toUpperCase()
				+ str.substring(1, str.length());
	}
	
	public static boolean checkCarId(String carId){
		//沪N53378
		String carIdRegex = "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学]{1}$";
		Pattern p = Pattern.compile(carIdRegex);
		Matcher m = p.matcher(carId);
		return m.matches();
	}

	public static boolean isValid(String str) {
		if (str != null && !"NULL".equalsIgnoreCase(str) && str.trim().length() > 0) {
			return true;
		}
		return false;
	}

	public static String convertNumber(Number value) {
		if (value == null) {
			return "";
		} else {
			DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance();
			df.setMaximumFractionDigits(2);
			return df.format(value);
		}
	}
	
	public static String randomString(int length) {
	    final String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";  
	    Random random = new Random();
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < length; i++) {
	        int number = random.nextInt(base.length());
	        System.out.println(number);
	        sb.append(base.charAt(number));
	    }
	    return sb.toString();  
	 }
	
	/**
	 * String转Byte[]
	 * @param str
	 * @return
	 */
	public static byte[] String2byte(String str) {
		byte[] result = new byte[str.length() / 2];
		int index = 0;
		for (int i = 0; i < str.length(); i += 2) {
			result[index++] = (byte) Integer.parseInt(str.substring(i, i + 2),
					16);
		}
		return result;
	}

}
