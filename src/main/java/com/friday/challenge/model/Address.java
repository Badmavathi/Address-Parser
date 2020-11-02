package com.friday.challenge.model;

import com.friday.challenge.util.JSONOrderedObject;
/**
 * 
 * @author Badmavathi Balaji
 *Address POJO class
 */

public class Address {
	private String street;
	private String housenumber;
	
	public Address(String street, String housenumber) {
		this.street = street != null ? street.trim() : null;
		this.housenumber = housenumber != null ? housenumber.trim() : null;
	}

	@Override
	public String toString() {
		JSONOrderedObject jo = new JSONOrderedObject();
		jo.put("street", street);
		jo.put("housenumber", housenumber);
		return jo.toJSONString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((housenumber == null) ? 0 : housenumber.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null)
			return false;
		else if (!(obj instanceof Address))
			return false;
		
		Address other = (Address) obj;	
		return this.housenumber.equals(other.housenumber) && this.street.equals(other.street);
	
	}
}
