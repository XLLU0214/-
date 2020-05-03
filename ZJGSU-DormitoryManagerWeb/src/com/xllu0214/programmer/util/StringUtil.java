package com.xllu0214.programmer.util;

/**
 * �ַ������ò���
 * @author XLLU
 *
 */

public class StringUtil {	
	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str == null)return true;
		if("".equals(str))return true;
		return false;
	}
	
	/**
	 * ����ѧ�����
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	public static String generateSn(String prefix, String suffix){
		String sn = prefix + System.currentTimeMillis() + suffix;
		return sn;
	}
	
	/**
	 * ת���ֶ�
	 * @param string
	 * @return
	 */
	public static String convertToUnderLine(String string){
		String newStr = "";
		if(isEmpty(string))return "";
		for(int i = 0; i < string.length(); i++){
			char c = string.charAt(i);
			if(Character.isUpperCase(c)){
				//�����ͷ��ĸΪ��д��ĸ����ת��ΪСд��ĸ
				if(i == 0){
					newStr += Character.toLowerCase(c);
					continue;
				}
				newStr += "_" + Character.toLowerCase(c);//�����»���
				continue;
			}
			newStr += c;
		}
		return newStr;
	}
}
