package com.friday.address;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.friday.challenge.parser.AddressParser;
import com.friday.challenge.parser.AddressParserFactory;
import com.friday.challenge.parser.EuropeanAddressParser;
import com.friday.challenge.parser.AddressParserFactory.ParserType;

public class AddressParserFactoryTest {
	AddressParserFactory parserFactory = new AddressParserFactory();
	
	@Test
	@DisplayName("Tests whether EuropeanAddressParser instance is returned from parser factory")
	public void testParserFactoryReturnsEuropeanParser() {
		AddressParser parserObj = parserFactory.getAddressParser(ParserType.EUROPEAN_PARSER);
		assertTrue(parserObj instanceof EuropeanAddressParser);
	}
	
	@Test
	@DisplayName("Tests whether null is returned from parser factory if null is the input")
	public void testParserFactoryReturnsNull() {
		AddressParser parserObj = parserFactory.getAddressParser(null);
		assertTrue(parserObj == null);
	}

}
