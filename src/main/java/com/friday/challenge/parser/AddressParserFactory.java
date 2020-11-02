package com.friday.challenge.parser;

/**
 * 
 * @author Badmavathi Balaji
 * Factory class to call the appropriate address parser class
 */

public class AddressParserFactory {

	public enum ParserType {
		EUROPEAN_PARSER
	}

	public AddressParser getAddressParser(ParserType parserType) {
		AddressParser addressParser = null;
		
		if (ParserType.EUROPEAN_PARSER.equals(parserType)) {
			addressParser = new EuropeanAddressParser();
		}
		
		return addressParser;
	}
}
