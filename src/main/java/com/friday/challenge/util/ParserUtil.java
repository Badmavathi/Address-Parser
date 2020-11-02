package com.friday.challenge.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Badmavathi Balaji
 * Util class functions to apply logic in the  
 * address entered by the user
 */

public class ParserUtil {

	public Boolean beginsWithNum(String addr) {
		Pattern pattern = Pattern.compile("^[0-9][A-Za-z0-9 - _ , .]*$");
		Matcher m = pattern.matcher(addr);
		if (m.matches()) {
			return true;
		}
		return false;
	}

	public int getLastIndexOfNumber(List<String> addrList) {
		int index = -1;
		for (int i = addrList.size() - 1; i >= 0; i--) {
			if (beginsWithNum(addrList.get(i))) {
				index = i;
				break;
			}
		}
		return index;
	}
}
