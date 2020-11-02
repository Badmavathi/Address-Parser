package com.friday.challenge.parser;

import com.friday.challenge.model.Address;
/**
 * 
 * @author Badmavathi Balaji
 * Interface for the Address Parser, 
 * implement this interface for to parse various different country addresses.
 */
public interface AddressParser {
	public abstract Address parse(String address); 
}
