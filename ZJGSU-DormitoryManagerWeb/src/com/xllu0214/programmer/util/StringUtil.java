package com.xllu0214.programmer.util;

/**
 * 字符串共用操作
 * @author XLLU
 *
 */

public class StringUtil {	
	/**
	 * 判断字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null)return true;
		if("".equals(str))return true;
		return false;
	}
	
	/**
	 * 生成学生编号
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String generateSn(String prefix, String suffix){
		String sn = prefix + System.currentTimeMillis() + suffix;
		return sn;
	}
	
	/**
	 * 转换字段
	 * @param string
	 * @return
	 */
	public static String convertToUnderLine(String string){
		String newStr = "";
		if(isEmpty(string))return "";
		for(int i = 0; i < string.length(); i++){
			char c = string.charAt(i);
			if(Character.isUpperCase(c)){
				//如果开头字母为大写字母，则转化为小写字母
				if(i == 0){
					newStr += Character.toLowerCase(c);
					continue;
				}
				newStr += "_" + Character.toLowerCase(c);//加上下划线
				continue;
			}
			newStr += c;
		}
		return newStr;
	}
}
