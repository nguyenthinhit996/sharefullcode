package com.sharefullcode.blogspot;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class CheckUtil {
	
	
	public boolean isEmplty(String str) {
		 return StringUtils.isEmpty(str);
	}
	
	public boolean isNumber(String str) {
		 return StringUtils.isNumeric(str);
	}
	
	public boolean isParsable(String str) {
		return NumberUtils.isParsable(str);
	}
	
}
