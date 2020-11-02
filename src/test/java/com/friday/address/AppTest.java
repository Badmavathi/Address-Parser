package com.friday.address;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.friday.challenge.main.App;
import com.friday.challenge.model.Address;

/**
 * Unit test for simple App.
 */
public class AppTest {

	private PrintStream standardOut;
	private InputStream standardInput;
	
	@BeforeEach
	public void setUp() {
		standardOut = System.out;
		standardInput = System.in;
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
		System.setIn(standardInput);
	}
	
	
	@Test
	@DisplayName("Checks App class run")
	public void testApp() {
		String addressInput = "FriedrichStr 34\n ";
		String expectedOutput = (new Address("FriedrichStr", "34")).toString();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out, true));
		System.setIn(new BufferedInputStream(new ByteArrayInputStream(addressInput.getBytes())));
		App.main(null);
		assertTrue(out.toString().contains(expectedOutput));
	}
}
