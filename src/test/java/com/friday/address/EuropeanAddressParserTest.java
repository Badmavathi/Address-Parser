package com.friday.address;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.friday.challenge.model.Address;
import com.friday.challenge.parser.AddressParser;
import com.friday.challenge.parser.AddressParserFactory;
import com.friday.challenge.parser.AddressParserFactory.ParserType;

public class EuropeanAddressParserTest {

	private AddressParser addressParser = (new AddressParserFactory()).getAddressParser(ParserType.EUROPEAN_PARSER);
	
	@Test
	@DisplayName("Address parser test - Starts with number - With comma")
	public void testStartsWithNumberWithComma() {
		String inputAddress = "4, rue de la revolution";
		Address expectedOutput = new Address("rue de la revolution", "4");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Starts with number - Without comma")
	public void testStartsWithNumberWithoutComma() {
		String inputAddress = "4 rue de la revolution";
		Address expectedOutput = new Address("rue de la revolution", "4");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Starts with number - With space in house number")
	public void testStartsWithNumberWithSpaceInHouseNum() {
		String inputAddress = "123 B Blaufeldweg";
		Address expectedOutput = new Address("Blaufeldweg", "123 B");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Starts with number - Without comma - Only Two Tokens")
	public void testStartsWithNumberWithoutCommaAndTwoTokens() {
		String inputAddress = "200 Broadway";
		Address expectedOutput = new Address("Broadway", "200");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	

	
	@Test
	@DisplayName("Address parser test - Starts with number - With comma and prefix ")
	public void testStartsWithNumberWithCommaAndPrefix() {
		String inputAddress = "No 4, rue de la revolution";
		Address expectedOutput = new Address("rue de la revolution", "No 4");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	
	@Test
	@DisplayName("Address parser test - Ends with number - Without comma")
	public void testEndsWithNumberWithoutComma() {
		String inputAddress = "Winterallee 3";
		Address expectedOutput = new Address("Winterallee", "3");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}

	@Test
	@DisplayName("Address parser test - Ends with string house number - Without comma")
	public void testEndsWithStringHouseNumberWithoutComma() {
		String inputAddress = "Blaufeldweg 123B";
		Address expectedOutput = new Address("Blaufeldweg", "123B");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Ends with house number - With German umlaut")
	public void testEndsWithNumberWithGermanUmlaut() {
		String inputAddress = "Am Bächle 23";
		Address expectedOutput = new Address("Am Bächle", "23");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Ends with house number with space")
	public void testEndsWithNumberWithSpace() {
		String inputAddress = "Auf der Vogelwiese 23 b";
		Address expectedOutput = new Address("Auf der Vogelwiese", "23 b");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Ends with house number with prefix")
	public void testEndsWithNumberWithSpaceAndPrefix() {
		String inputAddress = "Calle 39 No 1540";
		Address expectedOutput = new Address("Calle 39", "No 1540");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	
	@Test
	@DisplayName("Address parser test - Ends with house number with comma")
	public void testEndsWithNumberWithComma() {
		String inputAddress = "Calle Aduana, 29";
		Address expectedOutput = new Address("Calle Aduana", "29");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Ends with house number with Comma and has prefix")
	public void testEndsWithNumberWithCommaAndHasPrefix() {
		String inputAddress = "rue de la revolution , No 4";
		Address expectedOutput = new Address("rue de la revolution", "No 4");
		assertTrue(expectedOutput.equals(addressParser.parse(inputAddress)));
	}
	
	@Test
	@DisplayName("Address parser test - Single word address - verify if it throws IllegalArgumentException")
	public void testSingleWordAddress() {
		String inputAddress = "Blaufeld";
		String expectedErrorMsg = "Please enter a valid Address. Eg : Friedrichstrasse 10";
		Exception exception  = assertThrows(IllegalArgumentException.class, ()->{
			addressParser.parse(inputAddress);
		});
		
		if(exception != null) {
			assertTrue(expectedErrorMsg.equals(exception.getMessage()));
		}else {
			assertTrue(false);
		}
	}
	
	@Test
	@DisplayName("Address parser test -Input without house number - verify if it throws IllegalArgumentException")
	public void testAddressWithoutHouseNumber() {
		String inputAddress = "Blaufeld Str";
		String expectedErrorMsg = "Please enter valid House number";
		Exception exception  = assertThrows(IllegalArgumentException.class, ()->{
			addressParser.parse(inputAddress);
		});
		
		if(exception != null) {
			assertTrue(expectedErrorMsg.equals(exception.getMessage()));
		}else {
			assertTrue(false);
		}
	}
	
	
	@Test
	@DisplayName("Address parser test -Input as null - verify if it throws IllegalArgumentException")
	public void testAddressWithNullInput() {
		String inputAddress = null;
		String expectedErrorMsg = "Please enter an input Address. Eg : Friedrichstrasse 10";
		Exception exception  = assertThrows(IllegalArgumentException.class, ()->{
			addressParser.parse(inputAddress);
		});
		
		if(exception != null) {
			assertTrue(expectedErrorMsg.equals(exception.getMessage()));
		}else {
			assertTrue(false);
		}
	}
}
