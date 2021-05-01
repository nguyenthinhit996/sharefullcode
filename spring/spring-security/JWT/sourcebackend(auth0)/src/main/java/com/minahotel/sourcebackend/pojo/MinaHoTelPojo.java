package com.minahotel.sourcebackend.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinaHoTelPojo {

	private Object[] idHashCode;

	public void setIdHashCode(Object... objects) {
		this.idHashCode = objects;
	}

	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHashCode == null) ? 0 : idHashCode.hashCode());
		return result;
	}

	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MinaHoTelPojo other = (MinaHoTelPojo) obj;
		if (idHashCode == null) {
			if (other.idHashCode != null)
				return false;
		} else if (!Arrays.equals(idHashCode, other.idHashCode))
			return false;
		return true;
	}

	public static List<MinaHoTelPojo> convertToListMinaHotel(Iterable<? extends MinaHoTelPojo> iterable) {
		List<MinaHoTelPojo> result = new ArrayList<MinaHoTelPojo>();
		for (Object str : iterable) {
			if(str instanceof MinaHoTelPojo) {
				MinaHoTelPojo parseParent = (MinaHoTelPojo) str;
				result.add(parseParent);
			}
		}

		return result;
	}
	
	 
}
