package com.simple.util;

import java.text.DecimalFormat;

public class NumberUtil {

	private static DecimalFormat currencyFormat = new DecimalFormat("#,###");
	/**
	 * 정수를 ,가 포함된 통화표현
	 * @param number
	 * @return
	 */
	
	public static String numberToCurrency(long number) {
		return currencyFormat.format(number);
	}
	
}
