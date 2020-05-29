package com.simple.util;

public class StringUtil {


	/**
	 * 문자열의 줄바꿈문자를 &lt;br&gt;로 변환해서 반환한다.
	 * @param text
	 * @return
	 */
	public static String strWithBr(String text) {
		if(text == null) {
			return "";
		}
		return text.replace(System.lineSeparator(), "<br/>");
	}
	/**
	 * 문자열 값이 null 이면 지정된 defaultValue 값을 반환한다.
	 * @param str null 일지 체크할 문자열
	 * @param defaultValue null 일때 반환할 기본 값
	 * @return
	 */
	public static String nullToValue(String str, String defaultValue) {
		if(str == null) {
			return defaultValue;
		}
		return str;
	}
	/**
	 * 문자열 값이 null 이면 "" 을 반환한다.
	 * @param str null인지 체크할 문자열
	 * @return
	 */
	public static String nullToblack(String str) {
		return nullToValue(str, "");
	}
	/**
	 * 문자열을 정수로 변환해서 반환한다.
	 * @param str 문자열
	 * @param defaultNumber 기본값
	 * @return 정수, 숫자가 아닌 문자가 포함된 경우 기본값이 반환된다.
	 */
	public static long stringToLong(String str, long defaultNumber) {
		try {
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	/**
	 * 문자열을 정수로 변환해서 반환한다.
	 * @param str 문자열
	 * @return 정수, 숫자가 아닌 문자가 포함된 경우 0이 반환된다.
	 */
	public static long stringToLong(String str) {
		return stringToLong(str,0);
	}
	/**
	 * 문자열을 정수로 변환해서 반환한다.
	 * @param str 문자열
	 * @param defaultNumber 기본값
	 * @return 정수, 숫자가 아닌 문자가 포함된 경우 기본 값이 반환된다.
	 */
	public static int stringToInt(String str, int defaultNumber) {
		try {
			return Integer.parseInt(str);
		} catch ( NumberFormatException e) {
			return defaultNumber;
		}
	}
	/**
	 * 문자열을 정수로 변환해서 반환한다.
	 * @param str 문자열
	 * @return 정수, 숫자가 아닌 경우 문자가 포함된 경우 0이 반환된다.
	 */
	public static int stringToInt(String str) {
		return stringToInt(str, 0);
	}
	/**
	 * 문자열을 실수로 변환해서 반환한다.
	 * @param str 문자열
	 * @param defaultNumber 기본값
	 * @return 실수, 숫자가 아닌 문자가 포함된 경우 기본값이 반환된다.
	 */
	public static double stringToDouble(String str, double defaultNumber) {
		try {
			return Double.parseDouble(str);
		} catch (NumberFormatException e) {
			return defaultNumber;
		}
	}
	/**
	 * 문자열을 실수로 변환해서 반환한다.
	 * @param str 문자열
	 * @return 실수, 숫자가 아닌 문자가 포함된 경우 0.0이 반환된다.
	 */
	public static double stringToDouble(String str) {
		return stringToDouble(str, 0.0);
	}
}
